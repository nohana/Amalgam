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
package com.amalgam.content;

import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.admin.DevicePolicyManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipboardManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.DropBoxManager;
import android.os.Environment;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.service.wallpaper.WallpaperService;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;

import java.io.File;

/**
 * Utility for the {@link android.content.Context}.
 */
@SuppressWarnings("unused") // Public APIs
public class ContextUtils {
    private ContextUtils() {
        throw new AssertionError();
    }

    /**
     * Obtain {@link android.app.Application} from the context.
     * @param context the context.
     * @return the {@link android.app.Application}.
     */
    public static Application getApplication(Context context) {
        return (Application) context.getApplicationContext();
    }

    /**
     * Get the file points to an external pictures directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForPictures(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    /**
     * Get the file points to an external music directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForMusic(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
    }

    /**
     * Get the file points to an external movies directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForMovies(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
    }

    /**
     * Get the file points to an external alarms directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForAlarms(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_ALARMS);
    }

    /**
     * Get the file points to an external dcim directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForDcim(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_DCIM);
    }

    /**
     * Get the file points to an external notifications directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForNotifications(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS);
    }

    /**
     * Get the file points to an external downloads directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForDownloads(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    }

    /**
     * Get the file points to an external pictures directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForPodCasts(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_PODCASTS);
    }

    /**
     * Get the file points to an external ringtones directory.
     * @param context the context.
     * @return the {@link java.io.File}.
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static File getExternalFilesDirForRingtones(Context context) {
        return context.getExternalFilesDir(Environment.DIRECTORY_RINGTONES);
    }

    /**
     * Get the {@link android.app.AlarmManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.AlarmManager}.
     */
    public static AlarmManager getAlarmManager(Context context) {
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    /**
     * Get the {@link android.app.NotificationManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.NotificationManager}.
     */
    public static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    /**
     * Get the {@link android.app.ActivityManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.ActivityManager}.
     */
    public static ActivityManager  getActivityManager(Context context) {
        return (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    /**
     * Get the {@link android.os.PowerManager} service for this context.
     * @param context the context.
     * @return the {@link android.os.PowerManager}.
     */
    public static PowerManager getPowerManager(Context context) {
        return (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    }

    /**
     * Get the {@link android.view.inputmethod.InputMethodManager} service for this context.
     * @param context the context.
     * @return the {@link android.view.inputmethod.InputMethodManager}.
     */
    public static InputMethodManager getInputMethodManager(Context context) {
        return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    /**
     * Get the {@link android.hardware.input.InputManager} service for this context.
     * @param context the context.
     * @return the {@link android.hardware.input.InputManager}
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static InputManager getInputManager(Context context) {
        return (InputManager) context.getSystemService(Context.INPUT_SERVICE);
    }

    /**
     * Get the {@link android.net.ConnectivityManager} service for this context.
     * @param context the context.
     * @return the {@link android.net.ConnectivityManager}
     */
    public static ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * Get the {@link android.view.LayoutInflater} service for this context.
     * @see android.view.LayoutInflater#from(android.content.Context).
     * @param context the context.
     * @return the {@link android.view.LayoutInflater}
     */
    public static LayoutInflater getLayoutInflater(Context context) {
        return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Get the {@link android.view.WindowManager} service for this context.
     * @param context the context.
     * @return the {@link android.view.WindowManager}
     */
    public static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    /**
     * Get the {@link android.accounts.AccountManager} service for this context.
     * @see android.accounts.AccountManager#get(android.content.Context).
     * @param context the context.
     * @return the {@link android.accounts.AccountManager}
     */
    public static AccountManager getAccountManager(Context context) {
        return (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
    }

    /**
     * Get the {@link android.nfc.NfcManager} service for this context.
     * @param context the context.
     * @return the {@link android.nfc.NfcManager}
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD_MR1)
    public static NfcManager getNfcManager(Context context) {
        return (NfcManager) context.getSystemService(Context.NFC_SERVICE);
    }

    /**
     * Get the {@link android.view.accessibility.AccessibilityManager} service for this context.
     * @param context the context.
     * @return the {@link android.view.accessibility.AccessibilityManager}
     */
    public static AccessibilityManager getAccessibilityManager(Context context) {
        return (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
    }

    /**
     * Get the {@link android.media.AudioManager} service for this context.
     * @param context the context.
     * @return the {@link android.media.AudioManager}
     */
    public static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    /**
     * Get the {@link android.bluetooth.BluetoothAdapter} service for this context.
     * @param context the context.
     * @return the {@link android.bluetooth.BluetoothAdapter}
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @SuppressWarnings("ServiceCast")
    public static BluetoothAdapter getBluetoothAdapter(Context context) {
        return (BluetoothAdapter) context.getSystemService(Context.BLUETOOTH_SERVICE);
    }

    /**
     * Get the {@link android.content.ClipboardManager} service for this context.
     * @param context the context.
     * @return the {@link android.content.ClipboardManager}
     */
    public static ClipboardManager getClipboardManager(Context context) {
        return (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    }

    /**
     * Get the {@link android.app.admin.DevicePolicyManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.admin.DevicePolicyManager}
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static DevicePolicyManager getDevicePolicyManager(Context context) {
        return (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
    }

    /**
     * Get the {@link android.hardware.display.DisplayManager} service for this context.
     * @param context the context.
     * @return the {@link android.hardware.display.DisplayManager}
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static DisplayManager getDisplayManager(Context context) {
        return (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
    }

    /**
     * Get the {@link android.app.DownloadManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.DownloadManager}
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static DownloadManager getDownloadManager(Context context) {
        return (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
    }

    /**
     * Get the {@link android.os.DropBoxManager} service for this context.
     * @param context the context.
     * @return the {@link android.os.DropBoxManager}
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static DropBoxManager getDropBoxManager(Context context) {
        return (DropBoxManager) context.getSystemService(Context.DROPBOX_SERVICE);
    }

    /**
     * Get the {@link android.app.KeyguardManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.KeyguardManager}
     */
    public static KeyguardManager getKeyguardManager(Context context) {
        return (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
    }

    /**
     * Get the {@link android.location.LocationManager} service for this context.
     * @param context the context.
     * @return the {@link android.location.LocationManager}
     */
    public static LocationManager getLocationManager(Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    /**
     * Get the {@link android.media.MediaRouter} service for this context.
     * @param context the context.
     * @return the {@link android.media.MediaRouter}
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static MediaRouter getMediaRouter(Context context) {
        return (MediaRouter) context.getSystemService(Context.MEDIA_ROUTER_SERVICE);
    }

    /**
     * Get the {@link android.net.nsd.NsdManager} service for this context.
     * @param context the context.
     * @return the {@link android.net.nsd.NsdManager}
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static NsdManager getNsdManager(Context context) {
        return (NsdManager) context.getSystemService(Context.NSD_SERVICE);
    }

    /**
     * Get the {@link android.app.SearchManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.SearchManager}
     */
    public static SearchManager getSearchManager(Context context) {
        return (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
    }

    /**
     * Get the {@link android.hardware.SensorManager} service for this context.
     * @param context the context.
     * @return the {@link android.hardware.SensorManager}
     */
    public static SensorManager getSensorManager(Context context) {
        return (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    /**
     * Get the {@link android.os.storage.StorageManager} service for this context.
     * @param context the context.
     * @return the {@link android.os.storage.StorageManager}
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public static StorageManager getStorageManager(Context context) {
        return (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
    }

    /**
     * Get the {@link android.telephony.TelephonyManager} service for this context.
     * @param context the context.
     * @return the {@link android.telephony.TelephonyManager}
     */
    public static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    /**
     * Get the {@link android.view.textservice.TextServicesManager} service for this context.
     * @param context the context.
     * @return the {@link android.view.textservice.TextServicesManager}
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static TextServicesManager getTextServicesManager(Context context) {
        return (TextServicesManager) context.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
    }

    /**
     * Get the {@link android.app.UiModeManager} service for this context.
     * @param context the context.
     * @return the {@link android.app.UiModeManager}
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static UiModeManager getUiModeManager(Context context) {
        return (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
    }

    /**
     * Get the {@link android.hardware.usb.UsbManager} service for this context.
     * @param context the context.
     * @return the {@link android.hardware.usb.UsbManager}
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public static UsbManager getUsbManager(Context context) {
        return (UsbManager) context.getSystemService(Context.USB_SERVICE);
    }

    /**
     * Get the {@link android.os.UserManager} service for this context.
     * @param context the context.
     * @return the {@link android.os.UserManager}
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static UserManager getUserManager(Context context) {
        return (UserManager) context.getSystemService(Context.USER_SERVICE);
    }

    /**
     * Get the {@link android.os.Vibrator} service for this context.
     * @param context the context.
     * @return the {@link android.os.Vibrator}
     */
    public static Vibrator getVibrator(Context context) {
        return (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    /**
     * Get the {@link android.service.wallpaper.WallpaperService} service for this context.
     * @param context the context.
     * @return the {@link android.service.wallpaper.WallpaperService}
     */
    public static WallpaperService getWallpaperManager(Context context) {
        return (WallpaperService) context.getSystemService(Context.WALLPAPER_SERVICE);
    }

    /**
     * Get the {@link android.net.wifi.p2p.WifiP2pManager} service for this context.
     * @param context the context.
     * @return the {@link android.net.wifi.p2p.WifiP2pManager}
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static WifiP2pManager getWifiP2pManager(Context context) {
        return (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
    }

    /**
     * Get the {@link android.net.wifi.WifiManager} service for this context.
     * @param context the context.
     * @return the {@link android.net.wifi.WifiManager}
     */
    public static WifiManager getWifiManager(Context context) {
        return (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }
}