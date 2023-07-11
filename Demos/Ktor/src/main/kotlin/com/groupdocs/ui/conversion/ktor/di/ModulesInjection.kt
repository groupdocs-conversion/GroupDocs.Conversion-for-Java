package com.groupdocs.ui.conversion.ktor.di

import com.groupdocs.ui.conversion.ktor.manager.PathManager
import com.groupdocs.ui.conversion.ktor.manager.PathManagerImpl
import com.groupdocs.ui.conversion.ktor.modules.config.ConfigController
import com.groupdocs.ui.conversion.ktor.modules.config.ConfigControllerImpl
import com.groupdocs.ui.conversion.ktor.modules.convert.ConvertController
import com.groupdocs.ui.conversion.ktor.modules.convert.ConvertControllerImpl
import com.groupdocs.ui.conversion.ktor.modules.download.DownloadController
import com.groupdocs.ui.conversion.ktor.modules.download.DownloadControllerImpl
import com.groupdocs.ui.conversion.ktor.modules.tree.TreeController
import com.groupdocs.ui.conversion.ktor.modules.tree.TreeControllerImpl
import com.groupdocs.ui.conversion.ktor.modules.upload.UploadController
import com.groupdocs.ui.conversion.ktor.modules.upload.UploadControllerImpl
import com.groupdocs.ui.conversion.ktor.usecase.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

object ModulesInjection {
    val controllerBeans = module {
        singleOf(::ConfigControllerImpl) { bind<ConfigController>() }
        singleOf(::TreeControllerImpl) { bind<TreeController>() }
        singleOf(::DownloadControllerImpl) { bind<DownloadController>() }
        singleOf(::UploadControllerImpl) { bind<UploadController>() }
        singleOf(::ConvertControllerImpl) { bind<ConvertController>() }

    }
    val usecaseBeans = module {
        singleOf(::GetLocalFilesUseCase)
        singleOf(::AreFilesSupportedUseCase)
        singleOf(::SaveStreamToFilesDirectoryUseCase)
    }
    val managerBeans = module {
        singleOf(::PathManagerImpl) { bind<PathManager>() }
    }
}