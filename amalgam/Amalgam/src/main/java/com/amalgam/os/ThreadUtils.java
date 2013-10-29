package com.amalgam.os;

import android.os.Looper;

import com.amalgam.os.exception.CalledFromWrongThreadException;

/**
 *
 * @author keishin.yokomaku
 */
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
     * @param thread
     */
    public static void checkMainThread(Thread thread) {
        if (!isMainThread(thread))
            throw new CalledFromWrongThreadException("Don't touch without main thread!!");
    }

    /**
     * Validate the specified thread is NOT main thread, or throws {@link CalledFromWrongThreadException}.
     * Useful to make sure the blocking procedure is done on background(worker) thread.
     * @param thread
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