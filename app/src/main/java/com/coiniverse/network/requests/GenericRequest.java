package com.coiniverse.network.requests;

import android.net.Uri;

import com.coiniverse.constants.UrlHeaders;

import org.apache.http.HttpEntity;

import java.io.UnsupportedEncodingException;

/**
 * Created by john on 8/5/14.
 */
public abstract class GenericRequest{

    /**
     * The uri of the network call
     */
    protected Uri mUri;

    /**
     * The HTTP method of the network call, defaults to {@link com.omada.prevent.constants.UrlHeaders#METHOD_POST}
     */
    protected String mHttpMethod = UrlHeaders.METHOD_POST;


    /**
     * The content-type of the request
     */
    protected String mContentType = UrlHeaders.CONTENT_TYPE_URL_ENCODED;

    /**
     * The constructor of this class
     * @param uri The uri of the network call
     */
    public GenericRequest(Uri uri) {
        this.mUri = uri;
    }

    public GenericRequest() {

    }

    /**
     * Must be overriden to encode the data into a {@link org.apache.http.client.entity.UrlEncodedFormEntity}
     * @return The data to communicate to the server if this is not a {@link com.omada.prevent.constants.UrlHeaders#METHOD_GET}
     * @throws java.io.UnsupportedEncodingException
     */
    public abstract HttpEntity getEntity() throws UnsupportedEncodingException;

    /**
     * The response class that we use to reflect the response of the server
     * @return The response class
     */
    public abstract Class getResponseClass();


    public Uri getUri() {
        return mUri;
    }

    public void setUri(Uri mUri) {
        this.mUri = mUri;
    }
    public String getHttpMethod() {
        return mHttpMethod;
    }

    public void setHttpMethod(String mHttpMethod) {
        this.mHttpMethod = mHttpMethod;
    }
    public String getContentType() {
        return mContentType;
    }

    public void setContentType(String mContentType) {
        this.mContentType = mContentType;
    }
    /**
     * Checks to see if {@link #mHttpMethod} is a data posting method where we expect to
     * write to the connection in  {@link com.omada.prevent.network.HttpsManager#getUrlConnection(GenericRequest)}
     * @return True if the call is {@link com.omada.prevent.constants.UrlHeaders#METHOD_POST}, {@link com.omada.prevent.constants.UrlHeaders#METHOD_DELETE}, {@link com.omada.prevent.constants.UrlHeaders#METHOD_PUT}
     */
    public boolean isWritableCall(){
        switch(mHttpMethod){
            case UrlHeaders.METHOD_POST:
            case UrlHeaders.METHOD_DELETE:
            case UrlHeaders.METHOD_PUT:
                return true;
        }
        return false;
    }




}
