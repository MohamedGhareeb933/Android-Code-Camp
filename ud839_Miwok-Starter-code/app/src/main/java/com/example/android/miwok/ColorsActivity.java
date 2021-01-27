package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word(R.raw.color_red,R.drawable.color_red,"weṭeṭṭi", "red"));
        numbers.add(new Word(R.raw.color_green,R.drawable.color_green,"chokokki", "green"));
        numbers.add(new Word(R.raw.color_brown,R.drawable.color_brown,"ṭakaakki", "brown"));
        numbers.add(new Word(R.raw.color_gray,R.drawable.color_gray,"ṭopoppi", "gray"));
        numbers.add(new Word(R.raw.color_black,R.drawable.color_black,"kululli", "black"));
        numbers.add(new Word(R.raw.color_white,R.drawable.color_white,"kelelli", "white"));
        numbers.add(new Word(R.raw.color_dusty_yellow,R.drawable.color_dusty_yellow,"ṭopiisә", "dusty yellow"));
        numbers.add(new Word(R.raw.color_mustard_yellow,R.drawable.color_mustard_yellow,"chiwiiṭә", "mustard yellow"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdabter itemsAdapter = new WordAdabter(this, numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_listyout file.
        ListView listView = (ListView) findViewById(R.id.list_View);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        int getColor = getResources().getColor(R.color.category_colors);

        listView.setBackgroundColor(getColor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = numbers.get(position); //
                mediaPlayer = MediaPlayer.create(ColorsActivity.this , word.getmMediaPlayerId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

