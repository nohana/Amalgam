package com.amalgam.app;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;

import com.amalgam.os.BundleUtils;

/**
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public final class ProgressDialogFragment extends DialogFragment {
    public static final String TAG = ProgressDialogFragment.class.getSimpleName();
    private static final String ARGS_TITLE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_TITLE");
    private static final String ARGS_MESSAGE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_MESSAGE");
    private static final String ARGS_INDETERMINATE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_INDETERMINATE");

    /**
     * Do not call the constructor directory, use {@link com.amalgam.app.ProgressDialogFragment#newInstance(String, String, boolean)} instead.
     */
    public ProgressDialogFragment() {}

    public static final ProgressDialogFragment newInstance(String title, String message, boolean indeterminate) {
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