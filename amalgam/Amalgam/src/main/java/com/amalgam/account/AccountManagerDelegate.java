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

public class AccountManagerDelegate {
    private final AccountManager mAccount;

    public AccountManagerDelegate(Context context) {
        mAccount = AccountManager.get(context);
    }

    public AccountManagerFuture<Bundle> addAccount(String accountType, String authTokenType,
                                                   String[] requiredFeatures, Bundle addAccountOptions, Activity activity,
                                                   AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.addAccount(accountType, authTokenType, requiredFeatures, addAccountOptions,
                activity, callback, handler);
    }

    public boolean addAccountExplicitly(Account account, String password, Bundle userdata) {
        return mAccount.addAccountExplicitly(account, password, userdata);
    }

    public void addOnAccountsUpdatedListener(OnAccountsUpdateListener listener, Handler handler,
                                             boolean updateImmediately) {
        mAccount.addOnAccountsUpdatedListener(listener, handler, updateImmediately);
    }

    public String blockingGetAuthToken(Account account, String authTokenType,
                                       boolean notifyAuthFailure) throws OperationCanceledException, IOException,
            AuthenticatorException {
        return mAccount.blockingGetAuthToken(account, authTokenType, notifyAuthFailure);
    }

    public void clearPassword(Account account) {
        mAccount.clearPassword(account);
    }

    public AccountManagerFuture<Bundle> confirmCredentials(Account account, Bundle options,
                                                           Activity activity, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.confirmCredentials(account, options, activity, callback, handler);
    }

    public AccountManagerFuture<Bundle> editProperties(String accountType, Activity activity,
                                                       AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.editProperties(accountType, activity, callback, handler);
    }

    public boolean equals(Object o) {
        return mAccount.equals(o);
    }

    public Account[] getAccounts() {
        return mAccount.getAccounts();
    }

    public Account[] getAccountsByType(String type) {
        return mAccount.getAccountsByType(type);
    }

    public AccountManagerFuture<Account[]> getAccountsByTypeAndFeatures(String type,
                                                                        String[] features, AccountManagerCallback<Account[]> callback, Handler handler) {
        return mAccount.getAccountsByTypeAndFeatures(type, features, callback, handler);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public Account[] getAccountsByTypeForPackage(String type, String packageName) {
        return mAccount.getAccountsByTypeForPackage(type, packageName);
    }

    @SuppressWarnings("deprecation")
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType,
                                                     boolean notifyAuthFailure, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.getAuthToken(account, authTokenType, notifyAuthFailure, callback, handler);
    }

    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType,
                                                     Bundle options, Activity activity, AccountManagerCallback<Bundle> callback,
                                                     Handler handler) {
        return mAccount.getAuthToken(account, authTokenType, options, activity, callback, handler);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public AccountManagerFuture<Bundle> getAuthToken(Account account, String authTokenType,
                                                     Bundle options, boolean notifyAuthFailure, AccountManagerCallback<Bundle> callback,
                                                     Handler handler) {
        return mAccount.getAuthToken(account, authTokenType, options, notifyAuthFailure, callback,
                handler);
    }

    public AccountManagerFuture<Bundle> getAuthTokenByFeatures(String accountType,
                                                               String authTokenType, String[] features, Activity activity, Bundle addAccountOptions,
                                                               Bundle getAuthTokenOptions, AccountManagerCallback<Bundle> callback, Handler handler) {
        return mAccount.getAuthTokenByFeatures(accountType, authTokenType, features, activity,
                addAccountOptions, getAuthTokenOptions, callback, handler);
    }

    public AuthenticatorDescription[] getAuthenticatorTypes() {
        return mAccount.getAuthenticatorTypes();
    }

    public String getPassword(Account account) {
        return mAccount.getPassword(account);
    }

    public String getUserData(Account account, String key) {
        return mAccount.getUserData(account, key);
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    public AccountManagerFuture<Boolean> hasFeatures(Account account, String[] features,
                                                     AccountManagerCallback<Boolean> callback, Handler handler) {
        return mAccount.hasFeatures(account, features, callback, handler);
    }

    public int hashCode() {
        return mAccount.hashCode();
    }

    public void invalidateAuthToken(String accountType, String authToken) {
        mAccount.invalidateAuthToken(accountType, authToken);
    }

    public String peekAuthToken(Account account, String authTokenType) {
        return mAccount.peekAuthToken(account, authTokenType);
    }

    public AccountManagerFuture<Boolean> removeAccount(Account account,
                                                       AccountManagerCallback<Boolean> callback, Handler handler) {
        return mAccount.removeAccount(account, callback, handler);
    }

    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener listener) {
        mAccount.removeOnAccountsUpdatedListener(listener);
    }

    public void setAuthToken(Account account, String authTokenType, String authToken) {
        mAccount.setAuthToken(account, authTokenType, authToken);
    }

    public void setPassword(Account account, String password) {
        mAccount.setPassword(account, password);
    }

    public void setUserData(Account account, String key, String value) {
        mAccount.setUserData(account, key, value);
    }

    public String toString() {
        return mAccount.toString();
    }

    public AccountManagerFuture<Bundle> updateCredentials(Account account, String authTokenType,
                                                          Bundle options, Activity activity, AccountManagerCallback<Bundle> callback,
                                                          Handler handler) {
        return mAccount.updateCredentials(account, authTokenType, options, activity, callback, handler);
    }
}