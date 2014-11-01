package com.coiniverse.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

/**
 * The base fragment activity that all others extend from. Implements Hockey App crash analytics
 * <p></p>
 * Created by stoyan and vincent on 8/21/14.
 */
public abstract class AbstractActivity extends Activity {
    /**
     * Tag for logging this class
     */
    private static final String TAG = "AbstractFragmentActivity";

    /**
     * Reference to the currently displaying fragment
     */
    protected Fragment mCurrentFragment;

    @Override
    protected void onResume() {
        super.onResume();

//        if(PreventApp.deployableBuild()){
//            //Turn on crashlytics on deploy builds
//            Crashlytics.start(this);
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void requireLogin(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
//        overridePendingTransition(R.anim.slide_out_top, R.anim.slide_in_bottom);
    }



    protected abstract void initLayout(Bundle savedInstanceState);
}
