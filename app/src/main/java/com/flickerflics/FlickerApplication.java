package com.flickerflics;

import android.app.Application;

import com.flickerflics.common.utils.AppConfigBuilder;
import com.flickerflics.common.utils.Logger;
import com.flickerflics.common.utils.Utils;

/**
 * @Author rahulravindran
 */
public class FlickerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.Companion.init();

        Utils.Companion.setApplication(this);
        Utils.Companion.setDebug(BuildConfig.DEBUG);

        new AppConfigBuilder.Builder()
                .setApplicationEnv(BuildConfig.BUILD_TYPE)
                .setApplicationUrl(BuildConfig.APPLICATION_ENPOINT)
                .setApplicationID(BuildConfig.APPLICATION_ID)
                .setAppCode(BuildConfig.VERSION_CODE)
                .setScheme(BuildConfig.SCHEME)
                .setApiKey(BuildConfig.API_KEY)
                .setAppVersion(BuildConfig.VERSION_NAME)
                .build();

    }

}
