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
package com.amalgam.test.mock;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.SpinnerAdapter;

/**
 * Mock implementation for {@link ActionBar}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MockActionBar extends ActionBar {
    @Override
    public void setCustomView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCustomView(View view, LayoutParams layoutParams) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCustomView(int resId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setIcon(int resId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setIcon(Drawable icon) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLogo(int resId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setLogo(Drawable logo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setListNavigationCallbacks(SpinnerAdapter adapter, OnNavigationListener callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSelectedNavigationItem(int position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSelectedNavigationIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getNavigationItemCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTitle(CharSequence title) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setTitle(int resId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSubtitle(CharSequence subtitle) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSubtitle(int resId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDisplayOptions(int options) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDisplayOptions(int options, int mask) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDisplayUseLogoEnabled(boolean useLogo) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDisplayShowHomeEnabled(boolean showHome) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDisplayHomeAsUpEnabled(boolean showHomeAsUp) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDisplayShowTitleEnabled(boolean showTitle) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setDisplayShowCustomEnabled(boolean showCustom) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setBackgroundDrawable(Drawable d) {
        throw new UnsupportedOperationException();
    }

    @Override
    public View getCustomView() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CharSequence getTitle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CharSequence getSubtitle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getNavigationMode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNavigationMode(int mode) {
        throw new UnsupportedOperationException();

    }

    @Override
    public int getDisplayOptions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tab newTab() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addTab(Tab tab) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addTab(Tab tab, boolean setSelected) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addTab(Tab tab, int position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addTab(Tab tab, int position, boolean setSelected) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeTab(Tab tab) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeTabAt(int position) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAllTabs() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void selectTab(Tab tab) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tab getSelectedTab() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Tab getTabAt(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getTabCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getHeight() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void show() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isShowing() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener listener) {
        throw new UnsupportedOperationException();
    }

    public static class MockTab extends ActionBar.Tab {
        @Override
        public int getPosition() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Drawable getIcon() {
            throw new UnsupportedOperationException();
        }

        @Override
        public CharSequence getText() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setIcon(Drawable icon) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setIcon(int resId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setText(CharSequence text) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setText(int resId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setCustomView(View view) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setCustomView(int layoutResId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public View getCustomView() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setTag(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object getTag() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setTabListener(TabListener listener) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void select() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setContentDescription(int resId) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Tab setContentDescription(CharSequence contentDesc) {
            throw new UnsupportedOperationException();
        }

        @Override
        public CharSequence getContentDescription() {
            throw new UnsupportedOperationException();
        }
    }
}