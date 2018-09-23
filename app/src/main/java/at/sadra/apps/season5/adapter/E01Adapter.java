package at.sadra.apps.season5.adapter;

import android.content.Context;
import android.graphics.Color;
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
import at.sadra.apps.season5.objects.E01Object;

public class E01Adapter extends ArrayAdapter<E01Object> {

    List<E01Object> list;
    ImageView image;
    TextView name;

    private final int MODE_GET_VIEW = 0;
    private final int MODE_GET_DROP_DOWN_VIEW = 1;

    public E01Adapter(@NonNull Context context, int resource, @NonNull List<E01Object> objects) {
        super(context, resource, objects);
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = getView(position, parent, MODE_GET_VIEW);

        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = getView(position, parent, MODE_GET_DROP_DOWN_VIEW);

        return view;
    }

    @NonNull
    private View getView(int position, @NonNull ViewGroup parent, int mode) {
        LayoutInflater inflater = ((LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View view = inflater.inflate(R.layout.layout_01_spinner_row, parent,false);

        image = view.findViewById(R.id.image);
        name = view.findViewById(R.id.name);

        name.setText(list.get(position).getName());
        image.setImageResource(list.get(position).getDrawable());

        if (mode == MODE_GET_DROP_DOWN_VIEW){
            name.setTextColor(Color.BLACK);
        }


        return view;
    }
}
