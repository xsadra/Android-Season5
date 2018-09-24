package at.sadra.apps.season5.episodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.adapter.E02Adapter;
import at.sadra.apps.season5.app.App;
import at.sadra.apps.season5.objects.E02Object;

public class E02AndroidCustomListView extends AppCompatActivity implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener,
        View.OnClickListener {

    ListView filmList;
    List<E02Object> list;
    E02Adapter adapter;
    E02Object tmpObject;
    int tmpObjectPosition;
    Button undo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e02_android_custom_list_view);
        setTitle(getString(R.string.E02AndroidCustomListView));

        init();
    }

    private void init() {
        filmList = findViewById(R.id.filmList);
        list = prepareData();
        adapter = new E02Adapter(this, 0, list);
        filmList.setAdapter(adapter);

        undo = findViewById(R.id.undo);

        filmList.setOnItemClickListener(this);
        filmList.setOnItemLongClickListener(this);
        undo.setOnClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        App.toast(list.get(position).getTitle());
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

//        App.toast(list.get(position).getTitle() + " removed !");

        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        view.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tmpObject = list.get(position);
                tmpObjectPosition = position;
                list.remove(position);
                adapter.notifyDataSetChanged();
                undo.setVisibility(View.VISIBLE);

                undo.setAnimation(AnimationUtils.loadAnimation(E02AndroidCustomListView.this, android.R.anim.slide_in_left));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        return true;
    }

    @Override
    public void onClick(View v) {
        list.add(tmpObjectPosition, tmpObject);
        adapter.notifyDataSetChanged();


        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        undo.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                undo.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
