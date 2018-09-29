package at.sadra.apps.season5.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.app.Application;
import at.sadra.apps.season5.interfaces.E04ClickListener;
import at.sadra.apps.season5.objects.E04Music;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class E04Adapter extends RecyclerView.Adapter<E04Adapter.MusicViewHolder> {

    List<E04Music> musics;
    E04ClickListener clickListener;

    public E04Adapter(List<E04Music> musics, E04ClickListener clickListener) {
        this.musics = musics;
        this.clickListener = clickListener;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_e04_recycler_row, parent, false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {

        E04Music music = musics.get(position);

        holder.songName.setText(music.getSongName());
        holder.singerName.setText(music.getSingerName());
        holder.view.setText(countFormatter(music.getView()));
        holder.like.setText(countFormatter(music.getLike()));
        holder.comment.setText(countFormatter(music.getComment()));
        holder.date.setText(music.getDate());
        holder.image.setImageResource(music.getPicId());
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

    @Override
    public int getItemCount() {
        return musics.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView songName, singerName, view, like, comment, date;
        ShimmerLayout shimmerLayout;
        RelativeLayout parent;

        public MusicViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.musicImage);

            songName = itemView.findViewById(R.id.musicSongName);
            singerName = itemView.findViewById(R.id.musicSingerName);
            view = itemView.findViewById(R.id.musicView);
            like = itemView.findViewById(R.id.musicLike);
            comment = itemView.findViewById(R.id.musicComment);
            date = itemView.findViewById(R.id.musicDate);

            shimmerLayout = itemView.findViewById(R.id.shimmerText);
            shimmerLayout.startShimmerAnimation();

            parent = itemView.findViewById(R.id.parent);
            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onClick(musics.get(getAdapterPosition()));
                }
            });
        }
    }

}
