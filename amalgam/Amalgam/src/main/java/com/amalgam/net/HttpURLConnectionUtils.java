package com.amalgam.net;

import android.os.Build;

import java.net.HttpURLConnection;

/**
 * Utility for HttpURLConnection.
 */
public class HttpURLConnectionUtils {
    /**
     * Do NOT instantiate this class.
     */
    private HttpURLConnectionUtils() {}

    /**
     * @see {@link java.net.HttpURLConnection#disconnect()}
     * @param connection
     */
    public static final void disconnect(HttpURLConnection connection) {
        if (connection == null) {
            return;
        }
        connection.disconnect();
    }

    /**
     * Avoid connection pool pollution on connection reuse by disabling it earlier than Froyo.
     */
    public static final void avoidConnectionPoolPollution() {
        if (Build.VERSION_CODES.FROYO > Build.VERSION.SDK_INT) {
            System.setProperty("http.keepAlive", "false");
        }
    }
}