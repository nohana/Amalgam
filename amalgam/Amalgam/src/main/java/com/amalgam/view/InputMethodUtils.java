package com.amalgam.view;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class InputMethodUtils {
    private InputMethodUtils() {}

    public static final void hide(Context context, View v) {
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}