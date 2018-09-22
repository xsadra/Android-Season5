package at.sadra.apps.season5.app;

import android.content.Context;

public class Application extends android.app.Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
