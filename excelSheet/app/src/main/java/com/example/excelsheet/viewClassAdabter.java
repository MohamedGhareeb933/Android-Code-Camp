package com.example.excelsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class viewClassAdabter extends ArrayAdapter<viewClass> {

    public viewClassAdabter(Context context, ArrayList<viewClass> view) {
        super(context, 0, view);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.example_layout, parent, false);
        }

        viewClass vClass = getItem(position);

        TextView t1 = listItemView.findViewById(R.id.TextView_First);
        t1.setText("" + vClass.getFirst());

        TextView t2 = listItemView.findViewById(R.id.TextView_Second);
        t2.setText("" + vClass.getSecond());

        TextView t3 = listItemView.findViewById(R.id.TextView_Third);
        t3.setText("" + vClass.getThird());

        TextView t4 = listItemView.findViewById(R.id.TextView_Fourth);
        t4.setText("" + vClass.getFourth());

        TextView t5 = listItemView.findViewById(R.id.TextView_Fifth);
        t5.setText("" + vClass.getFifth());

        return listItemView;
    }
}
