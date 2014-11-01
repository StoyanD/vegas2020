package com.coiniverse.api;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Account implements Serializable {



    public static class Fields {
        public static final String CURRENT_WEEK = "current_week";
        public static final String GROUP_STARTED_AT = "group_started_at";
        public static final String CURRENT_WEIGHT_GOAL = "current_weight_goal";
        public static final String PROGRAM_START_WEIGHT = "program_start_weight";
        public static final String CURRENT_WEIGHT = "current_weight";
        public static final String STATUS = "status";
        public static final String DISPLAY_NAME = "display_name";
        public static final String ID = "id";
        public static final String IMAGE_URL = "image_url";
        public static final String TODAYS_DAILY_MEAL = "todays_daily_meal";
        public static final String MOBILE_ENABLED = "mobile_enabled";
    }

    @SerializedName(Fields.CURRENT_WEEK)
    private int mCurrentWeek;
    @SerializedName(Fields.GROUP_STARTED_AT)
    private long mGroupStartedAt;
//    @SerializedName(Fields.CURRENT_WEIGHT_GOAL)
//    private CurrentWeightGoal mCurrentWeightGoal;
//    @SerializedName(Fields.PROGRAM_START_WEIGHT)
//    private Weight mProgramStartWeight;
//    @SerializedName(Fields.CURRENT_WEIGHT)
//    private Weight mCurrentWeight;
    @SerializedName(Fields.STATUS)
    private String mStatus;
    @SerializedName(Fields.DISPLAY_NAME)
    private String mDisplayName;
    @SerializedName(Fields.ID)
    private Integer mId;
    @SerializedName(Fields.IMAGE_URL)
    private String mImageUrl;
//    @SerializedName(Fields.TODAYS_DAILY_MEAL)
//    private DailyMealApi mTodaysDailyMeal;
    @SerializedName(Fields.MOBILE_ENABLED)
    private Boolean mMobileEnabled = true;

    public Account() {
        super();

        // Set defaults
        setDisplayName("");
        setId(-1);
        setImageUrl("");
        setCurrentWeek(0);
        setGroupStartedAt(0);
//        setCurrentWeightGoal(new CurrentWeightGoal());
//        setProgramStartWeight(new Weight());
//        setCurrentWeight(new Weight());
        setStatus("");
    }

    public static Account fromJson(String serializedAccount) {
        Gson gson = new Gson();
        return gson.fromJson(serializedAccount, Account.class);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

//    public String getDailyMealGlassOfWater() {
//        if (getTodaysDailyMeal() == null) {
//            return "0";
//        }
//        return Integer.toString(getTodaysDailyMeal().getGlassesWater());
//    }

//    public String getMealId() {
//        if (getTodaysDailyMeal() == null) {
//            return "0";
//        }
//        return Long.toString(getTodaysDailyMeal().getId());
//    }
//
//    public String getEatenOn() {
//        if (getTodaysDailyMeal() == null) {
//            return "";
//        }
//        return getTodaysDailyMeal().getEatenOn();
//    }

    public int getCurrentWeek() {
        return mCurrentWeek;
    }

    public void setCurrentWeek(int currentWeek) {
        mCurrentWeek = currentWeek;
    }

    public long getGroupStartedAt() {
        return mGroupStartedAt;
    }

    public void setGroupStartedAt(long groupStartedAt) {
        mGroupStartedAt = groupStartedAt;
    }

//    public CurrentWeightGoal getCurrentWeightGoal() {
//        return mCurrentWeightGoal;
//    }
//
//    public void setCurrentWeightGoal(CurrentWeightGoal currentWeightGoal) {
//        mCurrentWeightGoal = currentWeightGoal;
//    }
//
//    public Weight getProgramStartWeight() {
//        if (mProgramStartWeight == null) {
//            return new Weight();
//        }
//        return mProgramStartWeight;
//    }
//
//    public void setProgramStartWeight(Weight startWeight) {
//        mProgramStartWeight = startWeight;
//    }
//
//    public Weight getCurrentWeight() {
//        if (mCurrentWeight == null) {
//            return new Weight();
//        }
//        return mCurrentWeight;
//    }
//
//    public void setCurrentWeight(Weight currentWeight) {
//        mCurrentWeight = currentWeight;
//    }
//
//    public float getWeightProgress() {
//        float weightLost = (float) (mProgramStartWeight.getValue() - mCurrentWeight.getValue());
//        float amountToLoseDuringCurrentGoal = (float) (mProgramStartWeight.getValue() - mCurrentWeightGoal.getTargetWeight());
//        return Math.max(0, Math.min(100, (weightLost * 100) / amountToLoseDuringCurrentGoal));
//    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(final String displayName) {
        mDisplayName = displayName;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(final Integer id) {
        mId = id;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        mImageUrl = imageUrl;
    }

//    public DailyMealApi getTodaysDailyMeal() {
//        return mTodaysDailyMeal;
//    }
//
//    public void setTodaysDailyMeal(final DailyMealApi todaysDailyMeal) {
//        mTodaysDailyMeal = todaysDailyMeal;
//    }

    public Boolean getMobileEnabled() {
        return mMobileEnabled;
    }

    public void setMobileEnabled(final Boolean mMobileEnabled) {
        this.mMobileEnabled = mMobileEnabled;
    }
}
