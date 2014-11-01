package com.coiniverse.constants;

/**
 * Created by stoyan on 8/28/14.
 */
public class DailyMealConstants {
    public static class CursorFields{

        //Healthiness
        public static final String BREAKFAST_HEALTHINESS = "breakfast_healthiness";
        public static final String LUNCH_HEALTHINESS = "lunch_healthiness";
        public static final String DINNER_HEALTHINESS = "dinner_healthiness";
        public static final String SNACK_HEALTHINESS = "snack_healthiness";

        //Items in meal
        public static final String BREAKFAST_ITEMS = "breakfast_items";
        public static final String LUNCH_ITEMS = "lunch_items";
        public static final String DINNER_ITEMS = "dinner_items";
        public static final String SNACK_ITEMS = "snack_items";

        //Size of meal
        public static final String BREAKFAST_SIZE = "breakfast_size";
        public static final String LUNCH_SIZE = "lunch_size";
        public static final String DINNER_SIZE = "dinner_size";
        public static final String SNACK_SIZE = "snack_size";
    }

    public static class HttpFields {
        public static final String MEAL_ID = "id";

        //Meals
        public static final String BREAKFAST = "breakfast";
        public static final String LUNCH = "lunch";
        public static final String DINNER = "dinner";
        public static final String SNACK = "snack";

        //Outside meal arrays
        public static final String EATEN_ON = "eaten_on";
        public static final String REFLECTION = "reflection";
        public static final String UPDATED_AT = "updated_at";
        public static final String GLASSES_WATER = "glasses_water";
    }

}

