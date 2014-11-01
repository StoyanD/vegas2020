package com.coiniverse.network;

import android.content.Context;

import com.coiniverse.network.cookies.CookieMapper;
import com.coiniverse.network.cookies.PersistentCookieStore;

import org.apache.http.cookie.Cookie;

/**
 * Created by stoyan on 8/22/14.
 */
public class SessionManager {


    /**
     * Singleton of this class
     */
    private static SessionManager mSession;

//    /**
//     * The cookie manager of that we use to store the login state of the user
//     */
//    private CookieManager mCookieManager;

    /**
     * The cookie store we use to maintain state
     */
    private PersistentCookieStore mPersistentCookieStore;

    /**
     * Do not instantiate this class outside of this file
     */
    private SessionManager(Context context) {
//        this.mCookieManager = new CookieManager();
//        CookieHandler.setDefault(mCookieManager);
        this.mPersistentCookieStore = PersistentCookieStore.getInstance(context);
    }

    /**
     * Singleton pattern of getting session manager
     * @return
     */
    public static SessionManager getInstance(Context context) {
        if(mSession == null) {
            mSession = new SessionManager(context);
        }

        return mSession;
    }


    /**
     * Checks the cookie store for a cookie that is named {@link com.omada.prevent.network.cookies.CookieMapper#LOGIN_COOKIE_NAME}
     * @return true if user is logged in, false otherwise
     */
    public boolean isLoggedIn(){
        for (Cookie cookie : mPersistentCookieStore.getCookies()){
            if (cookie.getName().equalsIgnoreCase(CookieMapper.LOGIN_COOKIE_NAME)) {
                return true;
            }
        }
        return false;
    }

    public void logout(){
        mPersistentCookieStore.clear();
    }

    //TODO check synchronization between threads
    public void login(){

    }


}
