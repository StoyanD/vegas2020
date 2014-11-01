package com.coiniverse.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * A base fragment to build upon for all fragments in this application.
 * Implements routine methods shared across all fragments
 * Created by stoyan on 9/2/14.
 */
public abstract class AbstractFragment extends Fragment {
    /**
     * Callback to the activity to control fragments
     */
//    protected FragInterface mCallback;

    /**
     * The {@link com.omada.prevent.schema.DaoSession} used for storing/retrieving objects from database
     */
//    protected static DaoSession mDaoSession;

    /**
     * The {@link com.omada.prevent.data.AnalyticsManager} static object we use to analyze analytics
     */
//    protected static AnalyticsManager mAnalyticsManager;

    /**
     * A lock for controlling UI changes, {@link com.omada.prevent.network.HttpsManager} will
     * sometimes return and try to modify views that have been destroyed if not synced
     */
    final protected Object mViewSyncLock = new Object();

    /**
     * Boolean controlling the interaction with the UI views synchronized by {@link #mViewSyncLock}
     */
    private boolean mViewVisible;

    @Override
    public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
//         if(mDaoSession == null){
//             mDaoSession = PreventApp.getDaoSession();
//             mAnalyticsManager = AnalyticsManager.getInstance(getActivity());
//         }
//         AnalyticsManager.getInstance(getActivity()).trackScreen(this.getClass().getName());
     }

     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         setViewVisible(true);
         initLayout(savedInstanceState);
     }

    @Override
    public void onResume() {
        super.onResume();
//        mAnalyticsManager.trackScreen(this.getClass().getSimpleName());
    }

    @Override
     public void onPause() {
         super.onPause();
         setViewVisible(false);
     }

     /**
      * Initiate the layout, automatically called in {@link #onViewCreated(android.view.View, android.os.Bundle)}
     */
    protected abstract void initLayout(Bundle savedInstanceState);

    /**
     * Setter method for {@link #mViewVisible} that is synchronized by the
     * {@link #mViewSyncLock}. Controlled in {@link #onViewCreated(android.view.View, android.os.Bundle)}
     * and {@link #onPause()}
     * @param visible True if view can be modified, false otherwise
     */
    private void setViewVisible(boolean visible) {
        synchronized (mViewSyncLock){
            mViewVisible = visible;
        }
    }

    /**
     * Getter method for the {@link #mViewVisible} synchronized on the {@link #mViewSyncLock}
     * @return True if the view is visible and modifiable
     */
    protected boolean getSyncViewVisible(){
        synchronized (mViewSyncLock){
            return mViewVisible;
        }
    }

    /**
     * Getter method for the {@link #mViewVisible} that is not synchronized. Use {@link #getSyncViewVisible()}
     * if you need a synchronized method
     * @return True if it is visible
     */
    protected boolean getViewVisible(){
        return mViewVisible;
    }

    /**
     * Sets the callback for the fragment to interact with an {@link android.app.Activity}
     * @param callback
     */
//    public void setCallback(FragInterface callback){
//        this.mCallback = callback;
//    }

    /**
     * Gets the callback for this fragment
     * @return The callback
     */
//    public FragInterface getCallback(){
//        return this.mCallback;
//    }


}
