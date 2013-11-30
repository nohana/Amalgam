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