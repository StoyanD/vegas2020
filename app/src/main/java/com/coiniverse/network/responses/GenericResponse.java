package com.coiniverse.network.responses;

import java.io.Serializable;

/**
 * Abstract class that implements {@link java.io.Serializable} and some basic
 * network fields. Extend this class for all {@link com.omada.prevent.network.HttpsManager}
 * executed {@link com.omada.prevent.network.requests.GenericRequest}
 *
 *
 * Created by Olivier, John, and Stoyan on 8/5/14.
 */
public abstract class GenericResponse<Api> implements Serializable {

    /**
     * Variable to hold the Http response code of the network call
     */
    private int mResponseCode;

    public abstract void setApiObject(Api meal);

    public abstract Api getApiObject();

    /**
     * Method for responses from {@link com.omada.prevent.network.HttpsManager}.
     * Each subclass of this class should implement this method to check for the
     * status of their call
     * @param code
     */
    public void onResponse(int code){
        setResponseCode(code);
    }

    public int getResponseCode(){
        return this.mResponseCode;
    }

    public void setResponseCode(int code){
        this.mResponseCode = code;
    }

}
