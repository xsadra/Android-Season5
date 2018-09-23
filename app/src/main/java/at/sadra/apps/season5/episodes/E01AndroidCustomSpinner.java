package at.sadra.apps.season5.episodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.adapter.E01Adapter;
import at.sadra.apps.season5.app.App;
import at.sadra.apps.season5.objects.E01Object;

public class E01AndroidCustomSpinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    List<E01Object> list = new ArrayList<>();

    E01Adapter adapter;
    Spinner spinner;
    TextView result;
    ImageView iconResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e01_android_custom_spinner);
        setTitle(getString(R.string.E01AndroidCustomSpinner));

        init();

        spinner.setOnItemSelectedListener(this);
    }

    private void init() {
        spinner = findViewById(R.id.spinner);
        result = findViewById(R.id.result);
        iconResult = findViewById(R.id.iconResult);

        addItemsToList();

        adapter = new E01Adapter(this, android.R.layout.simple_list_item_1, list);

        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String res = getString(R.string.e01Result);
//        res = res.replace("%s", list.get(position).getName());

        result.setText(list.get(position).getName());
        iconResult.setImageResource(list.get(position).getDrawable());

        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        result.startAnimation(animation);
        iconResult.startAnimation(animation);
        iconResult.setOnClickListener(this);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void addItemsToList() {
        list.add(new E01Object(R.drawable.android, getString(R.string.android)));
        list.add(new E01Object(R.drawable.chromium, getString(R.string.chromium)));
        list.add(new E01Object(R.drawable.ios, getString(R.string.ios)));
        list.add(new E01Object(R.drawable.mac, getString(R.string.mac)));
        list.add(new E01Object(R.drawable.ubuntu, getString(R.string.ubuntu)));
        list.add(new E01Object(R.drawable.windows, getString(R.string.windows)));
    }

    @Override
    public void onClick(View v) {
        E01Object currentObject = list.get(spinner.getSelectedItemPosition());
        App.toast(currentObject.getName());
    }
}
