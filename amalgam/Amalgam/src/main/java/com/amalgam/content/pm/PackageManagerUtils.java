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

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

import com.amalgam.R;

/**
 */
public final class PackageManagerUtils {
    public static final String TAG = PackageManagerUtils.class.getSimpleName();
    private static final int FALLBACK_VERSION_CODE = 0;

    private PackageManagerUtils() {}

    public static final int getVersionCode(Context context) {
        return getVersionCode(context, FALLBACK_VERSION_CODE);
    }

    public static final int getVersionCode(Context context, int fallback) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (NameNotFoundException e) {
            Log.e(TAG, "no such package installed on the device: ", e);
        }
        return fallback;
    }

    public static final String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("no such package installed on the device: ", e);
        }
    }

    public static final boolean isPackageInstalled(Context context, String targetPackage) {
        PackageManager manager = context.getPackageManager();
        Intent intent = new Intent();
        intent.setPackage(targetPackage);
        return manager.resolveActivity(intent, 0) != null;
    }

    public static final PackageInfo getSignaturePackageInfo(Context context) throws NameNotFoundException {
        return getSignaturePackageInfo(context, context.getPackageName());
    }

    public static final PackageInfo getSignaturePackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_SIGNATURES);
    }

    public static final PackageInfo getActivityPackageInfo(Context context) throws NameNotFoundException {
        return getActivityPackageInfo(context, context.getPackageName());
    }

    public static final PackageInfo getActivityPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_ACTIVITIES);
    }

    public static final PackageInfo getIntentFilterPackageInfo(Context context) throws NameNotFoundException {
        return getIntentFilterPackageInfo(context, context.getPackageName());
    }

    public static final PackageInfo getIntentFilterPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_INTENT_FILTERS);
    }

    public static final PackageInfo getServicePackageInfo(Context context) throws NameNotFoundException {
        return getServicePackageInfo(context, context.getPackageName());
    }

    public static final PackageInfo getServicePackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_SERVICES);
    }

    public static final PackageInfo getProviderPackageInfo(Context context) throws NameNotFoundException {
        return getProviderPackageInfo(context, context.getPackageName());
    }

    public static final PackageInfo getProviderPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_PROVIDERS);
    }

    public static final PackageInfo getPermissionPackageInfo(Context context) throws NameNotFoundException {
        return getPermissionPackageInfo(context, context.getPackageName());
    }

    public static final PackageInfo getPermissionPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_PERMISSIONS);
    }

    public static final PackageInfo getReceiverPackageInfo(Context context) throws NameNotFoundException {
        return getReceiverPackageInfo(context, context.getPackageName());
    }

    public static final PackageInfo getReceiverPackageInfo(Context context, String targetPackage) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(targetPackage, PackageManager.GET_RECEIVERS);
    }

    public static final boolean hasAppWidgetFeature(Context context) {
        return hasAppWidgetFeature(context.getPackageManager());
    }

    public static final boolean hasAppWidgetFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_APP_WIDGETS);
    }

    public static final boolean hasLowLatencyAudioFeature(Context context) {
        return hasLowLatencyAudioFeature(context.getPackageManager());
    }

    public static final boolean hasLowLatencyAudioFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_AUDIO_LOW_LATENCY);
    }

    public static final boolean hasBluetoothFeature(Context context) {
        return hasBluetoothFeature(context.getPackageManager());
    }

    public static final boolean hasBluetoothFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH);
    }

    public static final boolean hasBluetoothLEFeature(Context context) {
        return hasBluetoothLEFeature(context.getPackageManager());
    }

    public static final boolean hasBluetoothLEFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE);
    }

    public static final boolean hasCameraFeature(Context context) {
        return hasCameraFeature(context.getPackageManager());
    }

    public static final boolean hasCameraFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    public static final boolean hasCameraFeatureAtLeastOne(Context context) {
        return hasCameraFeatureAtLeastOne(context.getPackageManager());
    }

    public static final boolean hasCameraFeatureAtLeastOne(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public static final boolean hasAutoFocusCameraFeature(Context context) {
        return hasAutoFocusCameraFeature(context.getPackageManager());
    }

    public static final boolean hasAutoFocusCameraFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_AUTOFOCUS);
    }

    public static final boolean hasCameraFlashFeature(Context context) {
        return hasCameraFlashFeature(context.getPackageManager());
    }

    public static final boolean hasCameraFlashFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public static final boolean hasFrontCameraFeature(Context context) {
        return hasFrontCameraFeature(context.getPackageManager());
    }

    public static final boolean hasFrontCameraFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
    }

    public static final boolean hasConsumerIrFeature(Context context) {
        return hasConsumerIrFeature(context.getPackageManager());
    }

    public static final boolean hasConsumerIrFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_CONSUMER_IR);
    }

    public static final boolean hasDeviceAdminFeature(Context context) {
        return hasDeviceAdminFeature(context.getPackageManager());
    }

    public static final boolean hasDeviceAdminFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_DEVICE_ADMIN);
    }

    public static final boolean hasFakeTouchFeature(Context context) {
        return hasFakeTouchFeature(context.getPackageManager());
    }

    public static final boolean hasFakeTouchFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH);
    }

    public static final boolean hasDistinctMultiFakeTouchFeature(Context context) {
        return hasDistinctMultiFakeTouchFeature(context.getPackageManager());
    }

    public static final boolean hasDistinctMultiFakeTouchFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT);
    }

    public static final boolean hasJazzhandMultiFakeTouchFeature(Context context) {
        return hasJazzhandMultiFakeTouchFeature(context.getPackageManager());
    }

    public static final boolean hasJazzhandMultiFakeTouchFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND);
    }

    public static final boolean hasHomeScreenFeature(Context context) {
        return hasHomeScreenFeature(context.getPackageManager());
    }

    public static final boolean hasHomeScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_HOME_SCREEN);
    }

    public static final boolean hasInputMethodsFeature(Context context) {
        return hasInputMethodsFeature(context.getPackageManager());
    }

    public static final boolean hasInputMethodsFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_INPUT_METHODS);
    }

    public static final boolean hasLiveWallpaperFeature(Context context) {
        return hasLiveWallpaperFeature(context.getPackageManager());
    }

    public static final boolean hasLiveWallpaperFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LIVE_WALLPAPER);
    }

    public static final boolean hasLocationFeature(Context context) {
        return hasLocationFeature(context.getPackageManager());
    }

    public static final boolean hasLocationFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LOCATION);
    }

    public static final boolean hasGpsLocationFeature(Context context) {
        return hasGpsLocationFeature(context.getPackageManager());
    }

    public static final boolean hasGpsLocationFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
    }

    public static final boolean hasNetworkLocationFeature(Context context) {
        return hasNetworkLocationFeature(context.getPackageManager());
    }

    public static final boolean hasNetworkLocationFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_LOCATION_NETWORK);
    }

    public static final boolean hasMicrophoneFeature(Context context) {
        return hasMicrophoneFeature(context.getPackageManager());
    }

    public static final boolean hasMicrophoneFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }

    public static final boolean hasNfcFeature(Context context) {
        return hasNfcFeature(context.getPackageManager());
    }

    public static final boolean hasNfcFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_NFC);
    }

    public static final boolean hasHostCardEmulationNfcFeature(Context context) {
        return hasHostCardEmulationNfcFeature(context.getPackageManager());
    }

    public static final boolean hasHostCardEmulationNfcFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_NFC_HOST_CARD_EMULATION);
    }

    public static final boolean hasLandscapeScreenFeature(Context context) {
        return hasLandscapeScreenFeature(context.getPackageManager());
    }

    public static final boolean hasLandscapeScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SCREEN_LANDSCAPE);
    }

    public static final boolean hasPortraitScreenFeature(Context context) {
        return hasPortraitScreenFeature(context.getPackageManager());
    }

    public static final boolean hasPortraitScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SCREEN_PORTRAIT);
    }

    public static final boolean hasAccelerometerSensorFeature(Context context) {
        return hasAccelerometerSensorFeature(context.getPackageManager());
    }

    public static final boolean hasAccelerometerSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER);
    }

    public static final boolean hasBarometerSensorFeature(Context context) {
        return hasBarometerSensorFeature(context.getPackageManager());
    }

    public static final boolean hasBarometerSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_BAROMETER);
    }

    public static final boolean hasCompassSensorFeature(Context context) {
        return hasCompassSensorFeature(context.getPackageManager());
    }

    public static final boolean hasCompassSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS);
    }

    public static final boolean hasGyroscopeSensorFeature(Context context) {
        return hasGyroscopeSensorFeature(context.getPackageManager());
    }

    public static final boolean hasGyroscopeSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
    }

    public static final boolean hasLightSensorFeature(Context context) {
        return hasLightSensorFeature(context.getPackageManager());
    }

    public static final boolean hasLightSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_LIGHT);
    }

    public static final boolean hasProximitySensorFeature(Context context) {
        return hasProximitySensorFeature(context.getPackageManager());
    }

    public static final boolean hasProximitySensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_PROXIMITY);
    }

    public static final boolean hasStepCounterSensorFeature(Context context) {
        return hasStepCounterSensorFeature(context.getPackageManager());
    }

    public static final boolean hasStepCounterSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER);
    }

    public static final boolean hasStepDetectorSensorFeature(Context context) {
        return hasStepDetectorSensorFeature(context.getPackageManager());
    }

    public static final boolean hasStepDetectorSensorFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_DETECTOR);
    }

    public static final boolean hasSipFeature(Context context) {
        return hasSipFeature(context.getPackageManager());
    }

    public static final boolean hasSipFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SIP);
    }

    public static final boolean hasSipVoipFeature(Context context) {
        return hasSipVoipFeature(context.getPackageManager());
    }

    public static final boolean hasSipVoipFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_SIP_VOIP);
    }

    public static final boolean hasTelephonyFeature(Context context) {
        return hasTelephonyFeature(context.getPackageManager());
    }

    public static final boolean hasTelephonyFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
    }

    public static final boolean hasCdmaTelephonyFeature(Context context) {
        return hasCdmaTelephonyFeature(context.getPackageManager());
    }

    public static final boolean hasCdmaTelephonyFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA);
    }

    public static final boolean hasGsmTelephonyFeature(Context context) {
        return hasGsmTelephonyFeature(context.getPackageManager());
    }

    public static final boolean hasGsmTelephonyFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM);
    }

    public static final boolean hasTelevisionFeature(Context context) {
        return hasTelevisionFeature(context.getPackageManager());
    }

    public static final boolean hasTelevisionFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TELEVISION);
    }

    public static final boolean hasTouchScreenFeature(Context context) {
        return hasTouchScreenFeature(context.getPackageManager());
    }

    public static final boolean hasTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN);
    }

    public static final boolean hasMultiTouchScreenFeature(Context context) {
        return hasMultiTouchScreenFeature(context.getPackageManager());
    }

    public static final boolean hasMultiTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH);
    }

    public static final boolean hasDistinctMultiTouchScreenFeature(Context context) {
        return hasDistinctMultiTouchScreenFeature(context.getPackageManager());
    }

    public static final boolean hasDistinctMultiTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT);
    }

    public static final boolean hasJazzhandMultiTouchScreenFeature(Context context) {
        return hasJazzhandMultiTouchScreenFeature(context.getPackageManager());
    }

    public static final boolean hasJazzhandMultiTouchScreenFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND);
    }

    public static final boolean hasUsbAccessoryFeature(Context context) {
        return hasUsbAccessoryFeature(context.getPackageManager());
    }

    public static final boolean hasUsbAccessoryFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_USB_ACCESSORY);
    }

    public static final boolean hasUsbHostFeature(Context context) {
        return hasUsbHostFeature(context.getPackageManager());
    }

    public static final boolean hasUsbHostFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_USB_HOST);
    }

    public static final boolean hasWifiFeature(Context context) {
        return hasWifiFeature(context.getPackageManager());
    }

    public static final boolean hasWifiFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_WIFI);
    }

    public static final boolean hasWifiDirectFeature(Context context) {
        return hasWifiDirectFeature(context.getPackageManager());
    }

    public static final boolean hasWifiDirectFeature(PackageManager manager) {
        return manager.hasSystemFeature(PackageManager.FEATURE_WIFI_DIRECT);
    }
}