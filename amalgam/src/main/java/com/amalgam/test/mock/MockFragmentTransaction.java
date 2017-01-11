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
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.view.View;

/**
 * Mock implementation for {@link FragmentTransaction}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressWarnings("unused") // public APIs
public class MockFragmentTransaction extends FragmentTransaction {
    @Override
    public FragmentTransaction add(Fragment fragment, String tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction addToBackStack(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction attach(Fragment fragment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int commit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int commitAllowingStateLoss() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void commitNow() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void commitNowAllowingStateLoss() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction detach(Fragment fragment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction disallowAddToBackStack() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction hide(Fragment fragment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAddToBackStackAllowed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction remove(Fragment fragment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setBreadCrumbTitle(int res) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setCustomAnimations(int enter, int exit, int popEnter, int popExit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setTransition(int transit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction addSharedElement(View sharedElement, String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction setTransitionStyle(int styleRes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction show(Fragment fragment) {
        throw new UnsupportedOperationException();
    }
}