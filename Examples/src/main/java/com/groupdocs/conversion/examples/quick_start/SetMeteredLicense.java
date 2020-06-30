package com.groupdocs.conversion.examples.quick_start;

import com.groupdocs.conversion.licensing.Metered;
/**
* This example demonstrates how to set Metered license.
* Learn more about Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
*/
public class SetMeteredLicense {
    public static void run()
    {
        String publicKey = "58170a16ca67489194199c30ee2b5ea0";
        String privateKey = "mfMD9Pm5r4JypH7nQCDMSHZmGs8knji-YQ3SszNRTJ7qloJWTzGik8tWXClu1WQssnjpUlBrFsgb261ROotlj3qh1uExL3x4Z0KnivrD-xe5wxGmUHepva7Ur9ct4cexlApgvWhhFpMFvzhncFVUYf1nwk1Twi6Gk3Du*9mxbs8";

        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);

        System.out.print("License set successfully.");
    }
}