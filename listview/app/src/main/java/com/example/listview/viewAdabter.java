package com.example.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.R;
import com.example.listview.viewClass;

import java.util.ArrayList;

public class viewAdabter extends ArrayAdapter<viewClass> {

    public viewAdabter(Activity context, ArrayList<viewClass> vClass) {

        super(context, 0, vClass);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.player_layout, parent, false);
        }

        final viewClass getPlayer = getItem(position);

        EditText editPlayer =(EditText) listItemView.findViewById(R.id.editText_homePlayer);

        editPlayer.setHint((getPlayer.getmPlayer()));

        Button point = (Button) listItemView.findViewById(R.id.button_Point);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "point is equal: " + getPlayer.getmPoint(), Toast.LENGTH_SHORT).show();
            }
        });

        Button assist = (Button) listItemView.findViewById(R.id.button_Assist);
        assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Assist is equal: " + getPlayer.getmAssist(), Toast.LENGTH_SHORT).show();
            }
        });

        Button rebound = (Button) listItemView.findViewById(R.id.button_Rebound);
        rebound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Rebound is equal: " + getPlayer.getmRebound(), Toast.LENGTH_SHORT).show();
            }
        });

        Button steal = (Button) listItemView.findViewById(R.id.button_Steal);
        steal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Steal is equal: " + getPlayer.getmSteal(), Toast.LENGTH_SHORT).show();
            }
        });

        Button block = (Button) listItemView.findViewById(R.id.button_Block);
        block.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Block is equal: " + getPlayer.getmBlock(), Toast.LENGTH_SHORT).show();
            }
        });

        Button turnover = (Button) listItemView.findViewById(R.id.button_TurnOver);
        turnover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "turn Over is equal: " + getPlayer.getmTurnOver(), Toast.LENGTH_SHORT).show();
            }
        });

        return listItemView;
    }
}
