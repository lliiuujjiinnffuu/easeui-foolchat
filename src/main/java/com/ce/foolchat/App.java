package com.ce.foolchat;

import android.app.Application;

import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;

/**
 * @author CE Chen
 * <p>
 * 作用 :
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initEaseUi();
    }

    private void initEaseUi() {
        EMOptions emOptions = new EMOptions();
        emOptions.setAcceptInvitationAlways(false);
        EaseUI.getInstance().init(this, new EMOptions());
    }
}
