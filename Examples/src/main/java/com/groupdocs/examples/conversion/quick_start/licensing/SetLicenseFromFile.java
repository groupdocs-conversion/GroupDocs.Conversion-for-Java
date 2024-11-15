package com.groupdocs.examples.conversion.quick_start.licensing;


import com.groupdocs.conversion.licensing.License;
import com.groupdocs.examples.conversion.utils.FailureRegister;
import com.groupdocs.examples.conversion.utils.LicenseUtils;

/**
 * <p>
 * This example demonstrates how to set license from file.
 * </p><p>
 * <hr>
 * The {@link License#setLicense(String)} method attempts to set a license from several locations
 * relative to the executable. You can also use the
 * additional overload to load a license from a stream, this is useful for
 * instance when the License is stored as an embedded resource.
 * </hr></p>
 */
public class SetLicenseFromFile {

    public static void run() {
        try {
            final String licensePath = LicenseUtils.obtainLicensePath();
            if (!LicenseUtils.isUrl(licensePath)) {

                License license = new License();
                license.setLicense(licensePath);

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
