package com.groupdocs.examples.conversion.quick_start.licensing;

import com.groupdocs.conversion.licensing.License;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.LicenseUtils;

import java.io.InputStream;

/**
 * <p>
 * This example demonstrates how to set license from stream.
 * </p>
 */
public class SetLicenseFromStream {

    public static void run() {
        try (final InputStream licenseStream = LicenseUtils.createLicenseStream()) {
            if (licenseStream != null) {

                License license = new License();
                license.setLicense(licenseStream);

            } else {
                System.out.println(
                        "\nWe do not ship any license with this example. " +
                                "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                                "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                                "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license." +
                                "\nCheck README.md to see how to configure the project to obtain license file"
                );
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
            System.err.println("License was NOT set.");
        }
    }
}