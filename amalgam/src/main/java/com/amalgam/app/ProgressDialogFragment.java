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

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.amalgam.os.BundleUtils;

/**
 * Simple implementation of the {@link android.app.DialogFragment} that contains progress view.
 *
 * @author KeithYokoma
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressWarnings("unused") // public APIs
public final class ProgressDialogFragment extends DialogFragment {
    public static final String TAG = ProgressDialogFragment.class.getSimpleName();
    private static final String ARGS_TITLE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_TITLE");
    private static final String ARGS_MESSAGE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_MESSAGE");
    private static final String ARGS_INDETERMINATE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_INDETERMINATE");

    /**
     * Do not call the constructor directory, use {@link com.amalgam.app.ProgressDialogFragment#newInstance(String, String, boolean)} instead.
     */
    public ProgressDialogFragment() {
    }

    /**
     * Create a new instance of the {@link com.amalgam.app.ProgressDialogFragment}.
     *
     * @param context       the context.
     * @param title         the title text resource.
     * @param message       the message text resource.
     * @param indeterminate indeterminate progress or not.
     * @return the instance of the {@link com.amalgam.app.ProgressDialogFragment}.
     */
    public static ProgressDialogFragment newInstance(Context context, int title, int message, boolean indeterminate) {
        return newInstance(context.getString(title), context.getString(message), indeterminate);
    }

    /**
     * Create a new instance of the {@link com.amalgam.app.ProgressDialogFragment}.
     *
     * @param title         the title text, can be null
     * @param message       the message text, must not be null.
     * @param indeterminate indeterminate progress or not.
     * @return the instance of the {@link com.amalgam.app.ProgressDialogFragment}.
     */
    public static ProgressDialogFragment newInstance(String title, String message, boolean indeterminate) {
        ProgressDialogFragment fragment = new ProgressDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARGS_TITLE, title);
        args.putString(ARGS_MESSAGE, message);
        args.putBoolean(ARGS_INDETERMINATE, indeterminate);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String title = args.getString(ARGS_TITLE);
        String message = args.getString(ARGS_MESSAGE);
        boolean indeterminate = args.getBoolean(ARGS_INDETERMINATE);
        ProgressDialog dialog = new ProgressDialog(getActivity());
        if (title != null) {
            dialog.setTitle(title);
        }
        dialog.setMessage(message);
        dialog.setIndeterminate(indeterminate);
        return dialog;
    }
}