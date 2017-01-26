package org.skylabase.sms.util;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.skylabase.sms.constants.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 1/26/17.
 */
public class SendSMS {

    public static void sendSMS(String sender, String message, String receiver){
        try {
            TwilioRestClient client = new TwilioRestClient(Constants.getAccountSid(), Constants.getAuthToken());

            // Build a filter for the MessageList
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Body", message + " From " + sender));
            params.add(new BasicNameValuePair("To", receiver)); //Add real number here
            params.add(new BasicNameValuePair("From", Constants.getTwilioNumber()));
            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            com.twilio.sdk.resource.instance.Message msg = messageFactory.create(params);
            System.out.println(msg.getSid());
        }
        catch (TwilioRestException e) {
            System.out.println(e.getErrorMessage());
        }

    }

    public static void sendSMS(String sender, String message, String receiver, String fromName) {
        try {
            TwilioRestClient client = new TwilioRestClient(Constants.getAccountSid(), Constants.getAuthToken());

            // Build a filter for the MessageList
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Body", message + " From " + sender));
            params.add(new BasicNameValuePair("To", receiver)); //Add real number here
            params.add(new BasicNameValuePair("From", fromName));
            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            com.twilio.sdk.resource.instance.Message msg = messageFactory.create(params);
            System.out.println(msg.getSid());
        }
        catch (TwilioRestException e) {
            System.out.println(e.getErrorMessage());
        }
    }
}
