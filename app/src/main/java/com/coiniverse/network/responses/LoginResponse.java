package com.coiniverse.network.responses;


import com.coiniverse.api.Account;

/**
 * Created by john on 8/5/14.
 *
 * id: 272,
 display_name: "Nickname",
 current_week: 5,
 current_weight_goal: {
 ends_at: 1395839587,
 goal_length_in_weeks: 16,
 start_weight: {
 id: 1239,
 filtered: false,
 time: 1386159595,
 value: 177.913045434
 },
 started_at: 1386166387,
 target_weight: 165.0
 },
 display_name: "Randi",
 group_started_at: 1384074105,
 image_url: "https://s3.amazonaws.com/images.omadatest.com/development/profile/9275a6bf6145934c15b4da9edfa7dca71670original.png?1386711660",
 program_start_weight: {
 id: 1234,
 filtered: false,
 time: 1383794365,
 value: 191.8002
 },
 todays_daily_meal: {
 breakfast: {
 healthiness: null,
 items: [
 "1 large pomegranate"
 ],
 size: null
 },
 dinner: {
 healthiness: null,
 items: [],
 size: null
 },
 eaten_on: "2013-12-11",
 glasses_water: 0,
 id: 19025,
 lunch: {
 healthiness: null,
 items: [
 "One whole wheat tortilla"
 ],
 size: null
 },
 reflection: null,
 snack: {
 healthiness: null,
 items: [],
 size: null
 },
 updated_at: 1386799489
 },
 image_url: "https://s3.amazonaws.com/images.path16.com/staging/profile/a64d0c2623198abb58c5c91d39150bcf989original.png?1382871788"
 }
 */
public class LoginResponse extends GenericResponse<Account> {

    private Account account;

    public LoginResponse(Account account) {
        this.account = account;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public void setApiObject(Account account) {
        this.account = account;
    }

    public Account getApiObject() {
        return this.account;
    }

}
