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