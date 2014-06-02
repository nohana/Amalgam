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

import com.amalgam.os.HandlerUtils;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;

/**
 * Utility for {@link android.app.DialogFragment} and {@link android.support.v4.app.DialogFragment}.
 * Operations for the support library version of {@link android.app.DialogFragment} has a method name prefix as "support".
 */
@SuppressWarnings("unused") // public APIs
public final class DialogFragmentUtils {
    private DialogFragmentUtils() {
        throw new AssertionError();
    }

    /**
     * Find fragment registered on the manager.
     * @param manager the manager.
     * @param tag the tag string that is related to the {@link android.app.DialogFragment}.
     * @param <F> the dialog fragment impl.
     * @return the {@link android.app.DialogFragment}. {@code null} if the fragment not found.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressWarnings("unchecked") // we know the dialog fragment is a child of fragment.
    public static <F extends android.app.DialogFragment> F findDialogFragmentByTag(android.app.FragmentManager manager, String tag) {
        return (F) manager.findFragmentByTag(tag);
    }

    /**
     * Find fragment registered on the manager.
     * @param manager the manager.
     * @param tag the tag string that is related to the {@link android.support.v4.app.DialogFragment}.
     * @param <F> the dialog fragment impl.
     * @return the {@link android.support.v4.app.DialogFragment}. {@code null} if the fragment not found.
     */
    @SuppressWarnings("unchecked") // we know the dialog fragment is a child of fragment.
    public static <F extends android.support.v4.app.DialogFragment> F supportFindDialogFragmentByTag(android.support.v4.app.FragmentManager manager, String tag) {
        return (F) manager.findFragmentByTag(tag);
    }

    /**
     * Dismiss {@link android.app.DialogFragment} for the tag on the loader callbacks.
     * @param manager the manager.
     * @param tag the tag string that is related to the {@link android.app.DialogFragment}.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void dismissOnLoaderCallback(final android.app.FragmentManager manager, final String tag) {
        dismissOnLoaderCallback(HandlerUtils.getMainHandler(), manager, tag);
    }

    /**
     * Dismiss {@link android.app.DialogFragment} for the tag on the loader callbacks with the specified {@link android.os.Handler}.
     * @param handler the handler, in most case, this handler is the main handler.
     * @param manager the manager.
     * @param tag the tag string that is related to the {@link android.app.DialogFragment}.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void dismissOnLoaderCallback(Handler handler, final android.app.FragmentManager manager, final String tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                android.app.DialogFragment fragment = (android.app.DialogFragment) manager.findFragmentByTag(tag);
                if (fragment != null) {
                    fragment.dismiss();
                }
            }
        });
    }

    /**
     * Dismiss {@link android.support.v4.app.DialogFragment} for the tag on the loader callbacks.
     * @param manager the manager.
     * @param tag the tag string that is related to the {@link android.support.v4.app.DialogFragment}.
     */
    public static void supportDismissOnLoaderCallback(final android.support.v4.app.FragmentManager manager, final String tag) {
        supportDismissOnLoaderCallback(HandlerUtils.getMainHandler(), manager, tag);
    }


    /**
     * Dismiss {@link android.support.v4.app.DialogFragment} for the tag on the loader callbacks with the specified {@link android.os.Handler}.
     * @param handler the handler, in most case, this handler is the main handler.
     * @param manager the manager.
     * @param tag the tag string that is related to the {@link android.support.v4.app.DialogFragment}.
     */
    public static void supportDismissOnLoaderCallback(Handler handler, final android.support.v4.app.FragmentManager manager, final String tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                android.support.v4.app.DialogFragment fragment = (android.support.v4.app.DialogFragment) manager.findFragmentByTag(tag);
                if (fragment != null) {
                    fragment.dismiss();
                }
            }
        });
    }

    /**
     * Show {@link android.app.DialogFragment} with the specified tag on the loader callbacks.
     * @param manager the manager.
     * @param fragment the fragment.
     * @param tag the tag string that is related to the {@link android.app.DialogFragment}.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void showOnLoaderCallback(final android.app.FragmentManager manager, final android.app.DialogFragment fragment, final String tag) {
        showOnLoaderCallback(HandlerUtils.getMainHandler(), manager, fragment, tag);
    }

    /**
     * Show {@link android.app.DialogFragment} with the specified tag on the loader callbacks.
     * @param handler the handler, in most case, this handler is the main handler.
     * @param manager the manager.
     * @param fragment the fragment.
     * @param tag the tag string that is related to the {@link android.app.DialogFragment}.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void showOnLoaderCallback(Handler handler, final android.app.FragmentManager manager, final android.app.DialogFragment fragment, final String tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                fragment.show(manager, tag);
            }
        });
    }

    /**
     * Show {@link android.support.v4.app.DialogFragment} with the specified tag on the loader callbacks.
     * @param manager the manager.
     * @param fragment the fragment.
     * @param tag the tag string that is related to the {@link android.support.v4.app.DialogFragment}.
     */
    public static void supportShowOnLoaderCallback(final android.support.v4.app.FragmentManager manager, final android.support.v4.app.DialogFragment fragment, final String tag) {
        supportShowOnLoaderCallback(HandlerUtils.getMainHandler(), manager, fragment, tag);
    }

    /**
     * Show {@link android.support.v4.app.DialogFragment} with the specified tag on the loader callbacks.
     * @param handler the handler, in most case, this handler is the main handler.
     * @param manager the manager.
     * @param fragment the fragment.
     * @param tag the tag string that is related to the {@link android.support.v4.app.DialogFragment}.
     */
    public static void supportShowOnLoaderCallback(Handler handler, final android.support.v4.app.FragmentManager manager, final android.support.v4.app.DialogFragment fragment, final String tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                fragment.show(manager, tag);
            }
        });
    }
}