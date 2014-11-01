package com.coiniverse.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.omada.prevent.coach.R;
import com.coiniverse.activities.MainActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnEditorAction;

public class LoginFragment extends AbstractFragment{
    /**
     * TAG for logging
     */
    private static final String TAG = "LoginFragment";

    /**
     * The context of the calling activity
     */
    protected Context mContext;

    /**
     * The views of this fragment that we need references to
     */
    @InjectView(R.id.email_field) EditText mEmailField;
    @InjectView(R.id.password_field) EditText mPasswordField;
    @InjectView(R.id.login_spinner) ProgressBar mProgressBar;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mContext = getActivity();
    }

    /**
     * Fragments have a different view lifecycle than activities. When injecting a fragment in onCreateView,
     * set the views to null in onDestroyView. Butter Knife has a reset method to do this automatically.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.login_button)
    protected void clickLogin(Button loginButton){
        performLogin(mEmailField.getText().toString(), mPasswordField.getText().toString());
    }

//    @OnClick(R.id.learn_more_button)
//    protected void clickLearnMore(RelativeLayout rl){
//        //TODO
//    }

    @OnEditorAction(R.id.password_field)
    protected boolean editorActionPassword(TextView view, int actionId, KeyEvent event){
        if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
            performLogin(mEmailField.getText().toString(), mPasswordField.getText().toString());
        }
        return false;
    }

    /**
     * Initiate the layout
     */
    @Override
    protected void initLayout(Bundle savedInstanceState) {
    }

    /**
     * Performs login with server. If successful launches new activity, if it fails will
     * send a {@link android.widget.Toast} to this view
     * @param email user email
     * @param password user password
     */
    private void performLogin(String email, String password) {
        //Show network spinner
        mProgressBar.setVisibility(View.VISIBLE);
        goToHomeScreen();
//        //Create task
//        LoginTask login = new LoginTask(getActivity());
//
//        //Set response interface
//        login.setNetworkCallback(new HttpResponseInterface() {
//            @Override
//            public void onNetworkResponse(GenericResponse response) {
//                mProgressBar.setVisibility(View.GONE);
//
//                if(response != null){
//                    Account account = ((LoginResponse)response).getApiObject();
//                    // if not logged in, no account
//                    if (account != null) {
//
//                        AccountStatusEnum accountStatus = AccountStatusEnum.getFromText(account.getStatus());
//                        Session.createSession(account, mContext);
//                        switch (accountStatus) {
//                            case ACCOUNT_STATUS_ACTIVE:
////                                Session.createSession(account, mContext);
//                                goToHomeScreen();
//                                break;
//                        }
//                    } else {
//                        Toast.makeText(mContext, R.string.login_failed_toast, Toast.LENGTH_LONG).show();
//                    }
//                }else {
//                    Toast.makeText(mContext, R.string.login_failed_toast, Toast.LENGTH_LONG).show();
//                }
//            }
//
//
//        });
//
//        login.execute(new LoginRequest(email, password));
    }

    private void goToHomeScreen() {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
        getActivity().finish();
    }

}