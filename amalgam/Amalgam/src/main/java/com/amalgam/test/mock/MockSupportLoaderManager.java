package com.amalgam.test.mock;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Mock implementation for {@link LoaderManager}.
 * All of the method call will throw {@link UnsupportedOperationException}.
 * @author keishin.yokomaku
 */
public class MockSupportLoaderManager extends LoaderManager {
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