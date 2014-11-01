package com.coiniverse.application;

import android.app.Application;

import com.omada.prevent.coach.BuildConfig;


/**
 * Created by stoyan on 9/12/14.
 */
public class PreventApp extends Application {
    /**
     * Name of the database
     */
    public static final String DATABASE_NAME = "prevent.db";

    /**
     * Flavor of application builds
     */
    public static final class FLAVORS {
        public static final String LOCAL = "local";
        public static final String HOCKEY = "hockey";
        public static final String JENKINS = "jenkins";
        public static final String PLAY = "play";
    }

    /**
     * The dao session we use to access the database in {@link #mActivityManager}
     * and {@link #mMealManager}
     */
//    private static DaoSession mDaoSession;

    /**
     * The physical activity manager
     */
//    private static PhysicalActivityManager mActivityManager;

    /**
     * The daily meal manager
     */
//    private static DailyMealManager mMealManager;

    /**
     * The mixpanel api object
     */
//    private static MixpanelAPI mMixpanel;

    public static final boolean deployableBuild(){
        boolean isHockeyFlavor = BuildConfig.FLAVOR.equalsIgnoreCase(PreventApp.FLAVORS.HOCKEY);
        boolean isPlayFlavor = BuildConfig.FLAVOR.equalsIgnoreCase(PreventApp.FLAVORS.PLAY);
        return isHockeyFlavor || isPlayFlavor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
        setupTrackers();
//        AnalyticsManager.getInstance(this).trackAppOpened();
    }

    /**
     * Sets up the database and the data managers
     */
    private void setupDatabase() {
        //Create the database session
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DATABASE_NAME, null);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        DaoMaster daoMaster = new DaoMaster(db);
//        mDaoSession = daoMaster.newSession();
//
//        //Initialize managers and sync with server
//        mMealManager = DailyMealManager.getInstance(this, null);
//        mActivityManager = PhysicalActivityManager.getInstance(this, null);
//        mMealManager.getOrCreate(Utilities.getTodaysDate(), this);
//        mActivityManager.getOrCreate(Utilities.getTodaysDate(), this);
    }

    /**
     * Sets up the mixpanel api for analytics
     */
    private void setupTrackers() {
//        mMixpanel = MixpanelAPI.getInstance(this, Constants.MIXPANEL_TOKEN);
    }

    /**
     * Returns the doa session
     * @return {@link #mDaoSession}
     */
//    public static DaoSession getDaoSession() {
//        return mDaoSession;
//    }

    /**
     * Returns the meal manager
     * @return {@link #mMealManager}
     */
//    public static DailyMealManager getMealManager(){
//        return mMealManager;
//    }

    /**
     * Returns the mixpanel for analytics
     * @return {@link #mMixpanel}
     */
//    public static MixpanelAPI getMixpanel(){
//        return mMixpanel;
//    }

    /**
     * Returns the physical activity manager
     * @return {@link #mActivityManager}
     */
//    public static PhysicalActivityManager getActivityManager(){
//        return mActivityManager;
//    }


}
