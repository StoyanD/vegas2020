package com.coiniverse.constants;

/**
 * Google Analytics constants
 * Created by stoyan on 10/16/14.
 */
public class AnalyticsConstants {
    /**
     * Enum used to identify the tracker that needs to be used for tracking.
     *
     * A single tracker is usually enough for most purposes. In case you do need multiple trackers,
     * storing them all in Application object helps ensure that they are created only once per
     * application instance.
     */
    public enum TrackerName {
        APP_TRACKER // Tracker used only in this app.
//        GLOBAL_TRACKER, // Tracker used by all the apps from a company. eg: roll-up tracking.
//        ECOMMERCE_TRACKER, // Tracker used by all ecommerce transactions from a company.
    }
    public static final String ANALYTICS_PREFERENCE_STORE = "analytics";

    public static final String FIRST_LOGIN_WEEK_TAG = "First Login Week";
    public static final String PROGRAM_WEEK_TAG = "Week in Program";
    public static final String LAST_TIME_OPENED = "Last Time Opened";
    public static final String MEAL_TYPE = "Meal Type";

    /**
     * Custom dimensions, defined on google analytics
     */
    public static final int DIMENSION_FIRST_LOGIN_WEEK = 1;
    public static final int DIMENSION_WEEK_IN_PROGRAM = 2;


    /**
     * Google Analytics Event Categories
     */
    public static final String CATEGORY_APP = "App";
    public static final String CATEGORY_TRACKERS = "Trackers";

    /**
     * Google Analytics Event Actions
     */
    public static final String ACTIONS_APP_OPEN = "open";
    public static final String ACTIONS_TRACKERS_BUTTON_PRESS = "button_press";
    public static final String ACTIONS_TRACKERS_CREATE_MEAL = "create_meal";
    public static final String ACTIONS_TRACKERS_CREATE_PHYSICAL_ACTIVITY = "create_physical_activity";
    public static final String ACTIONS_TRACKERS_ACTIVATION = "activation";

    /**
     * Google Analytics Event Action Labels
     */
    public static final String LABEL_TRACKERS_ADD_ITEM = "add_item";
    public static final String LABEL_TRACKERS_CHANGE_WATER = "change_water";
    public static final String LABEL_TRACKERS_SHOW_CALENDAR = "show_calendar";
    public static final String LABEL_TRACKERS_CALENDAR_DAY_SELECTED = "calendar_day_selected";
    public static final String LABEL_TRACKERS_ADD_RECENT_ITEM = "add_recent_item";
    public static final String LABEL_TRACKERS_DELETE_ITEM = "delete_item";
    public static final String LABEL_TRACKERS_ADD_MEAL_PHOTO = "add_meal_photo";
    public static final String LABEL_TRACKERS_ADD_MEAL = "meal";
    public static final String LABEL_TRACKERS_PHYSICAL_ACTIVITY = "physical_activity";
    public static final String LABEL_TRACKERS_MEAL_REFLECTION = "meal_reflection";
    public static final String LABEL_TRACKERS_PHYSICAL_REFLECTION = "physical_reflection";



}
