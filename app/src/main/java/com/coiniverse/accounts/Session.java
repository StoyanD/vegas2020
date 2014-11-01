package com.coiniverse.accounts;

import android.content.Context;
import android.content.SharedPreferences;

import com.coiniverse.api.Account;

/**
 * Created by vincent on 8/7/14.
 */
public class Session {

    private static Account account;
    private static final String SHARED_ACCOUNT = "SHARED_ACCOUNT";
    private static final String SHARED_ACCOUNT_KEY = "SHARED_ACCOUNT_KEY";

    public static void createSession(Account account, Context context) {
        Session.account = account;
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_ACCOUNT, Context.MODE_PRIVATE);

        sharedPreferences.edit().putString(SHARED_ACCOUNT_KEY, Session.account.toJson()).apply();
    }

    public static void clearSession(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_ACCOUNT, Context.MODE_PRIVATE);

        sharedPreferences.edit().clear().apply();
    }

    public static Account getAccount(Context context) {
        if (Session.account == null) {

            SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_ACCOUNT, Context.MODE_PRIVATE);

            String stringAccount = sharedPreferences.getString(SHARED_ACCOUNT_KEY, "");
            Session.account =  Account.fromJson(stringAccount);
        }
        return Session.account;
    }

}
