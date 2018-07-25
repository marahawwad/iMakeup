package com.beyond.imakeup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by marah on 10-Jul-18.
 */

public class CustomGrid extends ArrayAdapter<String> {


    public CustomGrid(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater ln= LayoutInflater.from(getContext());
        View v=ln.inflate(R.layout.home_grid,parent,false);

        ImageView img=v.findViewById(R.id.gimg);
        TextView txt =v.findViewById(R.id.gtxt);

        txt.setText(getItem(position));

        switch (position){

            case 0:
                img.setImageResource(R.drawable.art);
                break;
            case 1:
                img.setImageResource(R.drawable.sal);

                break;
            case 2:
                img.setImageResource(R.drawable.derss);

                break;
            case 3:
                img.setImageResource(R.drawable.adv);

                break;

        }


        return v;
    }
}
