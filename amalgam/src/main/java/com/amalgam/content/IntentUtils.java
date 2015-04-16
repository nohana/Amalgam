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
package com.amalgam.content;

/**
 * Utility for the {@link android.content.Intent}.
 */
@SuppressWarnings("unused") // public APIs
public final class IntentUtils {
    private IntentUtils() {
        throw new AssertionError();
    }

    /**
     * Build a custom intent action name, like "jp.co.nohana.amalgam.Sample.ACTION_SAMPLE".
     * @param clazz the class name.
     * @param action the action name.
     * @return the custom action name.
     */
    public static String buildAction(Class<?> clazz, String action) {
        return new StringBuilder().append(clazz.getCanonicalName()).append(".").append(action).toString();
    }
}