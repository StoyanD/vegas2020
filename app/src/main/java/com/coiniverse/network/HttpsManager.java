package com.coiniverse.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.omada.prevent.coach.R;
import com.coiniverse.constants.UrlHeaders;
import com.coiniverse.network.cookies.CookieMapper;
import com.coiniverse.network.cookies.PersistentCookieStore;
import com.coiniverse.network.requests.GenericRequest;
import com.coiniverse.network.responses.GenericResponse;

import org.apache.http.HttpStatus;
import org.apache.http.cookie.Cookie;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A HTTP/HTTPS secure and lightweight manager. Uses Http(s)UrlConnection to post and get
 * data from URLs.
 * <p></p>
 * Created by stoyan on 8/21/14.
 */
public class HttpsManager<T extends GenericResponse> {
    /**
     * TAG for logging
     */
    private static final String TAG = "HttpsManager";

    /**
     * Time in milliseconds that the connection will wait for server before dropping
     */
    private static final int CONNECT_TIMEOUT = 10*1000;//stop connecting after 10 seconds

    /**
     * Time in milliseconds that the connection will read before dropping connection
     */
    private static final int READ_DATA_TIMEOUT = 25*1000;//stop reading data after 25 seconds

    /**
     * Singleton of this class
     */
    private static HttpsManager httpsManager;

    /**
     * The context of the activity
     */
    private final Context mContext;

    /**
     * The json manipulation lib object
     */
    private Gson mGson;

    /**
     * The store to manages cookies such as the log on cookie
     */
    private PersistentCookieStore mPersistentCookieStore;

    /**
     * The status code of the most recent network call
     */
    private int mResponseCode = -1;

    /**
     * Private constructor, might need for cookie store later
     * @param context
     */
    private HttpsManager(Context context){
        this.mContext = context;
        this.mGson = new Gson();

        //Enable cookies for HttpsUrlConnection
        this.mPersistentCookieStore = PersistentCookieStore.getInstance(mContext);
    }

    /**
     * Get a singletop of this instance
     * @param context The context of the application
     * @return The singleton
     */
    public static HttpsManager getInstance(Context context) {
        if(httpsManager == null) {
            httpsManager = new HttpsManager(context);
        }
        return httpsManager;
    }

    /**
     * Executes a post to either a HTTP or HTTPS address.
     * @param request The request to be executed
     * @return The response of the target to the post
     */
    public T execute(GenericRequest request){
        HttpURLConnection connection = null;
        String response = null;
        try{
            ;
            connection = getUrlConnection(request);

            if(request.getEntity() != null && request.isWritableCall()){

                String entity = streamToString(request.getEntity().getContent());
                writeReq(connection, entity);

            }

            if(connection == null){
                Toast.makeText(mContext, R.string.networking_error_toast, Toast.LENGTH_LONG).show();
                return null;
            }
            setResponseCode(connection.getResponseCode());
            if(getResponseCode() == HttpStatus.SC_OK){
                response = readRes(connection);
            }else{
                response = response != null ? response : "{}";
            }

            saveHeaders(connection);

        }catch(Exception e){
            e.printStackTrace();
            return null;

        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }

        T mappedResponse = mapResponse(response, request);
        mappedResponse.setResponseCode(getResponseCode());
        return mappedResponse;
    }

