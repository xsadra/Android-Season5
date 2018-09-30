package at.sadra.apps.season5.episodes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.app.App;

public class E06AndroidBasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_android_basic);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Tap to Go...", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                App.toast("Tap");
                            }
                        }).setActionTextColor(getResources().getColor(R.color.white))
                        .show();
            }
        });
    }
}
