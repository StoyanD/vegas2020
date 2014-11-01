package com.coiniverse.constants;

/**
 * Created by stoyan on 10/9/14.
 */
public class UrlHeaders {
    /**
     * 'UTF-8' charset name
     */
    public static final String CHARSET_UTF8 = "UTF-8";

    public static final String BOUNDARY = "00content0boundary00";
    public static final String CRLF = "\r\n";
    public static final String TWO_HYPHENS = "--";


    /**
     * 'multipart/form-data;boundary=' plus the {@link #BOUNDARY} for a multi-part form
     */
    public static final String CONTENT_TYPE_MULTIPART = "multipart/form-data;boundary="
            + BOUNDARY;

    /**
     * 'application/x-www-form-urlencoded' content type header value
     */
    public static final String CONTENT_TYPE_URL_ENCODED = "application/x-www-form-urlencoded";

    /**
     * 'application/json' content type header value
     */
    public static final String CONTENT_TYPE_JSON = "application/json";

    /**
     * 'gzip' encoding header value
     */
    public static final String ENCODING_GZIP = "gzip";

    /**
     * 'Accept' header name
     */
    public static final String HEADER_ACCEPT = "Accept";

    /**
     * 'Accept-Charset' header name
     */
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";

    /**
     * 'Accept-Encoding' header name
     */
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";

    /**
     * 'Authorization' header name
     */
    public static final String HEADER_AUTHORIZATION = "Authorization";

    /**
     * 'Cache-Control' header name
     */
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";

    /**
     * 'Connection' header name
     */
    public static final String HEADER_CONNECTION = "Connection";

    /**
     * 'Content-Encoding' header name
     */
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";

    /**
     * 'Cookie' header name
     */
    public static final String HEADER_COOKIE= "Cookie";

    /**
     * 'Content-Disposition: form-data; name="fileUpload";filename="' with form data name set
     * to FilePickers attribute 'fileUpload'
     */
    public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition: form-data; name=\"fileUpload\";filename=\"";

    /**
     * 'Content-Language' header name
     */
    public static final String HEADER_CONTENT_LANGUAGE = "Content-Language";

    /**
     * 'Content-Length' header name
     */
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";

    /**
     * 'Content-Type' header name
     */
    public static final String HEADER_CONTENT_TYPE = "Content-Type";

    /**
     * 'Date' header name
     */
    public static final String HEADER_DATE = "Date";

    /**
     * 'ETag' header name
     */
    public static final String HEADER_ETAG = "ETag";

    /**
     * 'Expires' header name
     */
    public static final String HEADER_EXPIRES = "Expires";

    /**
     * 'If-None-Match' header name
     */
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";

    /**
     * 'Last-Modified' header name
     */
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";

    /**
     * 'Location' header name
     */
    public static final String HEADER_LOCATION = "Location";

    /**
     * 'Proxy-Authorization' header name
     */
    public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";

    /**
     * 'Referer' header name
     */
    public static final String HEADER_REFERER = "Referer";

    /**
     * 'Set-Cookie' header name
     */
    public static final String HEADER_SET_COOKIE= "Set-Cookie";

    /**
     * 'Server' header name
     */
    public static final String HEADER_SERVER = "Server";

    /**
     * 'User-Agent' header name
     */
    public static final String HEADER_USER_AGENT = "User-Agent";

    /**
     * 'DELETE' request method
     */
    public static final String METHOD_DELETE = "DELETE";

    /**
     * 'GET' request method
     */
    public static final String METHOD_GET = "GET";

    /**
     * 'HEAD' request method
     */
    public static final String METHOD_HEAD = "HEAD";

    /**
     * 'OPTIONS' options method
     */
    public static final String METHOD_OPTIONS = "OPTIONS";

    /**
     * 'POST' request method
     */
    public static final String METHOD_POST = "POST";

    /**
     * 'PUT' request method
     */
    public static final String METHOD_PUT = "PUT";

    /**
     * 'TRACE' request method
     */
    public static final String METHOD_TRACE = "TRACE";

    /**
     * 'charset' header value parameter
     */
    public static final String PARAM_CHARSET = "charset";


    /**
     * 'Keep-Alive' header value for {@link #HEADER_CONNECTION}
     */
    public static final String FIELD_KEEP_ALIVE = "Keep-Alive";

    /**
     * {@link #CONTENT_TYPE_MULTIPART} content-disposition start for content'--00content0boundary00\r\n'
     */
    public static final String MULTIPART_START = TWO_HYPHENS + BOUNDARY + CRLF;

    /**
     * {@link #CONTENT_TYPE_MULTIPART} content-disposition start for content'\r\n--00content0boundary00--\r\n'
     */
    public static final String MULTIPART_END = CRLF + TWO_HYPHENS + BOUNDARY +  TWO_HYPHENS + CRLF;


}
