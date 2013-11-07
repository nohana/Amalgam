package com.amalgam.test.mock;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;

/**
 * Mock implementation for {@link FragmentTransaction}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
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
    public FragmentTransaction setTransitionStyle(int styleRes) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FragmentTransaction show(Fragment fragment) {
        throw new UnsupportedOperationException();
    }
}