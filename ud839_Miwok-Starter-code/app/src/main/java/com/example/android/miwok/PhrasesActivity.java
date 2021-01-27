package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word(R.raw.phrase_where_are_you_going,"minto wuksus", "Where are you going?"));
        numbers.add(new Word(R.raw.phrase_what_is_your_name,"tinnә oyaase'nә", "What is your name?"));
        numbers.add(new Word(R.raw.phrase_my_name_is,"oyaaset...", "My name is..."));
        numbers.add(new Word(R.raw.phrase_how_are_you_feeling,"michәksәs?", "How are you feeling?"));
        numbers.add(new Word(R.raw.phrase_im_feeling_good,"kuchi achit", "I’m feeling good."));
        numbers.add(new Word(R.raw.phrase_are_you_coming,"әәnәs'aa?", "Are you coming?"));
        numbers.add(new Word(R.raw.phrase_yes_im_coming,"hәә’ әәnәm", "Yes, I’m coming."));
        numbers.add(new Word(R.raw.phrase_im_coming,"әәnәm", "I’m coming."));
        numbers.add(new Word(R.raw.phrase_lets_go,"yoowutis", "Let’s go."));
        numbers.add(new Word(R.raw.phrase_come_here,"әnni'nem", "Come here."));

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

        int getColor = getResources().getColor(R.color.category_phrases);

        listView.setBackgroundColor(getColor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = numbers.get(position); //
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this , word.getmMediaPlayerId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if(mediaPlayer != null) {
                            releaseMediaPlayer();
                        }
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
