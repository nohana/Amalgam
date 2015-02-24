package com.amalgam.view;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class WindowUtils {
    public static final String TAG = WindowUtils.class.getSimpleName();

    private WindowUtils() {
        throw new AssertionError();
    }

    public static Window makeNewWindow(Context context) {
        try {
            Class<?> policyMgr = Class.forName("com.android.internal.policy.PolicyManager");
            Method method = policyMgr.getDeclaredMethod("makeNewWindow", Context.class);
            return (Window) method.invoke(null, context);
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "no class for com.android.internal.policy.PolicyManager.", e);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "no method for com.android.internal.policy.PolicyManager#makeNewWindow.", e);
        } catch (InvocationTargetException e) {
            Log.e(TAG, "an error occured while invoking the method.", e);
        } catch (IllegalAccessException e) {
            Log.e(TAG, "cannot access to the method.", e);
        }
        return null;
    }

    public static int getHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int statusBarHeight = getStatusBarHeight(context);
        return windowManager.getDefaultDisplay().getHeight() - statusBarHeight;
    }

    public static int getWidth(Context context) {
        WindowManager windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        return windowManager.getDefaultDisplay().getWidth();
    }

    public static WindowInfo getWindowInfo(Context context) {
        return new WindowInfo(getWidth(context), getHeight(context));
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static class WindowInfo {
        public final int width;
        public final int height;

        private WindowInfo(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
