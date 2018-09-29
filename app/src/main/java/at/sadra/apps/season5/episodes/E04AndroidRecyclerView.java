package at.sadra.apps.season5.episodes;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.adapter.E04Adapter;
import at.sadra.apps.season5.app.App;
import at.sadra.apps.season5.interfaces.E04ClickListener;
import at.sadra.apps.season5.objects.E04Music;

public class E04AndroidRecyclerView extends AppCompatActivity implements View.OnClickListener, E04ClickListener {

    RecyclerView musicsRecyclerView;
    List<E04Music> musics;
    E04Adapter musicsAdapter;
    FloatingActionButton changeLayoutFab;

    int layoutManager = App.Main.LAYOUT_MANAGER_LINEAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e04_android_recycler_view);
        setTitle(getString(R.string.E04AndroidRecyclerView));

        init();
    }

    private void init() {
        musicsRecyclerView = findViewById(R.id.musicRecyclerView);
        changeLayoutFab = findViewById(R.id.changeLayoutFab);

        changeLayoutFab.setOnClickListener(this);
        setLayoutManager();

        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        LayoutAnimationController animationController = new LayoutAnimationController(animation);

        musicsRecyclerView.setLayoutAnimation(animationController);

        musics = prepareData();
        musicsAdapter = new E04Adapter(musics, this);
        musicsRecyclerView.setAdapter(musicsAdapter);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.changeLayoutFab) {
            if (layoutManager == App.Main.LAYOUT_MANAGER_LINEAR) {
                layoutManager = App.Main.LAYOUT_MANAGER_GRID;
                changeLayoutFab.setImageResource(R.drawable.ic_view_agenda_black_24dp);
                setLayoutManager();
            } else {
                layoutManager = App.Main.LAYOUT_MANAGER_LINEAR;
                changeLayoutFab.setImageResource(R.drawable.ic_grid_on_black_24dp);
                setLayoutManager();
            }
            App.toast(((Integer) layoutManager).toString());
        }
    }

    private void setLayoutManager() {
        if (layoutManager == App.Main.LAYOUT_MANAGER_LINEAR) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            musicsRecyclerView.setLayoutManager(linearLayoutManager);
        } else if (layoutManager == App.Main.LAYOUT_MANAGER_GRID) {
//            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,GridLayoutManager.HORIZONTAL,false);
            musicsRecyclerView.setLayoutManager(gridLayoutManager);
        }

    }

    private List<E04Music> prepareData() {

        List<E04Music> musics = new ArrayList<>();

        E04Music music = new E04Music();
        music.setSingerName(getString(R.string.mLeonName));
        music.setSongName(getString(R.string.mLeonSong));
        music.setView(Integer.parseInt(getString(R.string.mLeonView)));
        music.setLike(Integer.parseInt(getString(R.string.mLeonLike)));
        music.setComment(Integer.parseInt(getString(R.string.mLeonComment)));
        music.setDate(getString(R.string.mLeonDate));
        music.setPicId(R.drawable.m01);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mRitaOraName));
        music.setSongName(getString(R.string.mRitaOraSong));
        music.setView(Integer.parseInt(getString(R.string.mRitaOraView)));
        music.setLike(Integer.parseInt(getString(R.string.mRitaOraLike)));
        music.setComment(Integer.parseInt(getString(R.string.mRitaOraComment)));
        music.setDate(getString(R.string.mRitaOraDate));
        music.setPicId(R.drawable.m02);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mRitaOraName));
        music.setSongName(getString(R.string.mRitaOraSong));
        music.setView(Integer.parseInt(getString(R.string.mRitaOraView)));
        music.setLike(Integer.parseInt(getString(R.string.mRitaOraLike)));
        music.setComment(Integer.parseInt(getString(R.string.mRitaOraComment)));
        music.setDate(getString(R.string.mRitaOraDate));
        music.setPicId(R.drawable.m03);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mRihannaName));
        music.setSongName(getString(R.string.mRihannaSong));
        music.setView(Integer.parseInt(getString(R.string.mRihannaView)));
        music.setLike(Integer.parseInt(getString(R.string.mRihannaLike)));
        music.setComment(Integer.parseInt(getString(R.string.mRihannaComment)));
        music.setDate(getString(R.string.mRihannaDate));
        music.setPicId(R.drawable.m04);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mRihannaName));
        music.setSongName(getString(R.string.mRihannaSong));
        music.setView(Integer.parseInt(getString(R.string.mRihannaView)));
        music.setLike(Integer.parseInt(getString(R.string.mRihannaLike)));
        music.setComment(Integer.parseInt(getString(R.string.mRihannaComment)));
        music.setDate(getString(R.string.mRihannaDate));
        music.setPicId(R.drawable.m05);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mRihannaName));
        music.setSongName(getString(R.string.mRihannaSong));
        music.setView(Integer.parseInt(getString(R.string.mRihannaView)));
        music.setLike(Integer.parseInt(getString(R.string.mRihannaLike)));
        music.setComment(Integer.parseInt(getString(R.string.mRihannaComment)));
        music.setDate(getString(R.string.mRihannaDate));
        music.setPicId(R.drawable.m06);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mMoName));
        music.setSongName(getString(R.string.mMoSong));
        music.setView(Integer.parseInt(getString(R.string.mMoView)));
        music.setLike(Integer.parseInt(getString(R.string.mMoLike)));
        music.setComment(Integer.parseInt(getString(R.string.mMoComment)));
        music.setDate(getString(R.string.mMoDate));
        music.setPicId(R.drawable.m07);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mAllieXName));
        music.setSongName(getString(R.string.mAllieXSong));
        music.setView(Integer.parseInt(getString(R.string.mAllieXView)));
        music.setLike(Integer.parseInt(getString(R.string.mAllieXLike)));
        music.setComment(Integer.parseInt(getString(R.string.mAllieXComment)));
        music.setDate(getString(R.string.mAllieXDate));
        music.setPicId(R.drawable.m08);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mKeshaName));
        music.setSongName(getString(R.string.mKeshaSong));
        music.setView(Integer.parseInt(getString(R.string.mKeshaView)));
        music.setLike(Integer.parseInt(getString(R.string.mKeshaLike)));
        music.setComment(Integer.parseInt(getString(R.string.mKeshaComment)));
        music.setDate(getString(R.string.mKeshaDate));
        music.setPicId(R.drawable.m09);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mAvrilLavigneName));
        music.setSongName(getString(R.string.mAvrilLavigneSong));
        music.setView(Integer.parseInt(getString(R.string.mAvrilLavigneView)));
        music.setLike(Integer.parseInt(getString(R.string.mAvrilLavigneLike)));
        music.setComment(Integer.parseInt(getString(R.string.mAvrilLavigneComment)));
        music.setDate(getString(R.string.mAvrilLavigneDate));
        music.setPicId(R.drawable.m10);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mJojoName));
        music.setSongName(getString(R.string.mJojoSong));
        music.setView(Integer.parseInt(getString(R.string.mJojoView)));
        music.setLike(Integer.parseInt(getString(R.string.mJojoLike)));
        music.setComment(Integer.parseInt(getString(R.string.mJojoComment)));
        music.setDate(getString(R.string.mJojoDate));
        music.setPicId(R.drawable.m11);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mLanaDelReyName));
        music.setSongName(getString(R.string.mLanaDelReySong));
        music.setView(Integer.parseInt(getString(R.string.mLanaDelReyView)));
        music.setLike(Integer.parseInt(getString(R.string.mLanaDelReyLike)));
        music.setComment(Integer.parseInt(getString(R.string.mLanaDelReyComment)));
        music.setDate(getString(R.string.mLanaDelReyDate));
        music.setPicId(R.drawable.m12);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mCharliePuthName));
        music.setSongName(getString(R.string.mCharliePuthSong));
        music.setView(Integer.parseInt(getString(R.string.mCharliePuthView)));
        music.setLike(Integer.parseInt(getString(R.string.mCharliePuthLike)));
        music.setComment(Integer.parseInt(getString(R.string.mCharliePuthComment)));
        music.setDate(getString(R.string.mCharliePuthDate));
        music.setPicId(R.drawable.m13);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mChrisBrownName));
        music.setSongName(getString(R.string.mChrisBrownSong));
        music.setView(Integer.parseInt(getString(R.string.mChrisBrownView)));
        music.setLike(Integer.parseInt(getString(R.string.mChrisBrownLike)));
        music.setComment(Integer.parseInt(getString(R.string.mChrisBrownComment)));
        music.setDate(getString(R.string.mChrisBrownDate));
        music.setPicId(R.drawable.m14);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mInnaName));
        music.setSongName(getString(R.string.mInnaSong));
        music.setView(Integer.parseInt(getString(R.string.mInnaView)));
        music.setLike(Integer.parseInt(getString(R.string.mInnaLike)));
        music.setComment(Integer.parseInt(getString(R.string.mInnaComment)));
        music.setDate(getString(R.string.mInnaDate));
        music.setPicId(R.drawable.m15);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mCarlyRaeJepsenName));
        music.setSongName(getString(R.string.mCarlyRaeJepsenSong));
        music.setView(Integer.parseInt(getString(R.string.mCarlyRaeJepsenView)));
        music.setLike(Integer.parseInt(getString(R.string.mCarlyRaeJepsenLike)));
        music.setComment(Integer.parseInt(getString(R.string.mCarlyRaeJepsenComment)));
        music.setDate(getString(R.string.mCarlyRaeJepsenDate));
        music.setPicId(R.drawable.m16);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mChrisBrownName));
        music.setSongName(getString(R.string.mChrisBrownSong));
        music.setView(Integer.parseInt(getString(R.string.mChrisBrownView)));
        music.setLike(Integer.parseInt(getString(R.string.mChrisBrownLike)));
        music.setComment(Integer.parseInt(getString(R.string.mChrisBrownComment)));
        music.setDate(getString(R.string.mChrisBrownDate));
        music.setPicId(R.drawable.m17);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mPiaMiaName));
        music.setSongName(getString(R.string.mPiaMiaSong));
        music.setView(Integer.parseInt(getString(R.string.mPiaMiaView)));
        music.setLike(Integer.parseInt(getString(R.string.mPiaMiaLike)));
        music.setComment(Integer.parseInt(getString(R.string.mPiaMiaComment)));
        music.setDate(getString(R.string.mPiaMiaDate));
        music.setPicId(R.drawable.m18);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mRitaOraName));
        music.setSongName(getString(R.string.mRitaOraSong));
        music.setView(Integer.parseInt(getString(R.string.mRitaOraView)));
        music.setLike(Integer.parseInt(getString(R.string.mRitaOraLike)));
        music.setComment(Integer.parseInt(getString(R.string.mRitaOraComment)));
        music.setDate(getString(R.string.mRitaOraDate));
        music.setPicId(R.drawable.m19);

        musics.add(music);

        music = new E04Music();
        music.setSingerName(getString(R.string.mCharliXcxFtRitaOraName));
        music.setSongName(getString(R.string.mCharliXcxFtRitaOraSong));
        music.setView(Integer.parseInt(getString(R.string.mCharliXcxFtRitaOraView)));
        music.setLike(Integer.parseInt(getString(R.string.mCharliXcxFtRitaOraLike)));
        music.setComment(Integer.parseInt(getString(R.string.mCharliXcxFtRitaOraComment)));
        music.setDate(getString(R.string.mCharliXcxFtRitaOraDate));
        music.setPicId(R.drawable.m20);

        musics.add(music);

        return musics;
    }

    @Override
    public void onClick(E04Music music) {

        Intent intent = new Intent(this, E04AndroidRecyclerViewItemActivity.class);
        intent.putExtra("selectedMusic", music);
        startActivity(intent);
        App.toast(music.getSongName());
    }
}
