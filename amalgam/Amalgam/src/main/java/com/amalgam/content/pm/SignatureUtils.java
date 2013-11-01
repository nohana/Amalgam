package com.amalgam.content.pm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;

import com.amalgam.lang.StringUtils;
import com.amalgam.security.MessageDigestUtils;

/**
 */
public final class SignatureUtils {
    public static final String TAG = SignatureUtils.class.getSimpleName();

    private SignatureUtils() {}

    public static final boolean ensureSameSignature(Context context, String targetPackageName) {
        return ensureSameSignature(context, targetPackageName, getSignatureHexCode(context));
    }

    public static final boolean ensureSameSignature(Context context, String targetPackageName, String expectedHash) {
        if (targetPackageName == null || expectedHash == null) {
            // cannot proceed anymore.
            return false;
        }
        String hash = expectedHash.replace(" ", "");
        return hash.equals(getSignatureHexCode(context, targetPackageName));
    }

    public static final String getSignatureHexCode(Context context) {
        return getSignatureHexCode(context, context.getPackageName());
    }

    public static final String getSignatureHexCode(Context context, String targetPackageName) {
        if (TextUtils.isEmpty(targetPackageName)) {
            return null;
        }
        try {
            PackageInfo info = PackageManagerUtils.getSignaturePackageInfo(context.getPackageManager(), targetPackageName);
            if (info.signatures.length != 1) {
                // multiple signature would not treated
                return null;
            }
            Signature sig = info.signatures[0];
            byte[] sha256 = MessageDigestUtils.computeSha256(sig.toByteArray());
            return StringUtils.byteToHex(sha256);
        } catch (NameNotFoundException e) {
            Log.e(TAG, "target package not found: ", e);
            return null;
        }
    }
}