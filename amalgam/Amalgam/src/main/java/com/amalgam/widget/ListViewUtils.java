package com.amalgam.widget;

import android.widget.ListView;

/**
 */
public final class ListViewUtils {
    private ListViewUtils() {}

    public static final boolean isEmpty(ListView listView) {
        if (listView == null) {
            return false;
        }
        return listView.getCount() == 0;
    }
}