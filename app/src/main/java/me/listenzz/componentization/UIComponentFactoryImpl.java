package me.listenzz.componentization;

import javax.inject.Inject;

import me.listenzz.commonui.BaseFragment;
import me.listenzz.commonui.UIComponentFactory;

public class UIComponentFactoryImpl implements UIComponentFactory {

    private UIComponentRegistry uiComponentRegistry;

    @Inject
    public UIComponentFactoryImpl(UIComponentRegistry uiComponentRegistry) {
        this.uiComponentRegistry = uiComponentRegistry;
    }

    @Override
    public BaseFragment createFragment(String moduleName) {
        Class<? extends BaseFragment> fragmentClass = uiComponentRegistry.moduleClassForName(moduleName);
        if (fragmentClass == null) {
            // DEBUG 环境下崩溃，Release 环境下返回 404 页面
            throw new IllegalArgumentException("未能找到名为 " + moduleName + " 的模块，你是否忘了注册？");
        }
        BaseFragment fragment = null;
        try {
            fragment = fragmentClass.newInstance();
        } catch (Exception e) {
            // ignore
        }

        return fragment;
    }

}
