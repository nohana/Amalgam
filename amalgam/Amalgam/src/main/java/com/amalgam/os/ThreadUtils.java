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
package com.amalgam.os;

import com.amalgam.os.exception.CalledFromWrongThreadException;

import android.os.Looper;

/**
 *
 * @author keishin.yokomaku
 */
@SuppressWarnings("unused") // public APIs
public final class ThreadUtils {
    private ThreadUtils() {}

    /**
     * Checks the specified thread is main thread.
     * @param thread to be checked.
     * @return true if the specified thread is main thread, false otherwise.
     */
    public static boolean isMainThread(Thread thread) {
        return Looper.getMainLooper().getThread() == thread;
    }

    /**
     * Checks the current thread is main thread.
     * @return true if the current thread is main thread, false otherwise.
     */
    public static boolean isMainThread() {
        return isMainThread(Thread.currentThread());
    }

    /**
     * Validate the specified thread is main thread, or throws {@link CalledFromWrongThreadException}.
     * Useful to make sure the modification of the UI components is done on main thread.
     * @param thread to check if the main or not.
     */
    public static void checkMainThread(Thread thread) {
        if (!isMainThread(thread))
            throw new CalledFromWrongThreadException("Don't touch without main thread!!");
    }

    /**
     * Validate the specified thread is NOT main thread, or throws {@link CalledFromWrongThreadException}.
     * Useful to make sure the blocking procedure is done on background(worker) thread.
     * @param thread to check if not the main.
     */
    public static void checkNotMainThread(Thread thread) {
        if (isMainThread(thread))
            throw new CalledFromWrongThreadException("Don't touch on main thread!!");
    }

    /**
     * Validate the current thread is main thread, or throws {@link CalledFromWrongThreadException}.
     * Useful to make sure the modification of the UI components is done on main thread.
     */
    public static void checkMainThread() {
        checkMainThread(Thread.currentThread());
    }

    /**
     * Validate the current thread is NOT main thread, or throws {@link CalledFromWrongThreadException}.
     * Useful to make sure the blocking procedure is done on background(worker) thread.
     */
    public static void checkNotMainThread() {
        checkNotMainThread(Thread.currentThread());
    }
}