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
package com.amalgam.widget;

import android.widget.ListView;

/**
 * Utility for the {@link android.widget.ListView}.
 */
@SuppressWarnings("unused") // public APIs
public final class ListViewUtils {
    private ListViewUtils() {
        throw new AssertionError();
    }

    /**
     * Checks if the content is empty.
     * @param listView to check.
     * @return true if the content is empty.
     */
    public static boolean isEmpty(ListView listView) {
        return listView != null && listView.getCount() == 0;
    }
}