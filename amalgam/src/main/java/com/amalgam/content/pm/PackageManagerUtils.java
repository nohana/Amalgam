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
package com.amalgam.content.pm;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.util.Log;

/**
 * Utility for {@link android.content.pm.PackageManager}.
 */
@SuppressWarnings("unused") // public APIs
public  class PackageManagerUtils {
    public static final String TAG = PackageManagerUtils.class.getSimpleName();
    private static final int FALLBACK_VERSION_CODE = 0;

    private PackageManagerUtils() {
        throw new AssertionError();
    }

    /**
     * Read version code from the manifest of the context.
     * @param context the context.
     * @return the version code, {@code 0} if not found.
     */
    public static int getVersionCode(Context context) {
        return getVersionCode(context, FALLBACK_VERSION_CODE);
    }

    /**
     * Read version code from the manifest of the context.
     * @param context the context.
     * @param fallback fallback value of the version code.
     * @return the version code, or fallback value if not found.
     */
    public static int getVersionCode(Context context, int fallback) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (NameNotFoundException e) {
            Log.e(TAG, "no such package installed on the device: ", e);
        }
        return fallback;
    }

    /**
     * Read version name from the manifest of the context.
     * @param context the context.
     * @return the version name.
     * @throws java.lang.IllegalStateException if the target package is not installed.
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("no such package installed on the device: ", e);
        }
    }

    /**
     * Checks if the target package is installed on this device.
     * @param context the context.
     * @param targetPackage the target package name.
     * @return {@code true} if installed, false otherwise.
     */
    public static boolean isPackageInstalled(Context context, String targetPackage) {
        PackageManager manager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setPackage(targetPackage);
        return manager.resolveActivity(intent, 0) != null;
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains signature info.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getSignaturePackageInfo(Context context) throws NameNotFoundException {
        return getSignaturePackageInfo(context, context.getPackageName());
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains signature info.
     * @param context the context.
     * @param targetPackage the the target package name.
     * @return the {@link android.content.pm.PackageInfo}
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getSignaturePackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_SIGNATURES);
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains all activities declaration for the context.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getActivityPackageInfo(Context context) throws NameNotFoundException {
        return getActivityPackageInfo(context, context.getPackageName());
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains all activities declaration for the context.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getActivityPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_ACTIVITIES);
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains intent-filter declaration for the context.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getIntentFilterPackageInfo(Context context) throws NameNotFoundException {
        return getIntentFilterPackageInfo(context, context.getPackageName());
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains intent-filter declaration for the context.
     * @param context the context.
     * @param targetPackage the target package name.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getIntentFilterPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_INTENT_FILTERS);
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains all service declaration for the context.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getServicePackageInfo(Context context) throws NameNotFoundException {
        return getServicePackageInfo(context, context.getPackageName());
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains all service declaration for the context.
     * @param context the context.
     * @param targetPackage the target package name.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getServicePackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_SERVICES);
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains all content provider declaration for the context.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getProviderPackageInfo(Context context) throws NameNotFoundException {
        return getProviderPackageInfo(context, context.getPackageName());
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains all content provider declaration for the context.
     * @param context the context.
     * @param targetPackage the target package name.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getProviderPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_PROVIDERS);
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains permission declaration for the context.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getPermissionPackageInfo(Context context) throws NameNotFoundException {
        return getPermissionPackageInfo(context, context.getPackageName());
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains permission declaration for the context.
     * @param context the context.
     * @param targetPackage the target package name.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getPermissionPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_PERMISSIONS);
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains broadcast receiver declaration for the context.
     * @param context the context.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getReceiverPackageInfo(Context context) throws NameNotFoundException {
        return getReceiverPackageInfo(context, context.getPackageName());
    }

    /**
     * Get the {@link android.content.pm.PackageInfo} that contains broadcast receiver declaration for the context.
     * @param context the context.
     * @param targetPackage the target package name.
     * @return the {@link android.content.pm.PackageInfo}.
     * @throws NameNotFoundException if no package found.
     */
    public static PackageInfo getReceiverPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_RECEIVERS);
    }

    /**
     * Checks if the device has an app widget feature.
     * @param context the context.
     * @return {@code true} if the device has an app widget feature.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasAppWidgetFeature(Context context) {
        return hasAppWidgetFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has an app widget feature.
     * @param manager the package manager.
     * @return {@code true} if the device has an app widget feature.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasAppWidgetFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_APP_WIDGETS);
    }

    /**
     * Checks if the device has a low latency audio feature.
     * @param context the context.
     * @return {@code true} if the device has a low latency audio feature.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasLowLatencyAudioFeature(Context context) {
        return hasLowLatencyAudioFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a low latency audio feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a low latency audio feature.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasLowLatencyAudioFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_AUDIO_LOW_LATENCY);
    }

    /**
     * Checks if the device has a bluetooth.
     * @param context the context.
     * @return {@code true} if the device has a bluetooth.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasBluetoothFeature(Context context) {
        return hasBluetoothFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a bluetooth.
     * @param manager the package manager.
     * @return {@code true} if the device has a bluetooth.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasBluetoothFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH);
    }

    /**
     * Checks if the device has a bluetooth low energy.
     * @param context the context.
     * @return {@code true} if the device has a bluetooth low energy.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasBluetoothLEFeature(Context context) {
        return hasBluetoothLEFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a bluetooth low energy.
     * @param manager the package manager.
     * @return {@code true} if the device has a bluetooth low energy.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasBluetoothLEFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE);
    }

    /**
     * Checks if the device has a camera.
     * @param context the context.
     * @return {@code true} if the device has a camera.
     */
    public static boolean hasCameraFeature(Context context) {
        return hasCameraFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a camera.
     * @param manager the package manager.
     * @return {@code true} if the device has a camera.
     */
    public static boolean hasCameraFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    /**
     * Checks if the device has at least one camera.
     * @param context the context.
     * @return {@code true} if the device has at least one camera.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean hasCameraFeatureAtLeastOne(Context context) {
        return hasCameraFeatureAtLeastOne(context.getPackageManager());
    }

    /**
     * Checks if the device has at least one camera.
     * @param manager the package manager.
     * @return {@code true} if the device has at least one camera.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean hasCameraFeatureAtLeastOne(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    /**
     * Checks if the device has an auto focusable camera.
     * @param context the context.
     * @return {@code true} if the device has an auto focusable camera.
     */
    public static boolean hasAutoFocusCameraFeature(Context context) {
        return hasAutoFocusCameraFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has an auto focusable camera.
     * @param manager the package manager.
     * @return {@code true} if the device has an auto focusable camera.
     */
    public static boolean hasAutoFocusCameraFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_AUTOFOCUS);
    }

    /**
     * Checks if the device has a camera flash.
     * @param context the context.
     * @return {@code true} if the device has a camera flash.
     */
    public static boolean hasCameraFlashFeature(Context context) {
        return hasCameraFlashFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a camera flash.
     * @param manager the package manager.
     * @return {@code true} if the device has a camera flash.
     */
    public static boolean hasCameraFlashFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    /**
     * Checks if the device has a front camera.
     * @param context the context.
     * @return {@code true} if the device has a front camera.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasFrontCameraFeature(Context context) {
        return hasFrontCameraFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a front camera.
     * @param manager the package manager.
     * @return {@code true} if the device has a front camera.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasFrontCameraFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
    }

    /**
     * Checks if the device has a consumer IR feature.
     * @param context the context.
     * @return {@code true} if the device has a consumer IR feature.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasConsumerIrFeature(Context context) {
        return hasConsumerIrFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a consumer IR feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a consumer IR feature.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasConsumerIrFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CONSUMER_IR);
    }

    /**
     * Checks if the device has a device administrative feature.
     * @param context the context.
     * @return {@code true} if the device has a device administrative feature.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasDeviceAdminFeature(Context context) {
        return hasDeviceAdminFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a device administrative feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a device administrative feature.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasDeviceAdminFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_DEVICE_ADMIN);
    }

    /**
     * Checks if the device has a fake touch feature.
     * @param context the context.
     * @return {@code true} if the device has a fake touch feature.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static boolean hasFakeTouchFeature(Context context) {
        return hasFakeTouchFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a fake touch feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a fake touch feature.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static boolean hasFakeTouchFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH);
    }

    /**
     * Checks if the device has a distinct fake multi touch feature.
     * @param context the context.
     * @return {@code true} if the device has a distinct fake multi touch feature.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasDistinctMultiFakeTouchFeature(Context context) {
        return hasDistinctMultiFakeTouchFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a distinct fake multi touch feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a distinct fake multi touch feature.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasDistinctMultiFakeTouchFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT);
    }

    /**
     * Checks if the device has a jazzhand fake multi touch feature.
     * @param context the context.
     * @return {@code true} if the device has a jazzhand fake multi touch feature.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasJazzhandMultiFakeTouchFeature(Context context) {
        return hasJazzhandMultiFakeTouchFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a jazzhand fake multi touch feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a jazzhand fake multi touch feature.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasJazzhandMultiFakeTouchFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND);
    }

    /**
     * Checks if the device has a home screen.
     * @param context the context.
     * @return {@code true} if the device has a home screen.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasHomeScreenFeature(Context context) {
        return hasHomeScreenFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a home screen.
     * @param manager the package manager.
     * @return {@code true} if the device has a home screen.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasHomeScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_HOME_SCREEN);
    }

    /**
     * Checks if the device has a input methods.
     * @param context the context.
     * @return {@code true} if the device has a input methods.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasInputMethodsFeature(Context context) {
        return hasInputMethodsFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a input methods.
     * @param manager the package manager.
     * @return {@code true} if the device has a input methods.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static boolean hasInputMethodsFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_INPUT_METHODS);
    }

    /**
     * Checks if the device has a live wallpaper.
     * @param context the context.
     * @return {@code true} if the device has a live wallpaper.
     */
    public static boolean hasLiveWallpaperFeature(Context context) {
        return hasLiveWallpaperFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a live wallpaper.
     * @param manager the package manager.
     * @return {@code true} if the device has a live wallpaper.
     */
    public static boolean hasLiveWallpaperFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LIVE_WALLPAPER);
    }

    /**
     * Checks if the device has a location feature.
     * @param context the context.
     * @return {@code true} if the device has a location feature.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasLocationFeature(Context context) {
        return hasLocationFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a location feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a location feature.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasLocationFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LOCATION);
    }

    /**
     * Checks if the device has a GPS location feature.
     * @param context the context.
     * @return {@code true} if the device has a GPS location feature.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasGpsLocationFeature(Context context) {
        return hasGpsLocationFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a GPS location feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a GPS location feature.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasGpsLocationFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
    }

    /**
     * Checks if the device has a network location feature.
     * @param context the context.
     * @return {@code true} if the device has a network location feature.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasNetworkLocationFeature(Context context) {
        return hasNetworkLocationFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a network location feature.
     * @param manager the package manager.
     * @return {@code true} if the device has a network location feature.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasNetworkLocationFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LOCATION_NETWORK);
    }

    /**
     * Checks if the device has a microphone.
     * @param context the context.
     * @return {@code true} if the device has a microphone.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasMicrophoneFeature(Context context) {
        return hasMicrophoneFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a microphone.
     * @param manager the package manager.
     * @return {@code true} if the device has a microphone.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasMicrophoneFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }

    /**
     * Checks if the device has a NFC.
     * @param context the context.
     * @return {@code true} if the device has a NFC.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasNfcFeature(Context context) {
        return hasNfcFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a NFC.
     * @param manager the package manager.
     * @return {@code true} if the device has a NFC.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasNfcFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_NFC);
    }

    /**
     * Checks if the device has a NFC that can emulate host card.
     * @param context the context.
     * @return {@code true} if the device has a NFC that can emulate host card.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasHostCardEmulationNfcFeature(Context context) {
        return hasHostCardEmulationNfcFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a NFC that can emulate host card.
     * @param manager the package manager.
     * @return {@code true} if the device has a NFC that can emulate host card.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasHostCardEmulationNfcFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_NFC_HOST_CARD_EMULATION);
    }

    /**
     * Checks if the device has a landscape screen.
     * @param context the context.
     * @return {@code true} if the device has a landscape screen.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasLandscapeScreenFeature(Context context) {
        return hasLandscapeScreenFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a landscape screen.
     * @param manager the package manager.
     * @return {@code true} if the device has a landscape screen.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasLandscapeScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SCREEN_LANDSCAPE);
    }

    /**
     * Checks if the device has a portrait screen.
     * @param context the context.
     * @return {@code true} if the device has a portrait screen.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasPortraitScreenFeature(Context context) {
        return hasPortraitScreenFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a portrait screen.
     * @param manager the package manager.
     * @return {@code true} if the device has a portrait screen.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static boolean hasPortraitScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SCREEN_PORTRAIT);
    }

    /**
     * Checks if the device has a accelerometer sensor.
     * @param context the context.
     * @return {@code true} if the device has a accelerometer sensor.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasAccelerometerSensorFeature(Context context) {
        return hasAccelerometerSensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a accelerometer sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a accelerometer sensor.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasAccelerometerSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
    }

    /**
     * Checks if the device has a barometer sensor.
     * @param context the context.
     * @return {@code true} if the device has a barometer sensor.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasBarometerSensorFeature(Context context) {
        return hasBarometerSensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a barometer sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a barometer sensor.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasBarometerSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_BAROMETER);
    }

    /**
     * Checks if the device has a compass sensor.
     * @param context the context.
     * @return {@code true} if the device has a compass sensor.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasCompassSensorFeature(Context context) {
        return hasCompassSensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a compass sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a compass sensor.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasCompassSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS);
    }

    /**
     * Checks if the device has a gyroscope sensor.
     * @param context the context.
     * @return {@code true} if the device has a gyroscope sensor.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasGyroscopeSensorFeature(Context context) {
        return hasGyroscopeSensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a gyroscope sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a gyroscope sensor.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasGyroscopeSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
    }

    /**
     * Checks if the device has a light sensor.
     * @param context the context.
     * @return {@code true} if the device has a light sensor.
     */
    public static boolean hasLightSensorFeature(Context context) {
        return hasLightSensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a light sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a light sensor.
     */
    public static boolean hasLightSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_LIGHT);
    }

    /**
     * Checks if the device has a proximity sensor.
     * @param context the context.
     * @return {@code true} if the device has a proximity sensor.
     */
    public static boolean hasProximitySensorFeature(Context context) {
        return hasProximitySensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a proximity sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a proximity sensor.
     */
    public static boolean hasProximitySensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_PROXIMITY);
    }

    /**
     * Checks if the device has a step counter sensor.
     * @param context the context.
     * @return {@code true} if the device has a step counter sensor.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasStepCounterSensorFeature(Context context) {
        return hasStepCounterSensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a step counter sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a step counter sensor.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasStepCounterSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER);
    }

    /**
     * Checks if the device has a step detector sensor.
     * @param context the context.
     * @return {@code true} if the device has a step detector sensor.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasStepDetectorSensorFeature(Context context) {
        return hasStepDetectorSensorFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a step detector sensor.
     * @param manager the package manager.
     * @return {@code true} if the device has a step detector sensor.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static boolean hasStepDetectorSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_DETECTOR);
    }

    /**
     * Checks if the device has a SIP.
     * @param context the context.
     * @return {@code true} if the device has a SIP.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasSipFeature(Context context) {
        return hasSipFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a SIP.
     * @param manager the package manager.
     * @return {@code true} if the device has a SIP.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasSipFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SIP);
    }

    /**
     * Checks if the device has a SIP VoIP.
     * @param context the context.
     * @return {@code true} if the device has a SIP VoIP.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasSipVoipFeature(Context context) {
        return hasSipVoipFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a SIP VoIP.
     * @param manager the package manager.
     * @return {@code true} if the device has a SIP VoIP.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasSipVoipFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SIP_VOIP);
    }

    /**
     * Checks if the device has a telephony.
     * @param context the context.
     * @return {@code true} if the device has a telephony.
     */
    public static boolean hasTelephonyFeature(Context context) {
        return hasTelephonyFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a telephony.
     * @param manager the package manager.
     * @return {@code true} if the device has a telephony.
     */
    public static boolean hasTelephonyFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
    }

    /**
     * Checks if the device has a CDMA telephony.
     * @param context the context.
     * @return {@code true} if the device has a CDMA telephony.
     */
    public static boolean hasCdmaTelephonyFeature(Context context) {
        return hasCdmaTelephonyFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a CDMA telephony.
     * @param manager the package manager.
     * @return {@code true} if the device has a CDMA telephony.
     */
    public static boolean hasCdmaTelephonyFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA);
    }

    /**
     * Checks if the device has a GSM telephony.
     * @param context the context.
     * @return {@code true} if the device has a GSM telephony.
     */
    public static boolean hasGsmTelephonyFeature(Context context) {
        return hasGsmTelephonyFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a GSM telephony.
     * @param manager the package manager.
     * @return {@code true} if the device has a GSM telephony.
     */
    public static boolean hasGsmTelephonyFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM);
    }

    /**
     * Checks if the device has a television.
     * @param context the context.
     * @return {@code true} if the device has a television.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean hasTelevisionFeature(Context context) {
        return hasTelevisionFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a television.
     * @param manager the package manager.
     * @return {@code true} if the device has a television.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean hasTelevisionFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEVISION);
    }

    /**
     * Checks if the device has a touch screen.
     * @param context the context.
     * @return {@code true} if the device has a touch screen.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasTouchScreenFeature(Context context) {
        return hasTouchScreenFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a touch screen.
     * @param manager the package manager.
     * @return {@code true} if the device has a touch screen.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN);
    }

    /**
     * Checks if the device has a multi touch screen.
     * @param context the context.
     * @return {@code true} if the device has a multi touch screen.
     */
    public static boolean hasMultiTouchScreenFeature(Context context) {
        return hasMultiTouchScreenFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a multi touch screen.
     * @param manager the package manager.
     * @return {@code true} if the device has a multi touch screen.
     */
    public static boolean hasMultiTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH);
    }

    /**
     * Checks if the device has a distinct multi touch screen.
     * @param context the context.
     * @return {@code true} if the device has a distinct multi touch screen.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasDistinctMultiTouchScreenFeature(Context context) {
        return hasDistinctMultiTouchScreenFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a distinct multi touch screen.
     * @param manager the package manager.
     * @return {@code true} if the device has a distinct multi touch screen.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasDistinctMultiTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT);
    }

    /**
     * Checks if the device has a jazzhand multi touch screen.
     * @param context the context.
     * @return {@code true} if the device has a jazzhand multi touch screen.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasJazzhandMultiTouchScreenFeature(Context context) {
        return hasJazzhandMultiTouchScreenFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a jazzhand multi touch screen.
     * @param manager the package manager.
     * @return {@code true} if the device has a jazzhand multi touch screen.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static boolean hasJazzhandMultiTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND);
    }

    /**
     * Checks if the device has an USB accessory.
     * @param context the context.
     * @return {@code true} if the device has an USB accessory.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static boolean hasUsbAccessoryFeature(Context context) {
        return hasUsbAccessoryFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has an USB accessory.
     * @param manager the package manager.
     * @return {@code true} if the device has an USB accessory.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static boolean hasUsbAccessoryFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_USB_ACCESSORY);
    }

    /**
     * Checks if the device has an USB host.
     * @param context the context.
     * @return {@code true} if the device has an USB host.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static boolean hasUsbHostFeature(Context context) {
        return hasUsbHostFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has an USB host.
     * @param manager the package manager.
     * @return {@code true} if the device has an USB host.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static boolean hasUsbHostFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_USB_HOST);
    }

    /**
     * Checks if the device has a WIFI.
     * @param context the context.
     * @return {@code true} if the device has a WIFI.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasWifiFeature(Context context) {
        return hasWifiFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a WIFI.
     * @param manager the package manager.
     * @return {@code true} if the device has a WIFI.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean hasWifiFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_WIFI);
    }

    /**
     * Checks if the device has a WIFI Direct.
     * @param context the context.
     * @return {@code true} if the device has a WIFI Direct.
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static boolean hasWifiDirectFeature(Context context) {
        return hasWifiDirectFeature(context.getPackageManager());
    }

    /**
     * Checks if the device has a WIFI Direct.
     * @param manager the package manager.
     * @return {@code true} if the device has a WIFI Direct.
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static boolean hasWifiDirectFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_WIFI_DIRECT);
    }
}