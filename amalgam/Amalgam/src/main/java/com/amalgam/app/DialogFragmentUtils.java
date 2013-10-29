package com.amalgam.app;

import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

public final class DialogFragmentUtils {
    private DialogFragmentUtils() {}

    public static final void dismissOnLoaderCallback(Handler handler, final FragmentManager manager, final String tag) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                DialogFragment fragment = (DialogFragment) manager.findFragmentByTag(tag);
                fragment.dismiss();
            }
        });
    }
}