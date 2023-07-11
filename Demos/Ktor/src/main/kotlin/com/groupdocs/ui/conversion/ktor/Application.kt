package com.groupdocs.ui.conversion.ktor

import com.groupdocs.conversion.licensing.License
import com.groupdocs.ui.conversion.ktor.config.ApplicationConfig
import com.groupdocs.ui.conversion.ktor.config.ConverterConfig
import com.groupdocs.ui.conversion.ktor.di.ModulesInjection
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.hocon.Hocon
import org.koin.core.logger.PrintLogger
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import java.io.BufferedInputStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@ExperimentalSerializationApi
@KtorExperimentalAPI
fun main(args: Array<String>) {
    val environment = System.getenv()["ENVIRONMENT"] ?: handleDefaultEnvironment()
    val applicationConfig = extractApplicationConfig(environment)
    val converterConfig by lazy { extractConverterConfig() }

    embeddedServer(Netty, port = applicationConfig.port) {
        println("Starting instance in ${applicationConfig.host}:${applicationConfig.port}")
        module {
            install(Koin) {
                logger(PrintLogger())
                modules(
                    module {
                        single { applicationConfig }
                        single { converterConfig }
                    },
                    ModulesInjection.controllerBeans,
                    ModulesInjection.usecaseBeans,
                    ModulesInjection.managerBeans
                )
            }
            main()
        }

        setGroupdocsLicense(converterConfig.licensePathOrDefault)
    }.start(wait = true)
}

fun handleDefaultEnvironment(): String {
    println("Falling back to default environment 'dev'")
    return "dev"
}

fun Application.main() {
    module()
}

fun extractApplicationConfig(environment: String): ApplicationConfig {
    val hoconConfig = HoconApplicationConfig(ConfigFactory.load("application.conf"))
    val hoconEnvironment = hoconConfig.config("ktor.deployment.$environment")

    return ApplicationConfig(
        hoconEnvironment.property("host").getString(),
        Integer.parseInt(hoconEnvironment.property("port").getString())
    )
}

@OptIn(ExperimentalSerializationApi::class)
fun extractConverterConfig(): ConverterConfig {
    val hocon = Hocon {
        useConfigNamingConvention = false
    }
    return hocon.decodeFromConfig(ConverterConfig.serializer(), ConfigFactory.load("converter.conf"))
}

fun Application.setGroupdocsLicense(licensePath: String) {
    try {
        log.debug("Setting Groupdocs license...")

        val licenseExtension = Defaults.DEFAULT_LICENSE_EXTENSION
        val license = License()
        if (licensePath.startsWith("http://") || licensePath.startsWith("https://")) {
            val url = URL(licensePath)
            BufferedInputStream(url.openStream()).use { inputStream -> license.setLicense(inputStream) }
        } else {
            val path = Paths.get(licensePath)
            if (Files.exists(path)) {
                if (Files.isRegularFile(path)) {
                    license.setLicense(licensePath)
                } else {
                    Files.list(path).use { pathStream ->
                        val first =
                            pathStream.filter { path ->
                                path.endsWith(licenseExtension)
                            }.findFirst()
                        first.ifPresent { licensePath: Path? ->
                            license.setLicense(licensePath?.toString())
                        }
                    }
                }
            }
        }
    } catch (e: Exception) {
        log.warn("Can not verify Conversion license!", e)
    }
}
