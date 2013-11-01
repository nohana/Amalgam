package com.amalgam.security;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 */
public final class MessageDigestUtils {
    public static final String TAG = MessageDigestUtils.class.getSimpleName();
    public static final String ALGORITHM_SHA_256 = "SHA-256";

    private MessageDigestUtils() {}

    public static final byte[] computeSha256(final byte[] data) {
        try {
            return MessageDigest.getInstance(ALGORITHM_SHA_256).digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("unsupported algorithm for message digest: ", e);
        }
    }
}