/*
 * Copyright (C) 2013 nohana, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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