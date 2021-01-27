package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word(R.raw.number_one,R.drawable.number_one,"lutii", "one"));
        numbers.add(new Word(R.raw.number_two,R.drawable.number_two,"otiiko", "two"));
        numbers.add(new Word(R.raw.number_three,R.drawable.number_three,"tolookosu", "three"));
        numbers.add(new Word(R.raw.number_four,R.drawable.number_four,"oyyisa", "four"));
        numbers.add(new Word(R.raw.number_five,R.drawable.number_five,"massokka", "five"));
        numbers.add(new Word(R.raw.number_six,R.drawable.number_six,"temmokka", "six"));
        numbers.add(new Word(R.raw.number_seven,R.drawable.number_seven,"kenekaku", "seven"));
        numbers.add(new Word(R.raw.number_eight,R.drawable.number_eight,"kawinta", "eight"));
        numbers.add(new Word(R.raw.number_nine,R.drawable.number_nine,"wo’e", "nine"));
        numbers.add(new Word(R.raw.number_ten,R.drawable.number_ten,"na’aacha’e", "ten"));

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

        int getColor = getResources().getColor(R.color.category_numbers);

        listView.setBackgroundColor(getColor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = numbers.get(position); //
                mediaPlayer = MediaPlayer.create(NumbersActivity.this , word.getmMediaPlayerId());
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



/** SOULUTION , For loop and LinearLayout.
 // Creating Text View. ArrayType.
 LinearLayout rootView = (LinearLayout) findViewById(R.id.root_view);
 for(int index = 0; index < numbers.size(); index++) {
 TextView addText = new TextView(this);
 addText.setText(numbers.get(index));
 rootView.addView(addText);
 } */
