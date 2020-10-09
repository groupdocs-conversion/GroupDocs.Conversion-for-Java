package com.groupdocs.conversion.examples.quick_start;

import com.groupdocs.conversion.licensing.Metered;

/**
 * This example demonstrates how to set Metered license.
 * Learn more about Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
 */
public class SetMeteredLicense {
    public static void run() {
        String publicKey = "*****";
        String privateKey = "*****";

        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);

        System.out.print("License set successfully.");
    }
}