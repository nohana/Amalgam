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
package com.amalgam.app;

import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import com.amalgam.os.HandlerUtils;

public final class DialogFragmentUtils {
    private DialogFragmentUtils() {}

    public static final void dismissOnLoaderCallback(final FragmentManager manager, final String tag) {
        dismissOnLoaderCallback(HandlerUtils.getMainHandler(), manager, tag);
    }

    public static final void dismissOnLoaderCallback(Handler handler, final FragmentManager manager, final String tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                DialogFragment fragment = (DialogFragment) manager.findFragmentByTag(tag);
                if (fragment != null) {
                    fragment.dismiss();
                }
            }
        });
    }

    public static final void showOnLoaderCallback(final FragmentManager manager, final DialogFragment fragment, final String tag) {
        showOnLoaderCallback(HandlerUtils.getMainHandler(), manager, fragment, tag);
    }

    public static final void showOnLoaderCallback(Handler handler, final FragmentManager manager, final DialogFragment fragment, final String tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                fragment.show(manager, tag);
            }
        });
    }
}