package com.coiniverse.activities;

import android.os.Bundle;

import com.omada.prevent.coach.R;

/**
 * Login activity that is shown if user is logged out
 * <p></p>
 * Created by stoyan on 8/20/2014.
 */
public class LoginActivity extends AbstractActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);


	}

    @Override
    protected void initLayout(Bundle savedInstanceState) {

    }
}