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
package com.amalgam.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 */
@SuppressWarnings("unused") // public APIs
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