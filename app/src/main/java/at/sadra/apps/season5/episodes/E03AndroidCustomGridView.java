package at.sadra.apps.season5.episodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.adapter.E03Adapter;
import at.sadra.apps.season5.objects.E02Object;

public class E03AndroidCustomGridView extends AppCompatActivity {

    GridView movieGridView;
    List<E02Object> movies;
    E03Adapter adapter;
    CheckBox showName, showDescription, showImage;
    EditText numColumns;

    public static Boolean checkedName;
    public static Boolean checkedDescription;
    public static Boolean checkedImage;

    private final int maxColumns = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e03_android_custom_grid_view);
        setTitle(getString(R.string.E03AndroidCustomGridView));
        init();
    }

    private void init() {
        movieGridView = findViewById(R.id.movieGridView);
        showName = findViewById(R.id.showName);
        showDescription = findViewById(R.id.showDescription);
        showImage = findViewById(R.id.showImage);

        checkedName = checkedDescription = checkedImage = false;

        numColumns = findViewById(R.id.numColumns);

        numColumns.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                try {
                    int columns = Integer.parseInt(text.toString());

                    if (columns > maxColumns){
                        columns = maxColumns;
                        numColumns.setText(columns);
                    }
                        movieGridView.setNumColumns(columns);
                }catch (Exception ex){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        reviewCheckBoxes();

        movies = prepareData();
        adapter = new E03Adapter(this, 0, movies);
        movieGridView.setAdapter(adapter);
    }

    private List<E02Object> prepareData() {
        List<E02Object> list = new ArrayList<>();

        E02Object e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fRace3));
        e02Object.setDescription(getString(R.string.fRace3Des));
        e02Object.setImageRecId(R.drawable.race_3);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fBhaveshJoshiSuperhero));
        e02Object.setDescription(getString(R.string.fBhaveshJoshiSuperhero_des));
        e02Object.setImageRecId(R.drawable.bhavesh_joshi_superhero);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fAdrift));
        e02Object.setDescription(getString(R.string.fAdriftDes));
        e02Object.setImageRecId(R.drawable.adrift);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fSkyscraper));
        e02Object.setDescription(getString(R.string.fSkyscraperDes));
        e02Object.setImageRecId(R.drawable.skyscraper);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fMammaMiaHereWeGoAgain));
        e02Object.setDescription(getString(R.string.fMammaMiaHereWeGoAgainDes));
        e02Object.setImageRecId(R.drawable.mamma_mia_here_we_go_again);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fSahebBiwiAurGangster3));
        e02Object.setDescription(getString(R.string.fSahebBiwiAurGangster3Des));
        e02Object.setImageRecId(R.drawable.saheb_biwi_aur_gangster_3);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fKasal));
        e02Object.setDescription(getString(R.string.fKasalDes));
        e02Object.setImageRecId(R.drawable.kasal);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fPaltan));
        e02Object.setDescription(getString(R.string.fPaltanDes));
        e02Object.setImageRecId(R.drawable.paltan);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fTheDarkestMinds));
        e02Object.setDescription(getString(R.string.fTheDarkestMindsDes));
        e02Object.setImageRecId(R.drawable.the_darkest_minds);
        list.add(e02Object);

        e02Object = new E02Object();
        e02Object.setTitle(getString(R.string.fSlenderMan2018));
        e02Object.setDescription(getString(R.string.fSlenderMan2018Des));
        e02Object.setImageRecId(R.drawable.slender_man);
        list.add(e02Object);


        return list;
    }

    private void reviewCheckBoxes() {
        checkedName = showName.isChecked();
        checkedDescription = showDescription.isChecked();
        checkedImage = showImage.isChecked();
    }

    public void onClick(View checkBox) {
        reviewCheckBoxes();
        adapter.notifyDataSetChanged();
    }
}
