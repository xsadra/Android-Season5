package at.sadra.apps.season5.episodes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.objects.E04Music;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class E04AndroidRecyclerViewItemActivity extends AppCompatActivity {

    ImageView image;
    TextView songName, singerName, view, like, comment, date;
    ShimmerLayout shimmerLayout;
    E04Music music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e04_android_recycler_view_item);
        music = (E04Music) getIntent().getSerializableExtra("selectedMusic");
        setTitle(music.getSongName());

        init();

    }

    private void init() {
        image      = findViewById(R.id.musicImage);

        songName   = findViewById(R.id.musicSongName);
        singerName = findViewById(R.id.musicSingerName);
        view       = findViewById(R.id.musicView);
        like       = findViewById(R.id.musicLike);
        comment    = findViewById(R.id.musicComment);
        date       = findViewById(R.id.musicDate);

        shimmerLayout = findViewById(R.id.shimmerText);
        shimmerLayout.startShimmerAnimation();

        songName.setText(music.getSongName());
        singerName.setText(music.getSingerName());
        view.setText(countFormatter(music.getView()));
        like.setText(countFormatter(music.getLike()));
        comment.setText(countFormatter(music.getComment()));
        date.setText(music.getDate());
        image.setImageResource(music.getPicId());
    }

    private String countFormatter(int count) {
        if (count > 999999) {

            Double val = ((double) count)/1000000;
            return String.format("%.2f", val)+ " M";

        } else if (count > 999) {

            double val = ((double) count)/1000;
            return String.format("%.2f", val)+ " K";

        }

        return ((Integer) count).toString();
    }
}
