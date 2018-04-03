package me.listenzz.common_api;

public interface AccountManager {

    Account login(String username, String password);

    void invalidate();

}
