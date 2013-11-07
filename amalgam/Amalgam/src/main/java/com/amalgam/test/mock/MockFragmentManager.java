package com.amalgam.test.mock;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.Fragment.SavedState;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Mock implementation for {@link FragmentManager}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MockFragmentManager extends FragmentManager {
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
}