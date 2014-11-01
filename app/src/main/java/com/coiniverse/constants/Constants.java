package com.coiniverse.constants;

/**
 * Created by stoyan on 8/20/14.
 */
public class Constants {
    public static final String FILE_PICKER_API_KEY = "AGHpLqfZbFwJuPvCRNtz";//dev
    public static final String MIXPANEL_TOKEN = "3c87e6faba139c1b36677b0fe04dcc7c";//dev
    public static final String GOOGLE_ANALYTICS_TRACKER_ID = "UA-26950408-9";//dev

    public static final String BASE_URL = "http://192.168.10.146:3000";//Omada
//    public static final String BASE_URL = "https://preventnow.com/";//Omada
    //    public static final String BASE_URL = "http://10.6.59.196:3000";//Omada Guest
    public static final String API_URL = BASE_URL+ "/api/mobile/v3/";
    public static final String LOGIN_URL = API_URL + "login";
    public static final String LOGOUT_URL = API_URL + "logout";

    public static final String ACCOUNTS_URL = API_URL + "accounts/";
    public static final String DAILY_MEAL_URL = API_URL + "accounts/";
    public static final String PHOTO_URL = API_URL + "photos/";
    public static final String DAILY_MEAL_SUFFIX_URL = "/daily_meals";
    public static final String PHYSICAL_ACTIVITIES_SUFFIX_URL = "/physical_activities";

    // Web urls
    public static final String FORGOT_PASSWORD_URL = "https://app.preventnow.com/pwreset";
    public static final String PREDIABETES_URL = "https://preventnow.com/prediabetes_101";
    public static final String RISK_SCREENER_URL = "https://preventnow.com/risk_assessment";
    public static final String ABOUT_PROGRAM_URL = "https://preventnow.com/how_it_works";
    public static final String GET_STARTED_URL = "https://preventnow.com/signup";
    public static final String OMADA_HEALTH_URL = "https://omadahealth.com";
    public static final String TERMS_URL = "https://preventnow.com/terms";
    public static final String PRIVACY_POLICY_URL = "https://app.preventnow.com/privacy";

    // Colors
    public static final String LIME_GREEN = "#ffc5d957";
    public static final String LIME_GREEN_TRANSLUCENT = "#66c5d957";
    public static final String LIGHT_BLUE = "#76aadb";
    public static final String WHITE_TRANSLUCENT = "#66ffffff";

    // Intent keys
    public static final String TRACKER_TYPE_FOOD = "food";
    public static final String TRACKER_TYPE_ACTIVITY = "activity";

    //Intent codes
    public static final int INTENT_CAPTURE_IMAGE_CODE = 1;
    public static final int INTENT_CROP_IMAGE_CODE = 2;

    // Storage keys
    public static final String STORAGE_KEY_WATER = "storage_key_water";
    public static final String STORAGE_KEY_SUGGESTED_FOOD_ITEMS = "storage_key_suggested_food_items";
    public static final String STORAGE_KEY_USERID = "storage_key_userid";
    public static final String STORAGE_KEY_AVATAR_IMAGE_URL = "storage_key_avatar_image_url";
    public static final String STORAGE_KEY_AVATAR_IMAGE_BYTESTREAM = "storage_key_avatar_image_bytestream";
    public static final String STORAGE_KEY_COVER_IMAGE_URL = "storage_key_cover_image_url";
    public static final String STORAGE_KEY_COVER_IMAGE_BYTESTREAM = "storage_key_cover_image_bytestream";
    public static final String STORAGE_KEY_MEAL_LAST_SYNC_TIME = "storage_key_meal_last_sync_time";
    public static final String STORAGE_KEY_ACTIVITY_LAST_SYNC_TIME = "storage_key_activity_last_sync_time";

    // Numbers
    public static final int COVER_PHOTO_WIDTH = 600;
    public static final int ACTIVITY_GOAL_MINUTES = 150;
    public static final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
    public static final long DATA_VALIDATOR_EXPIRY = 15 * 60; // 15 mins

    // Program constants
    public static final int DEFAULT_PROGRAM_LENGTH_MONTHS = 4;




}
