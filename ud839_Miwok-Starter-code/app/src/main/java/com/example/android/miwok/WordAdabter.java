package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdabter extends ArrayAdapter<Word> {

    public WordAdabter(Activity context, ArrayList<Word> word) {

        super(context, 0, word);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word getWord = getItem(position);

        TextView MiwokWord =(TextView) listItemView.findViewById(R.id.miwok_TextView);

        MiwokWord.setText((getWord.getMiwok()));

        TextView EnglishWord =(TextView) listItemView.findViewById(R.id.default_TextView);

        EnglishWord.setText(getWord.getDefault());

        ImageView image = (ImageView) listItemView.findViewById(R.id.imageView);

        if(getWord.hasImage()) {
            // set the imageView to image resources specified in getWord
            image.setImageResource(getWord.getImageResourceId());

            //make sure the image is VISIBLE
            image.setVisibility(View.VISIBLE);

        }else {
            //otherwise hide the imageView (set setVisibility to GONE)
            image.setVisibility(View.GONE); }

        return listItemView;
    }
}
