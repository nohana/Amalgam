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
package com.amalgam.os;

/**
 * Utility for the {@link android.os.Bundle}.
 */
@SuppressWarnings("unused") // public APIs
public final class BundleUtils {
    private BundleUtils() {
        throw new AssertionError();
    }

    /**
     * Build a custom bundle key name, to avoid conflict the bundle key name among the activities.
     * This is also useful to build a intent extra key name.
     *
     * @param clazz the class.
     * @param name the key name, in most case the name is UPPER_UNDERSCORE.
     * @return the full qualified key name.
     */
    public static String buildKey(Class<?> clazz, String name) {
        return new StringBuilder().append(clazz.getCanonicalName()).append(".").append(name).toString();
    }
}