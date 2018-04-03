package me.listenzz.componentization;

import android.util.Log;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.listenzz.commonui.BaseFragment;

@Singleton
public class UIComponentRegistry {

    @Inject
    public UIComponentRegistry() {
        Log.w("Dagger", "UIComponentRegistry");
    }

    private HashMap<String, Class<? extends BaseFragment>> uiModules = new HashMap<>();

    public void registerModule(String moduleName, Class<? extends BaseFragment> clazz) {
        uiModules.put(moduleName, clazz);
    }

    public boolean hasModule(String moduleName) {
        return uiModules.containsKey(moduleName);
    }

    public Class<? extends BaseFragment> moduleClassForName(String moduleName) {
        return uiModules.get(moduleName);
    }

}
