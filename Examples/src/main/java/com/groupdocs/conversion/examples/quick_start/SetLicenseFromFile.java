package com.groupdocs.conversion.examples.quick_start;

import com.groupdocs.conversion.License;
import com.groupdocs.conversion.examples.Constants;

import java.io.File;
/**
* This example demonstrates how to set license from file.
*
*
* The SetLicense method attempts to set a license from several locations relative to the executable and GroupDocs.Conversion.dll.
* You can also use the additional overload to load a license from a stream, this is useful for instance when the
* License is stored as an embedded resource.
*/
public class SetLicenseFromFile {
    public static void run()
    {
        File file = new File(Constants.LicensePath);
        if (file.exists())
        {
            License license = new License();
            license.setLicense(Constants.LicensePath);

            System.out.print("License set successfully.");
        }
        else
        {
            System.out.print("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}