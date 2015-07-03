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

import com.amalgam.lang.StringUtils;
import com.amalgam.security.MessageDigestUtils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;

/**
 * Utility for checking application package signature.
 */
@SuppressWarnings("unused") // public APIs
public final class SignatureUtils {
    public static final String TAG = SignatureUtils.class.getSimpleName();

    private SignatureUtils() {
        throw new AssertionError();
    }

    /**
     * Ensure the running application and the target package has the same signature.
     * @param context the running application context.
     * @param targetPackageName the target package name.
     * @return true if the same signature.
     */
    public static boolean ensureSameSignature(Context context, String targetPackageName) {
        return ensureSameSignature(context, targetPackageName, getSignatureHexCode(context));
    }

    /**
     * Ensure the running application and the target package has the same signature.
     * @param context the running application context.
     * @param targetPackageName the target package name.
     * @param expectedHash signature hash that the target package is expected to have signed.
     * @return true if the same signature.
     */
    public static boolean ensureSameSignature(Context context, String targetPackageName, String expectedHash) {
        if (targetPackageName == null || expectedHash == null) {
            // cannot proceed anymore.
            return false;
        }
        String hash = expectedHash.replace(" ", "");
        return hash.equals(getSignatureHexCode(context, targetPackageName));
    }

    /**
     * Obtains the signature hex code.
     * @param context the context.
     * @return the hex code of the signature.
     */
    public static String getSignatureHexCode(Context context) {
        return getSignatureHexCode(context, context.getPackageName());
    }

    /**
     * Obtains the signature hex code.
     * @param context the context.
     * @param targetPackageName the target package name.
     * @return the hex code of the signature.
     */
    public static String getSignatureHexCode(Context context, String targetPackageName) {
        if (TextUtils.isEmpty(targetPackageName)) {
            return null;
        }
        try {
            PackageInfo info = PackageManagerUtils.getSignaturePackageInfo(context, targetPackageName);
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