package me.listenzz.businessc;

import android.util.Log;

import javax.inject.Inject;

import me.listenzz.common_api.Account;
import me.listenzz.common_api.AccountManager;
import me.listenzz.common_api.AccountManagerDelegate;


public class AccountManagerImpl implements AccountManager {

    private AccountManagerDelegate delegate;

    @Inject
    public AccountManagerImpl(AccountManagerDelegate delegate) {
        this.delegate = delegate;
        Log.w("Dagger", "AccountManagerImpl");
    }

    @Override
    public Account login(String username, String password) {
        return new Account(username, "password");
    }

    @Override
    public void invalidate() {
        this.delegate.onInvalidation();
    }
}
