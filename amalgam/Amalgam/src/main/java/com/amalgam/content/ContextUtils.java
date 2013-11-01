package com.amalgam.content;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.File;

/**
 */
public final class ContextUtils {
    private ContextUtils() {}

    public static final Application getApplication(Context context) {
        return (Application) context.getApplicationContext();
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForPictures(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForMusic(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForMovies(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForAlarms(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_ALARMS);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForDcim(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_DCIM);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForNotifications(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForDownloads(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForPodCasts(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_PODCASTS);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public static final File getExternalFilesDirForRingtones(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_RINGTONES);
    }
}