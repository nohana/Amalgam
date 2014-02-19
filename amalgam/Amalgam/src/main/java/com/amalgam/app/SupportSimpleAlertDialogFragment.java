/*
 * Copyright (C) 2014 nohana, Inc. All rights reserved.
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

import com.amalgam.R;
import com.amalgam.os.BundleUtils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Simple implementation of alert dialog with support library.
 * Just show customized message.
 * If the user confirmed that message, just dismiss the dialog.
 * @author keishin.yokomaku
 */
@SuppressWarnings("unused") // public APIs
public class SupportSimpleAlertDialogFragment extends DialogFragment {
    public static final String TAG = SupportSimpleAlertDialogFragment.class.getSimpleName();
    private static final String ARGS_MESSAGE_RES = BundleUtils.buildKey(SupportSimpleAlertDialogFragment.class, "ARGS_MESSAGE_RES");
    private static final String ARGS_TITLE_RES = BundleUtils.buildKey(SupportSimpleAlertDialogFragment.class, "ARGS_TITLE_RES");

    /**
     * Construct {@link com.amalgam.app.SupportSimpleAlertDialogFragment} with the specified message resource.
     * @param messageResId to show on alert dialog
     * @return simplified alert dialog fragment.
     */
    public static SupportSimpleAlertDialogFragment newInstance(int messageResId) {
        SupportSimpleAlertDialogFragment fragment = new SupportSimpleAlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_MESSAGE_RES, messageResId);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Construct {@link com.amalgam.app.SupportSimpleAlertDialogFragment} with the specified message and title resource.
     * @param titleResId to show as an alert dialog title.
     * @param messageResId to show on alert dialog
     * @return simplified alert dialog fragment.
     */
    public static SupportSimpleAlertDialogFragment newInstance(int titleResId, int messageResId) {
        SupportSimpleAlertDialogFragment fragment = new SupportSimpleAlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_MESSAGE_RES, messageResId);
        args.putInt(ARGS_TITLE_RES, titleResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int title = getArguments().getInt(ARGS_TITLE_RES, R.string.dialog_title_simple_alert);
        int message = getArguments().getInt(ARGS_MESSAGE_RES);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(message)
                .setNeutralButton(R.string.dialog_button_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.create();
    }
}
