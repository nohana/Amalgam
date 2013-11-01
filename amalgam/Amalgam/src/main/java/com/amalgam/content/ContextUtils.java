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
import android.app.WallpaperManager;
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
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;

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

    public static final AlarmManager getAlarmManager(Context context) {
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    public static final NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static final ActivityManager  getActivityManager(Context context) {
        return (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    public static final PowerManager getPowerManager(Context context) {
        return (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    }

    public static final InputMethodManager getInputMethodManager(Context context) {
        return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public static final InputManager getInputManager(Context context) {
        return (InputManager) context.getSystemService(Context.INPUT_SERVICE);
    }

    public static final ConnectivityManager getConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static final LayoutInflater getLayoutInflater(Context context) {
        return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static final WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    public static final AccountManager getAccountManager(Context context) {
        return (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
    }

    public static final NfcManager getNfcManager(Context context) {
        return (NfcManager) context.getSystemService(Context.NFC_SERVICE);
    }

    public static final AccessibilityManager getAccessibilityManager(Context context) {
        return (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
    }

    public static final AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public static final BluetoothAdapter getBluetoothAdapter(Context context) {
        return (BluetoothAdapter) context.getSystemService(Context.BLUETOOTH_SERVICE);
    }

    public static final ClipboardManager getClipboardManager(Context context) {
        return (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public static final DevicePolicyManager getDevicePolicyManager(Context context) {
        return (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
    }

    public static final DisplayManager getDisplayManager(Context context) {
        return (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
    }

    public static final DownloadManager getDownloadManager(Context context) {
        return (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
    }

    public static final DropBoxManager getDropBoxManager(Context context) {
        return (DropBoxManager) context.getSystemService(Context.DROPBOX_SERVICE);
    }

    public static final KeyguardManager getKeyguardManager(Context context) {
        return (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
    }

    public static final LocationManager getLocationManager(Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public static final MediaRouter getMediaRouter(Context context) {
        return (MediaRouter) context.getSystemService(Context.MEDIA_ROUTER_SERVICE);
    }

    public static final NsdManager getNsdManager(Context context) {
        return (NsdManager) context.getSystemService(Context.NSD_SERVICE);
    }

    public static final SearchManager getSearchManager(Context context) {
        return (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
    }

    public static final SensorManager getSensorManager(Context context) {
        return (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    public static final StorageManager getStorageManager(Context context) {
        return (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
    }

    public static final TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public static final TextServicesManager getTextServicesManager(Context context) {
        return (TextServicesManager) context.getSystemService(Context.TEXT_SERVICES_MANAGER_SERVICE);
    }

    public static final UiModeManager getUiModeManager(Context context) {
        return (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
    }

    public static final UsbManager getUsbManager(Context context) {
        return (UsbManager) context.getSystemService(Context.USB_SERVICE);
    }

    public static final UserManager getUserManager(Context context) {
        return (UserManager) context.getSystemService(Context.USER_SERVICE);
    }

    public static final Vibrator getVibrator(Context context) {
        return (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public static final WallpaperManager getWallpaperManager(Context context) {
        return (WallpaperManager) context.getSystemService(Context.WALLPAPER_SERVICE);
    }

    public static final WifiP2pManager getWifiP2pManager(Context context) {
        return (WifiP2pManager) context.getSystemService(Context.WIFI_P2P_SERVICE);
    }

    public static final WifiManager getWifiManager(Context context) {
        return (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }
}