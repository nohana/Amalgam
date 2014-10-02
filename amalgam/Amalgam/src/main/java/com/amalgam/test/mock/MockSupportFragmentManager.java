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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/**
 * Mock implementation for {@link FragmentManager}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
@SuppressWarnings("unused") // public APIs
public class MockSupportFragmentManager extends FragmentManager {
    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction beginTransaction() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean executePendingTransactions() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Fragment findFragmentById(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Fragment findFragmentByTag(String tag) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getBackStackEntryCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void popBackStack() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void popBackStack(String name, int flags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void popBackStack(int id, int flags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean popBackStackImmediate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SavedState saveFragmentInstanceState(Fragment f) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDestroyed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Fragment> getFragments() {
        throw new UnsupportedOperationException();
    }
}