package com.amalgam.app;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.amalgam.os.BundleUtils;

/**
 */
public final class SupportProgressDialogFragment extends DialogFragment {
    private static final String ARGS_TITLE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_TITLE");
    private static final String ARGS_MESSAGE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_MESSAGE");
    private static final String ARGS_INDETERMINATE = BundleUtils.buildKey(SupportProgressDialogFragment.class, "ARGS_INDETERMINATE");

    /**
     * Do not call the constructor directory, use {@link com.amalgam.app.SupportProgressDialogFragment#newInstance(String, String, boolean)} instead.
     */
    public SupportProgressDialogFragment() {}

    public static final SupportProgressDialogFragment newInstance(String title, String message, boolean indeterminate) {
        SupportProgressDialogFragment fragment = new SupportProgressDialogFragment();
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