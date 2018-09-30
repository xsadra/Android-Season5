package at.sadra.apps.season5.app;

import android.util.Log;
import android.widget.Toast;

public class App {

    public static class Main {
        public static final String TAG = "Season5";
        public static final String SPACE = " ";
        public static final int LAYOUT_MANAGER_LINEAR = 1;
        public static final int LAYOUT_MANAGER_GRID = 0;
    }

    public static void log(String message) {
        Log.e(Main.TAG, message);
    }

    public static void toast(String message) {
        Toast
                .makeText(Application.getContext(), message, Toast.LENGTH_LONG)
                .show();
    }
}
