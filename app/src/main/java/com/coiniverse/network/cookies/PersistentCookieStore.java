package com.coiniverse.network.cookies;

import android.content.Context;
import android.content.SharedPreferences;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Check out https://github.com/loopj/android-async-http/blob/master/library/src/main/java/com/loopj/android/http/PersistentCookieStore.java
//in the future
public class PersistentCookieStore implements CookieStore {

    private final static String PERSISTENT_COOKIE = "PERSISTENT_COOKIE";

    private final SharedPreferences mSharedPreferences;
    private final CookieMapper mCookieMapper = new CookieMapper();

    private static PersistentCookieStore mPersistentCookieStore;

    private PersistentCookieStore(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(PERSISTENT_COOKIE, Context.MODE_PRIVATE);
    }

    public static PersistentCookieStore getInstance(Context context){
        if(mPersistentCookieStore == null) {
            mPersistentCookieStore = new PersistentCookieStore(context);
        }
        return mPersistentCookieStore;
    }

    @Override
    public void addCookie(Cookie cookie) {
        List<Cookie> cookies = getCookiesFromStore();
        cookies.add(cookie);
        save(cookies);
    }

    @Override
    public List<Cookie> getCookies() {
        return getCookiesFromStore();
    }

    @Override
    public synchronized boolean clearExpired(Date date) {
        List<Cookie> cookies = getCookiesFromStore();
        List<Cookie> clearedCookies = new ArrayList<Cookie>(cookies.size());
        boolean cleared = false;
        for (Cookie cookie : cookies) {
            if (cookie.getExpiryDate().after(date)) {
                clearedCookies.add(cookie);
                cleared = true;
            }
        }
        save(clearedCookies);
        return cleared;
    }

    @Override
    public synchronized void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    /**
     * Get the cookie by its name, case insensitive
     * @param name The name of the cookie
     * @return The cookie if it exists or null
     */
    public Cookie getCookie(String name){
        for(Cookie k : getCookies()){
            if(k.getName().toLowerCase().equals(name.toLowerCase())){
                return k;
            }
        }
        return null;
    }

    /**
     * A method that can turn a cookie into a string
     * @param cookie The cookie to transform
     * @return The string representation of the cookie name and value
     */
    public static String cookieToString(Cookie cookie){
        if(cookie != null){
            return cookie.getName() + "=" + cookie.getValue() + ";";
        }
        return "";

    }
    private List<Cookie> getCookiesFromStore() {
        try {
            String jsonString = mSharedPreferences.getString("cookies", "");
            if (jsonString.equals("")) {
                return new ArrayList<>(0);
            } else {
                JSONArray jsonArray = new JSONArray(jsonString);
                List<Cookie> cookies = new ArrayList<Cookie>(jsonArray.length());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    cookies.add(mCookieMapper.toCookie(jsonObject));
                }
                return cookies;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void save(List<Cookie> cookies) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Cookie cookie1 : cookies) {
                jsonArray.put(mCookieMapper.toJSONObject(cookie1));
            }
            mSharedPreferences.edit().putString("cookies", jsonArray.toString()).commit();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}