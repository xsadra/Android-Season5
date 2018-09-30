package at.sadra.apps.season5.episodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.app.App;

public class E07AndroidActionbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e07_android_actionbar);
        setTitle(getString(R.string.E07AndroidActionbarActivity));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.e07_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuStatus:
                showToast("Status");
                break;
            case R.id.menuSettings:
                showToast("Settings");
                break;
            case R.id.menuAbout:
                showToast("About");
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    private void showToast(String menuName) {
        App.toast(menuName + App.Main.SPACE + getString(R.string.clicked));
    }
}
