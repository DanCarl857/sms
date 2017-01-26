package org.skylabase.sms.constants;

/**
 * Created by daniel on 1/26/17.
 */
public class Constants {

    private static final String ACCOUNT_SID = "ACd7f8a39d487b197119c7b7100320187c";
    private static final String AUTH_TOKEN = "7c1b81c493020859b27c49786895599d";
    private static final String TWILIO_NUMBER = "ExcelAndCo";

    public static String getAccountSid() {
        return ACCOUNT_SID;
    }

    public static String getAuthToken() {
        return AUTH_TOKEN;
    }

    public static String getTwilioNumber() {
        return TWILIO_NUMBER;
    }
}
