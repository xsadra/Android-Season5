package at.sadra.apps.season5.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import at.sadra.apps.season5.R;
import at.sadra.apps.season5.app.Application;
import at.sadra.apps.season5.objects.E02Object;

public class E02Adapter extends ArrayAdapter<E02Object> {

    List<E02Object> objects;

    public E02Adapter(@NonNull Context context, int resource, @NonNull List<E02Object> objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = ((LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));

        View view = inflater.inflate(R.layout.layout_02_list_row, parent, false);

        TextView filmTitle = view.findViewById(R.id.filmTitle);
        TextView filmDescription = view.findViewById(R.id.filmDescription);
        ImageView filmImage = view.findViewById(R.id.filmImage);

        filmTitle.setText(objects.get(position).getTitle());
        filmDescription.setText(objects.get(position).getDescription());
        filmImage.setImageResource(objects.get(position).getImageRecId());

        return view;

    }
}
