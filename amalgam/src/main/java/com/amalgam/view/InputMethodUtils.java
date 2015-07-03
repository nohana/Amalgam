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
package com.amalgam.view;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Utility for the {@link android.view.inputmethod.InputMethodManager}.
 */
@SuppressWarnings("unused") // public APIs
public final class InputMethodUtils {
    private InputMethodUtils() {
        throw new AssertionError();
    }

    /**
     * Hide the software input window.
     * @param context the context.
     * @param v the view that holds the window token.
     */
    public static void hide(Context context, View v) {
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}