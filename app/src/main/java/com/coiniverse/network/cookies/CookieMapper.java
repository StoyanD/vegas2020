package com.coiniverse.network.cookies;

import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BasicClientCookie2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class CookieMapper {
    /**
     * CloudFlare session cookie
     * __cfduid=dbd211f68fe4b1895004232e4301d3eb31408743063428; expires=Mon, 23-Dec-2019 23:50:00 GMT; path=/; domain=.preventnow.com; HttpOnly
     */
    public static final String CLOUDFLARE_SESSION_COOKIE_NAME = "__cfduid";

    /**
     * The name of the key in the cookie stating that participant is logged in
     * ex.  account_id=BAhpAmgE--5eb6efc16b5b66cd3ab27fd4de6c9ba7019683c0; path=/; expires=Tue, 22 Aug 2034 18:22:36 -0000
     */
    public static final String LOGIN_COOKIE_NAME = "account_id";

	public Cookie toCookie(JSONObject jsonObject) throws JSONException {
		BasicClientCookie2 cookie = new BasicClientCookie2(jsonObject.getString("name"), jsonObject.getString("value"));
		cookie.setComment(jsonObject.optString("comment"));
		cookie.setCommentURL(jsonObject.optString("commentURL"));
		cookie.setDomain(jsonObject.optString("domain"));
		cookie.setPath(jsonObject.optString("path"));
		cookie.setSecure(jsonObject.optBoolean("secure"));
		cookie.setVersion(jsonObject.optInt("version"));
		cookie.setExpiryDate(new Date(jsonObject.optLong("expiryDate")));
		if (jsonObject.has("ports")) {
			cookie.setPorts(JSONArrayToArray(jsonObject.optJSONArray("ports")));
		}
		return cookie;
	}

    /**
     * A static method that maps a header with value "Set-Cookie" into a cookie that we can store
     * in our {@link com.omada.prevent.network.cookies.PersistentCookieStore}
     * @param headerVal The value of the header to parse into a cookie
     * @return A cookie we can use
     */
    public static Cookie toBasicCookie(String headerVal){
        String[] fields = headerVal.split(";\\s*");
        BasicClientCookie cookie = new BasicClientCookie(fields[0].split("=")[0], fields[0].split("=")[1]);
        for (int j = 1; j < fields.length; j++) {
            if("secure".equalsIgnoreCase(fields[j])) {
                cookie.setSecure(true);
            } else if (fields[j].indexOf('=') > 0) {
                String[] f = fields[j].split("=");
                switch(f[0].toLowerCase()){
                    case "expires":
                    case "expiryDate":
//                        //TODO manage cookies with different data formats
//                        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
//                        try{
//                            cookie.setExpiryDate(formatter.parse(f[1]));
//                        }catch(ParseException exception){
//                            exception.printStackTrace();
//                        }
                        break;
                    case "domain":
                        cookie.setDomain(f[1]);
                        break;
                    case "path":
                        cookie.setPath(f[1]);
                        break;
                    case "version":
                        cookie.setVersion(Integer.parseInt(f[1]));
                        break;
                    case "comment":
                        cookie.setComment(f[1]);
                        break;
                }

            }
        }

        return cookie;
    }

	public JSONObject toJSONObject(Cookie cookie) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", cookie.getName());
		jsonObject.put("value", cookie.getValue());
		jsonObject.put("comment", cookie.getComment());
		jsonObject.put("commentURL", cookie.getCommentURL());
		jsonObject.put("domain", cookie.getDomain());
		jsonObject.put("path", cookie.getPath());
		jsonObject.put("secure", cookie.isSecure());
		jsonObject.put("version", cookie.getVersion());
		if (cookie.getExpiryDate() != null) {
			jsonObject.put("expiryDate", cookie.getExpiryDate().getTime());
		}
		if (cookie.getPorts() != null) {
			JSONArray jsonArray = arrayToJSONArray(cookie.getPorts());
			jsonObject.put("ports", jsonArray);
		}
		return jsonObject;
	}

	private JSONArray arrayToJSONArray(int[] ports) {
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < ports.length; i++) {
			jsonArray.put(ports[i]);
		}
		return jsonArray;
	}

	private int[] JSONArrayToArray(JSONArray jsonArray) throws JSONException {
		int[] ports = new int[jsonArray.length()];
		for (int i = 0; i < jsonArray.length(); i++) {
			ports[i] = jsonArray.getInt(i);
		}
		return ports;
	}

}