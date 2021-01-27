package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // times per millis 6000 Millis = 6 sec , setup to final to handle reset time case
    private static final long START_TIME_IN_Millis = 600000;

    // count down Timer instance , used to setup the Timer and use the onTick method
    private CountDownTimer mCountDownTimer;

    // handle the Case if the time running or not
    private boolean mTimerRunning;

    //  equal to start time in millis, without final, onTick method and Stop timer method.
    private long mTimeLeftInMillis = START_TIME_IN_Millis;


    private TextView mTextViewCountDown; // the Count down Text view
    private TextView mTextViewHomeFouls; //  Home Fouls text View
    private TextView mTextViewGuestFouls; // guest fouls text view
    private TextView mTextViewHomeScore; // home score text view
    private TextView mTextViewGuestScore; // guest score Text view

    private EditText mEditTextHome; // // home name text view
    private EditText mEditTextGuest; // guest name text view

    // linearlayout instances , used in inflated method services and popup window location
    LinearLayout parentLinearLayout;

    //Home score used to cal the Score of the home and Guest team.
    private static int homeScore = 0;
    private static int guestScore = 0;
    //home and guest fouls we set these to max of 5 fouls in the on click methoids.
    private static int homeFouls = 0;
    private static int guestFouls = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FIND VIEW BY ID
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mEditTextHome = findViewById(R.id.editText_home);
        mEditTextGuest = findViewById(R.id.editText_guest);
        mTextViewHomeFouls = findViewById(R.id.textView_HomeFouls);
        mTextViewGuestFouls = findViewById(R.id.TextView_GuestFouls);
        mTextViewHomeScore = findViewById(R.id.TextView_HomeScore);
        mTextViewGuestScore = findViewById(R.id.textView_GuestScore);

        parentLinearLayout = findViewById(R.id.linearLayout_countdown);

        // on click increase the home fouls , modify the text , pause the count down , set the boolean to false , and reset the home fouls if it equal to 5
        mTextViewHomeFouls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeFouls++;
                mTextViewHomeFouls.setText("HomeFouls: " + homeFouls);
                mTimerRunning = false;
                pauseTimer();
                if(homeFouls == 5 ){
                    homeFouls = 0;
                }
            }
        });

        // on click increase the guest fouls , modify the text , pause the count down , set the boolean to false , and reset the guest fouls if it equal to 5
        mTextViewGuestFouls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guestFouls++;
                mTextViewGuestFouls.setText("Guest Fouls: " + guestFouls);
                mTimerRunning = false;
                pauseTimer();
                if(guestFouls == 5 ){
                    guestFouls = 0;
                }
            }
        });

        // increase the home score on click and modify the text to fit the home score output
        mTextViewHomeScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeScore++;
                mTextViewHomeScore.setText("" + homeScore);
            }
        });

        // increase the guest  score on click and modify the text to fit the guest score output
        mTextViewGuestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guestScore++;
                mTextViewGuestScore.setText("" + guestScore);
            }
        });

        // count down instance , on click if the timer ruuing pause , otherwise start the timer , and set the home name and guest name edit text to disabled
        mTextViewCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                    mEditTextHome.setEnabled(false);
                    mEditTextGuest.setEnabled(false);
                }
            }
        });

        // reset the timer method.
        updateCountDownText();

        final ArrayList<viewClass> addView= new ArrayList<viewClass>();

        addView.add(new viewClass("player 01",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 02",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 03",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 04",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 05",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 06",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 07",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 08",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 09",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 10",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 11",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 12",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 13",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 14",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 15",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 16",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 17",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 18",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 19",0,0,0,0,0,0 ));
        addView.add(new viewClass("player 20",0,0,0,0,0,0 ));

        viewAdabter vAdabter = new viewAdabter(this, addView);

        ListView listView = (ListView) findViewById(R.id.listView_parent);

        listView.setAdapter(vAdabter);
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
                mTextViewCountDown.setTextColor(getResources().getColor(R.color.colorPrimary));
            }

            @Override
            public void onFinish() {
                // TODO. Quarter Increase
                mTimerRunning = false;
                resetTimer();

            }
        }.start();

        mTimerRunning = true;
    }

    // pause the timer method
    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mTextViewCountDown.setTextColor(getResources().getColor(R.color.colorAccent));
    }
    // reset the timer.
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_Millis;
        updateCountDownText();
    }
    // declare the format , define the minutes and sec , set the text into time format
    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormated = String.format("%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormated);

    }
}
