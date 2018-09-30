package at.sadra.apps.season5.episodes;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.app.App;

public class E05AndroidTabWidget extends TabActivity {

    //TabWidget tabWidget;
TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e05_android_tab_widget);
        setTitle(getString(R.string.E05AndroidTabWidget));

        init();
    }

    private void init() {
        //tabWidget = findViewById(android.R.id.tabs);
        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spinnerTab = tabHost.newTabSpec("spinner");
        TabHost.TabSpec listTab = tabHost.newTabSpec("list");
        TabHost.TabSpec gridTab = tabHost.newTabSpec("grid");
        TabHost.TabSpec recyclerTab = tabHost.newTabSpec("recycler");

        spinnerTab.setIndicator("Spinner");
        spinnerTab.setContent(new Intent(this, E01AndroidCustomSpinner.class));

        listTab.setIndicator("List");
        listTab.setContent(new Intent(this, E02AndroidCustomListView.class));

        gridTab.setIndicator("Grid");
        gridTab.setContent(new Intent(this, E03AndroidCustomGridView.class));

        Drawable icon = getDrawable(R.drawable.ic_view_agenda_black_24dp);

//        recyclerTab.setIndicator("Recycler",icon);
        recyclerTab.setIndicator("Recycler");
        recyclerTab.setContent(new Intent(this, E04AndroidRecyclerView.class));

        tabHost.addTab(spinnerTab);
        tabHost.addTab(listTab);
        tabHost.addTab(gridTab);
        tabHost.addTab(recyclerTab);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tag) {
                App.toast(tag);
            }
        });

        tabHost.setCurrentTab(3);
//        tabHost.setCurrentTabByTag("recycler");
    }
}
