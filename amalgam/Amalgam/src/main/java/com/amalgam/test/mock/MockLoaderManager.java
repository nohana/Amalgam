package com.amalgam.test.mock;

import android.annotation.TargetApi;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Build;
import android.os.Bundle;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Mock implementation for {@link LoaderManager}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MockLoaderManager extends LoaderManager {
    @Override
    public void destroyLoader(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <D> Loader<D> getLoader(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <D> Loader<D> initLoader(int id, Bundle args, LoaderCallbacks<D> callbacks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <D> Loader<D> restartLoader(int id, Bundle args, LoaderCallbacks<D> callbacks) {
        throw new UnsupportedOperationException();
    }
}