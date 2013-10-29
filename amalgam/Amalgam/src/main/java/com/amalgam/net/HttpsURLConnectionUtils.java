package com.amalgam.net;

import javax.net.ssl.HttpsURLConnection;

/**
 */
public class HttpsURLConnectionUtils {
    private HttpsURLConnectionUtils() {}

    public static final void disconnect(HttpsURLConnection connection) {
        if (connection == null) {
            return;
        }
        connection.disconnect();
    }
}
