package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word(R.raw.family_father,R.drawable.family_father,"әpә", "father"));
        numbers.add(new Word(R.raw.family_mother,R.drawable.family_mother,"әṭa", "mother"));
        numbers.add(new Word(R.raw.family_son,R.drawable.family_son,"angsi", "son"));
        numbers.add(new Word(R.raw.family_daughter,R.drawable.family_daughter,"tune", "daughter"));
        numbers.add(new Word(R.raw.family_older_brother,R.drawable.family_older_brother,"taachi", "older brother"));
        numbers.add(new Word(R.raw.family_younger_brother,R.drawable.family_younger_brother,"chalitti", "younger brother"));
        numbers.add(new Word(R.raw.family_older_sister,R.drawable.family_older_sister,"teṭe", "older sister"));
        numbers.add(new Word(R.raw.family_grandmother,R.drawable.family_grandmother,"ama", "grandmother"));
        numbers.add(new Word(R.raw.family_grandfather,R.drawable.family_grandfather,"paapa", "grandfather"));

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

        int getColor = getResources().getColor(R.color.category_family);

        listView.setBackgroundColor(getColor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = numbers.get(position); //
                mediaPlayer = MediaPlayer.create(FamilyActivity.this , word.getmMediaPlayerId());
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

