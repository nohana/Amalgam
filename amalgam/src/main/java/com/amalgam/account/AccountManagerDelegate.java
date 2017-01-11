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
package com.amalgam.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorDescription;
import android.accounts.AuthenticatorException;
import android.accounts.OnAccountsUpdateListener;
import android.accounts.OperationCanceledException;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import java.io.IOException;

/**
 * The AccountManagerDelegate wraps all behaviours of {@link android.accounts.AccountManager}.
 * This is useful for the test purposes.
 */
public class AccountManagerDelegate {
    private final AccountManager mAccount;

    /**
     * @see android.accounts.AccountManager#get(android.content.Context).
     */
    public AccountManagerDelegate(Context context) {
        mAccount = AccountManager.get(context);
    }

    /**
     * @see android.accounts.AccountManager#addAccount(String, String, String[], android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    public AccountManagerFuture<Bundle> addAccount(String accountType, String authTokenType, String[] requiredFeatures, Bundle addAccountOptions, Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.addAccount(accountType, authTokenType, requiredFeatures, addAccountOptions, activity, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#addAccountExplicitly(android.accounts.Account, String, android.os.Bundle).
     */
    @SuppressWarnings("MissingPermission")
    public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        return mAccount.addAccountExplicitly(account, password, userdata);
    }

    /**
     * @see android.accounts.AccountManager#addOnAccountsUpdatedListener(android.accounts.OnAccountsUpdateListener, android.os.Handler, boolean).
     */
    @SuppressWarnings("MissingPermission")
    public void addOnAccountsUpdatedListener(OnAccountsUpdateListener listener, Handler handler, boolean updateImmediately) {
        mAccount.addOnAccountsUpdatedListener(listener, handler, updateImmediately);
    }

    /**
     * @see android.accounts.AccountManager#blockingGetAuthToken(android.accounts.Account, String, boolean).
     */
    @SuppressWarnings("MissingPermission")
    public String blockingGetAuthToken(Account account, String authTokenType, boolean notifyAuthFailure) throws OperationCanceledException, IOException, AuthenticatorException {
        return mAccount.blockingGetAuthToken(account, authTokenType, notifyAuthFailure);
    }

    /**
     * @see android.accounts.AccountManager#clearPassword(android.accounts.Account).
     */
    @SuppressWarnings("MissingPermission")
    public void clearPassword(Account account) {
        mAccount.clearPassword(account);
    }

    /**
     * @see android.accounts.AccountManager#confirmCredentials(android.accounts.Account, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    public AccountManagerFuture<Bundle> confirmCredentials(Account account, Bundle options, Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.confirmCredentials(account, options, activity, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#editProperties(String, android.app.Activity, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    public AccountManagerFuture<Bundle> editProperties(String accountType, Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.editProperties(accountType, activity, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#equals(Object).
     */
    public boolean equals(Object o) {
        return mAccount.equals(o);
    }

    /**
     * @see android.accounts.AccountManager#getAccounts().
     */
    @SuppressWarnings("MissingPermission")
    public Account[] getAccounts() {
        return mAccount.getAccounts();
    }

    /**
     * @see android.accounts.AccountManager#getAccountsByType(String).
     */
    @SuppressWarnings("MissingPermission")
    public Account[] getAccountsByType(String type) {
        return mAccount.getAccountsByType(type);
    }

    /**
     * @see android.accounts.AccountManager#getAccountsByTypeAndFeatures(String, String[], android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(String type, String[] features, AccountManagerCallback<Account[]> callback, Handler handler) {
        return mAccount.getAccountsByTypeAndFeatures(type, features, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#getAccountsByTypeForPackage(String, String).
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public Account[] getAccountsByTypeForPackage(String type, String packageName) {
        return mAccount.getAccountsByTypeForPackage(type, packageName);
    }

    /**
     * @see android.accounts.AccountManager#getAuthToken(android.accounts.Account, String, boolean, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings({"deprecation", "MissingPermission"})
    @Deprecated
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType, boolean notifyAuthFailure, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.getAuthToken(account, authTokenType, notifyAuthFailure, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#getAuthToken(android.accounts.Account, String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")

    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType, Bundle options, Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.getAuthToken(account, authTokenType, options, activity, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#getAuthToken(android.accounts.Account, String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType, Bundle options, boolean notifyAuthFailure, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.getAuthToken(account, authTokenType, options, notifyAuthFailure, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#getAuthTokenByFeatures(String, String, String[], android.app.Activity, android.os.Bundle, android.os.Bundle, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    public AccountManagerFuture<Bundle> getAuthTokenByFeatures(String accountType, String authTokenType, String[] features, Activity activity, Bundle addAccountOptions, Bundle getAuthTokenOptions, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.getAuthTokenByFeatures(accountType, authTokenType, features, activity, addAccountOptions, getAuthTokenOptions, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#getAuthenticatorTypes().
     */
    public AuthenticatorDescription[] getAuthenticatorTypes() {
        return mAccount.getAuthenticatorTypes();
    }

    /**
     * @see android.accounts.AccountManager#getPassword(android.accounts.Account).
     */
    @SuppressWarnings("MissingPermission")
    public String getPassword(Account account) {
        return mAccount.getPassword(account);
    }

    /**
     * @see android.accounts.AccountManager#getUserData(android.accounts.Account, String).
     */
    @SuppressWarnings("MissingPermission")
    public String getUserData(Account account, String key) {
        return mAccount.getUserData(account, key);
    }

    /**
     * @see android.accounts.AccountManager#hasFeatures(android.accounts.Account, String[], android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    @TargetApi(Build.VERSION_CODES.FROYO)
    public AccountManagerFuture<Boolean> hasFeatures(Account account, String[] features, AccountManagerCallback<Boolean> callback, Handler handler) {
        return mAccount.hasFeatures(account, features, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#hashCode().
     */
    public int hashCode() {
        return mAccount.hashCode();
    }

    /**
     * @see android.accounts.AccountManager#invalidateAuthToken(String, String).
     */
    @SuppressWarnings("MissingPermission")
    public void invalidateAuthToken(String accountType, String authToken) {
        mAccount.invalidateAuthToken(accountType, authToken);
    }

    /**
     * @see android.accounts.AccountManager#peekAuthToken(android.accounts.Account, String).
     */
    @SuppressWarnings("MissingPermission")
    public String peekAuthToken(Account account, String authTokenType) {
        return mAccount.peekAuthToken(account, authTokenType);
    }

    /**
     * @see android.accounts.AccountManager#removeAccount(android.accounts.Account, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    public AccountManagerFuture<Boolean> removeAccount(Account account, AccountManagerCallback<Boolean> callback, Handler handler) {
        return mAccount.removeAccount(account, callback, handler);
    }

    /**
     * @see android.accounts.AccountManager#removeOnAccountsUpdatedListener(android.accounts.OnAccountsUpdateListener).
     */
    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        mAccount.removeOnAccountsUpdatedListener(listener);
    }

    /**
     * @see android.accounts.AccountManager#setAuthToken(android.accounts.Account, String, String).
     */
    @SuppressWarnings("MissingPermission")
    public void setAuthToken(Account account, String authTokenType, String authToken) {
        mAccount.setAuthToken(account, authTokenType, authToken);
    }

    /**
     * @see android.accounts.AccountManager#setPassword(android.accounts.Account, String).
     */
    @SuppressWarnings("MissingPermission")
    public void setPassword(Account account, String password) {
        mAccount.setPassword(account, password);
    }

    /**
     * @see android.accounts.AccountManager#setUserData(android.accounts.Account, String, String).
     */
    @SuppressWarnings("MissingPermission")
    public void setUserData(Account account, String key, String value) {
        mAccount.setUserData(account, key, value);
    }

    /**
     * @see android.accounts.AccountManager#toString().
     */
    public String toString() {
        return mAccount.toString();
    }

    /**
     * @see android.accounts.AccountManager#updateCredentials(android.accounts.Account, String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback, android.os.Handler).
     */
    @SuppressWarnings("MissingPermission")
    public AccountManagerFuture<Bundle> updateCredentials(Account account, String authTokenType, Bundle options, Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.updateCredentials(account, authTokenType, options, activity, callback, handler);
    }
}