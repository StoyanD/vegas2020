package com.coiniverse.network.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.coiniverse.network.HttpResponseInterface;
import com.coiniverse.network.HttpsManager;
import com.coiniverse.network.requests.GenericRequest;
import com.coiniverse.network.responses.GenericResponse;


/**
 * Created by stoyan on 8/25/14.
 */
public class AbstractNetworkTask<Req extends GenericRequest, Res extends GenericResponse> extends AsyncTask<Req, Void, Res> {
    /**
     * Tag for logging this class
     */
    private static final String TAG = "AbstractNetworkTask";

    /**
     * The context of the calling activity
     */
    protected final Context mContext;

    /**
     * The callback interface to set in order to be notified of network call
     * completion and its status
     */
    protected HttpResponseInterface mCallback;

    /**
     * The abstract constructor of this task. All subclasses should make sure
     * to implement this super method in their constructors
     *
     * @param context context of the calling activity
     */
    public AbstractNetworkTask(Context context){
        this.mContext = context;
    }

    @Override
    protected Res doInBackground(Req... requests) {
        try {
            HttpsManager httpManager = HttpsManager.getInstance(mContext);
            return ((Res) httpManager.execute(requests[0]));

        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Res response) {
        super.onPostExecute(response);
    }

    /**
     * Method to set the network callback interface that is called in {@link #onPostExecute(com.omada.prevent.network.responses.GenericResponse)}
     * Implement all control logic through this interface
     * @param callback
     */
    public void setNetworkCallback(HttpResponseInterface callback){
        this.mCallback = callback;
    }
}