    /**
     * Generates and sets the fields of a HttpUrlConnection.
     * @param request The request to process into a connection
     * @return The connection
     */
    private HttpURLConnection getUrlConnection(GenericRequest request){
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(request.getUri().toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(CONNECT_TIMEOUT);
            connection.setReadTimeout(READ_DATA_TIMEOUT);

            //For api < 2.3.3 needs to be told to allow redirects
            connection.setInstanceFollowRedirects(true);
//            connection.getInstanceFollowRedirects();

            connection.setRequestProperty(UrlHeaders.HEADER_CONTENT_LANGUAGE, "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);

            connection.setRequestMethod(request.getHttpMethod());

            connection = setConnectionCookies(connection);

            if(request.isWritableCall()){
                connection.setRequestProperty(UrlHeaders.HEADER_CONTENT_TYPE,
                        request.getContentType());
                connection.setDoOutput(true);
            }
        }catch(Exception e) {

            e.printStackTrace();
            return null;
        }

        return connection;
    }

    /**
     * Writes to the output stream of a connection
     * @param connection The connection to write to
     */
    private static void writeReq(HttpURLConnection connection, String data){
        try{
            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream ());
            wr.writeBytes(data);

            //Close output stream
            wr.flush();
            wr.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * A method to upload photos to the FilePicker api
     * @param connection The connection to write to
     * @param photo The image file to upload
     */
    private static void uploadPhoto(HttpURLConnection connection, File photo){
        DataOutputStream outputStream = null;
        try {

            FileInputStream fileInputStream = new FileInputStream(photo);


            connection.setRequestProperty(UrlHeaders.HEADER_CONNECTION, UrlHeaders.FIELD_KEEP_ALIVE);
            connection.setRequestProperty(UrlHeaders.HEADER_CONTENT_TYPE,  UrlHeaders.CONTENT_TYPE_MULTIPART);

            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(UrlHeaders.MULTIPART_START);
            outputStream.writeBytes(getImageDisposition(photo.getName()));
            outputStream.writeBytes(UrlHeaders.CRLF);

            int bytesAvailable = fileInputStream.available();
            int bufferSize = Math.min(bytesAvailable, 10*1048*1048);
            byte[] buffer = new byte[bufferSize];

            // Read file
            int bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0) {
                outputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, bufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            outputStream.writeBytes(UrlHeaders.MULTIPART_END);
            fileInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Reads the input stream of a connection and returns the data received
     * @param connection The connection to read from
     * @return The data in staring form received
     */
    private static String readRes(HttpURLConnection connection){
        StringBuffer response = null;
        try{
            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
                /**
                 * API 10 bug
                 * AbstractHttpInputStream eagerly closes its socket stream upon reading the last byte, but BufferedReader calls read() multiple times after the last byte has been returned.
                 */
                if (!rd.ready()) {
                    break;
                }
            }
            rd.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        Log.d(TAG, "RESPONSE JSON : " + response.toString());
        return response.toString();
    }

    /**
     * A method that saves important headers from each url network call; such as cookies and status codes.
     * Must be called after we have read/written using {@link java.net.HttpURLConnection} but before we have
     * closed the connection
     * @param conn The connection after we have written and read from the server, before closing
     */
    private void saveHeaders(HttpURLConnection conn){
        for(int i = 0; i < conn.getHeaderFields().size();i++){
            String headerName = conn.getHeaderFieldKey(i);
            String headerValue = conn.getHeaderField(i);

            if(headerName != null){//API10 will give null header names with non-null values
                switch(headerName){
                    case UrlHeaders.HEADER_SET_COOKIE: //account_id=BAhpAmgE--5eb6efc16b5b66cd3ab27fd4de6c9ba7019683c0; path=/; expires=Tue, 22 Aug 2034 18:22:36 -0000
                        saveCookies(headerValue);
                        break;
                }
            }

        }
    }

    /**
     * A method to persistently store cookies in our {@link com.omada.prevent.network.cookies.PersistentCookieStore}
     * @param headerValue The header value with header name "Set-Cookie" that we get from {@link com.omada.prevent.network.HttpsManager#saveHeaders(java.net.HttpURLConnection)}
     */
    private void saveCookies(String headerValue){
        Log.i(TAG, headerValue);
        mPersistentCookieStore.addCookie(CookieMapper.toBasicCookie(headerValue));
    }

    /**
     * A method that reads the cookies stored in our {@link com.omada.prevent.network.cookies.PersistentCookieStore} and writes
     * them to the url connection
     * @param connection The connection to set the cookies to
     * @return The set connection
     */
    private HttpURLConnection setConnectionCookies(HttpURLConnection connection){
//        connection.setRequestProperty("Cookie", "account_id=BAhpArET--af23c72971b627d73aa73fdd546ace0b5f74b957;");
        if(mPersistentCookieStore != null && mPersistentCookieStore.getCookies().size() > 0 && connection != null){
            Cookie cookie = mPersistentCookieStore.getCookie(CookieMapper.LOGIN_COOKIE_NAME);

            if(cookie != null){
                try{
                    connection.setRequestProperty(UrlHeaders.HEADER_COOKIE, PersistentCookieStore.cookieToString(cookie));
                }catch (IllegalStateException e){
                    e.printStackTrace();
                }
            }

        }
        return connection;
    }

    /**
     * This method handles the case where the json that we receive from the server does not
     * have a named parameter enclosing the rest of the data, ie {"id" : 123123, "lunch" : [afd].....}.
     * In those cases, such as {@link com.omada.prevent.network.responses.DailyMealResponse}, we need to pass
     * the class that is directly reflected by the {@link com.google.gson.Gson} object. Then we need to
     * create the {@link com.omada.prevent.network.responses.GenericResponse} class that matches {@link T}
     * and manually set its fields.
     * <p></p>
     * If the json string can be directly reflected into the {@link T}, then we just do that instead of the
     * manual way.
     *
     * @param response The json string representing the object
     * @param request The request that holds the class we reflect the json string to
     * @return The response object initialized
     */
    @SuppressWarnings("unchecked")
    private T mapResponse(String response, GenericRequest request){
//        if(request.getResponseClass().equals(DailyMealApi.class)){
//            DailyMealApi meal = (DailyMealApi) mGson.fromJson(response, request.getResponseClass());
//            DailyMealResponse res = new DailyMealResponse();
//            res.setApiObject(meal);
//            return (T) res;
//        }
//        if(request.getResponseClass().equals(ActivitiesResponse.class)){
//            ActivitiesResponse activityApi = (ActivitiesResponse) mGson.fromJson(response, request.getResponseClass());
//            return (T) activityApi;
//        }
//
//        if(request.getResponseClass().equals(FilepickerApi.class)){
//            FilepickerApi filepickerApi = (FilepickerApi) mGson.fromJson(response, request.getResponseClass());
//            FilepickerResponse res = new FilepickerResponse();
//            res.setApiObject(filepickerApi);
//            return (T) res;
//        }

        return (T) mGson.fromJson(response, request.getResponseClass());
    }

    /**
     * A method that saves the most recent status code from a network call in an instance variable {@link com.omada.prevent.network.HttpsManager#mResponseCode}
     * @param status The code to save
     *               TODO handle error codes gracefully
     */
    private void setResponseCode(int status){
        this.mResponseCode = status;
    }

    /**
     * A method that returns the most recent network status code
     * @return the {@link org.apache.http.HttpStatus} code
     */
    public int getResponseCode(){
        return this.mResponseCode;
    }


    /**
     * A class that turns an {@link java.io.InputStream} into a string
     * @param inputStream The input stream to read
     * @return The string the input stream is converted into
     */
    private static String streamToString(InputStream inputStream){
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }

            return total.toString();
        }catch (IOException e){
            Log.e(TAG, "IOException");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Method that returns the Content-Disposition for an image upload to the FilePicker api
     * @param imageFileName Name of the file to upload
     * @return The content-disposition header string to set to the connection
     */
    private static String getImageDisposition(String imageFileName){
        return UrlHeaders.HEADER_CONTENT_DISPOSITION + imageFileName + "\"" + UrlHeaders.CRLF;
    }


    //TODO check for wifi redirects
}
