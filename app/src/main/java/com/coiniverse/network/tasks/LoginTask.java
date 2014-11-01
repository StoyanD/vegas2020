package com.coiniverse.network.tasks;

import android.content.Context;

import com.coiniverse.network.requests.LoginRequest;
import com.coiniverse.network.responses.LoginResponse;

/**
 * A task that extends {@link com.omada.prevent.network.tasks.AbstractNetworkTask}, which performs network authentication
 * over HTTPS with production/development server and retrieves the authentication cookies needed for further
 * authenticated communications.
 * <p></p>
 * Created by john, olivier, and stoyan on 8/5/14.
 */
public class LoginTask extends AbstractNetworkTask<LoginRequest, LoginResponse>{
    /**
     * Tag for logging this class
     */
    private static final String TAG = "LoginTask";

    public LoginTask(Context context) {
        super(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(LoginResponse response) {
        super.onPostExecute(response);

        if(mCallback != null){
            mCallback.onNetworkResponse(response);
        }
    }
}
