package com.coiniverse.network;

import com.coiniverse.network.responses.GenericResponse;

/**
 * Interface that is used to implement basic networking callbacks
 * <p></p>
 * Created by stoyan on 8/29/14.
 */
public interface HttpResponseInterface<ApiType extends GenericResponse> {

    /**
     * Method that is called when the {@link android.os.AsyncTask#onPostExecute(Object)}
     * is called from any of the network tasks. Use this method to implement app behavior
     * based on call response in fragments/activities instead of directly from the network
     * task
     * @param response The response from the network call
     */
    public void onNetworkResponse(ApiType response);
}
