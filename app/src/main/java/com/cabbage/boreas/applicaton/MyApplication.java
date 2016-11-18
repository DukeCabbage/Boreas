package com.cabbage.boreas.applicaton;

import android.app.Application;

import timber.log.Timber;

public class MyApplication extends Application {

    static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule())
                    .build();
        }
        return appComponent;
    }

//    public static synchronized MyApplication getInstance(Context context) {
//        return (MyApplication) context.getApplicationContext();
//    }

    @Override
    public void onCreate() {
//        Stetho.initializeWithDefaults(this);
        Timber.plant(new Timber.DebugTree() {
            //add line number to the tag
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ':' + element.getLineNumber();
            }
        });
    }
}
