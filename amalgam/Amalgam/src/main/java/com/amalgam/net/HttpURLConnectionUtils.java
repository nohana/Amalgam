package com.amalgam.net;

import java.net.HttpURLConnection;

/**
 */
public class HttpURLConnectionUtils {
    private HttpURLConnectionUtils() {}

    public static final void disconnect(HttpURLConnection connection) {
        if (connection == null) {
            return;
        }
        connection.disconnect();
    }
}