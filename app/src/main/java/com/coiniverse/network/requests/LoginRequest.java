package com.coiniverse.network.requests;

import android.net.Uri;

import com.coiniverse.constants.Constants;
import com.coiniverse.network.responses.LoginResponse;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 8/5/14.
 */
public class LoginRequest extends GenericRequest {

    private final static String PASSWORD_KEY = "login_attempt[password]";
    private final static String EMAIL_KEY = "login_attempt[email]";

    private String mPassword;
    private String mEmail;

    public LoginRequest(String email, String password) {
        super(Uri.parse(Constants.LOGIN_URL));
        this.mPassword = password;
        this.mEmail = email;
    }

    public HttpEntity getEntity() throws UnsupportedEncodingException {
        List<NameValuePair> nameValuePairsLevel = new ArrayList<>(2);
        nameValuePairsLevel.add(new BasicNameValuePair(EMAIL_KEY, mEmail));
        nameValuePairsLevel.add(new BasicNameValuePair(PASSWORD_KEY, mPassword));

        return new UrlEncodedFormEntity(nameValuePairsLevel);
    }

    @Override
    public Class getResponseClass(){
        return LoginResponse.class;
    }
}
