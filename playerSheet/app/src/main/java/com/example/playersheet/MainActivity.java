package com.example.playersheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button pointButton ;
    Button point2Button ;
    Button point3Button ;
    Button reboundButton ;
    Button assistButton ;

    // HOME PLAYER EDIT TEXT
    EditText homePlayer1EditText;
    EditText homePlayer2EditText;
    EditText homePlayer3EditText;
    EditText homePlayer4EditText;
    EditText homePlayer5EditText;
    // GUEST PLAYER EDIT TEXT
    EditText guestPlayer1EditText;
    EditText guestPlayer2EditText;
    EditText guestPlayer3EditText;
    EditText guestPlayer4EditText;
    EditText guestPlayer5EditText;

    Boolean getState;

    LinearLayout parentLinearLayout;
    LinearLayout buttonLinearLayout;

    int width = LinearLayout.LayoutParams.WRAP_CONTENT;
    int height =  LinearLayout.LayoutParams.WRAP_CONTENT;
    Boolean focus = true;

    LayoutInflater inflater;
    View popupView;
    PopupWindow popupWindow;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         parentLinearLayout = findViewById(R.id.linearLayout_parent);
         buttonLinearLayout = findViewById(R.id.linearLayout_button);

        // FIND BUTTONS VIEW ID
         pointButton = findViewById(R.id.button_Point);
         point2Button = findViewById(R.id.button_2points);
         point3Button = findViewById(R.id.button_3points);
         reboundButton = findViewById(R.id.button_Rebound);
         assistButton = findViewById(R.id.button_Assist);

         // FIND HOME PLAYER ID
        homePlayer1EditText = findViewById(R.id.editText_homePlayer_1);
        homePlayer1EditText.setOnClickListener(this);
        homePlayer2EditText = findViewById(R.id.editText_homePlayer_2);
        homePlayer2EditText.setOnClickListener(this);
        homePlayer3EditText = findViewById(R.id.editText_homePlayer_3);
        homePlayer3EditText.setOnClickListener(this);
        homePlayer4EditText = findViewById(R.id.editText_homePlayer_4);
        homePlayer4EditText.setOnClickListener(this);
        homePlayer5EditText = findViewById(R.id.editText_homePlayer_5);
        homePlayer5EditText.setOnClickListener(this);

        // FIND GUEST PLAYER ID
        guestPlayer1EditText = findViewById(R.id.editText_guestPlayer_1);
        guestPlayer1EditText.setOnClickListener(this);
        guestPlayer2EditText = findViewById(R.id.editText_guestPlayer_2);
        guestPlayer2EditText.setOnClickListener(this);
        guestPlayer3EditText = findViewById(R.id.editText_guestPlayer_3);
        guestPlayer3EditText.setOnClickListener(this);
        guestPlayer4EditText = findViewById(R.id.editText_guestPlayer_4);
        guestPlayer4EditText.setOnClickListener(this);
        guestPlayer5EditText = findViewById(R.id.editText_guestPlayer_5);
        guestPlayer5EditText.setOnClickListener(this);

        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.popup_buttons, buttonLinearLayout);
        popupWindow = new PopupWindow(popupView, width, height, focus);


    }

    @Override
    public void onClick(View v) {
        final int greenColor = getResources().getColor(R.color.colorPrimary);

        switch (v.getId()) {
            case R.id.editText_homePlayer_1:
                if(homePlayer1EditText.hasFocus() == false && homePlayer1EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    homePlayer1EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(homePlayer1EditText.getText().toString().length() > 1) {
                    homePlayer1EditText.setClickable(false);
                    homePlayer1EditText.setFocusable(false);
                    homePlayer1EditText.setAlpha(0.5f);
                }

                break;
            case R.id.editText_homePlayer_2:
                if(homePlayer2EditText.hasFocus() == false && homePlayer2EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    homePlayer2EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(homePlayer2EditText.getText().toString().length() > 1) {
                    homePlayer2EditText.setClickable(false);
                    homePlayer2EditText.setFocusable(false);
                    homePlayer2EditText.setAlpha(0.5f);
                }
                break;
            case R.id.editText_homePlayer_3:
                if(homePlayer3EditText.hasFocus() == false && homePlayer3EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    homePlayer3EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(homePlayer3EditText.getText().toString().length() > 1) {
                    homePlayer3EditText.setClickable(false);
                    homePlayer3EditText.setFocusable(false);
                    homePlayer3EditText.setAlpha(0.5f);
                }
                break;
            case R.id.editText_homePlayer_4:
                if(homePlayer4EditText.hasFocus() == false && homePlayer4EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    homePlayer4EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(homePlayer4EditText.getText().toString().length() > 1) {
                    homePlayer4EditText.setClickable(false);
                    homePlayer4EditText.setFocusable(false);
                    homePlayer4EditText.setAlpha(0.5f);
                }

                break;
            case R.id.editText_homePlayer_5:
                if(homePlayer5EditText.hasFocus() == false && homePlayer5EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    homePlayer5EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(homePlayer4EditText.getText().toString().length() > 1) {
                    homePlayer5EditText.setClickable(false);
                    homePlayer5EditText.setFocusable(false);
                    homePlayer5EditText.setAlpha(0.5f);
                }

                break;
            case R.id.editText_guestPlayer_1:
                if(guestPlayer1EditText.hasFocus() == false && guestPlayer1EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    guestPlayer1EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(guestPlayer1EditText.getText().toString().length() > 1) {
                    guestPlayer1EditText.setClickable(false);
                    guestPlayer1EditText.setFocusable(false);
                    guestPlayer1EditText.setAlpha(0.5f);
                }

                break;
            case R.id.editText_guestPlayer_2:
                if(guestPlayer2EditText.hasFocus() == false && guestPlayer2EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    guestPlayer2EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(guestPlayer2EditText.getText().toString().length() > 1) {
                    guestPlayer2EditText.setClickable(false);
                    guestPlayer2EditText.setFocusable(false);
                    guestPlayer2EditText.setAlpha(0.5f);
                }

                break;
            case R.id.editText_guestPlayer_3:
                if(guestPlayer3EditText.hasFocus() == false && guestPlayer3EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    guestPlayer3EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(guestPlayer3EditText.getText().toString().length() > 1) {
                    guestPlayer3EditText.setClickable(false);
                    guestPlayer3EditText.setFocusable(false);
                    guestPlayer3EditText.setAlpha(0.5f);
                }

                break;
            case R.id.editText_guestPlayer_4:

                if(guestPlayer4EditText.hasFocus() == false && guestPlayer4EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    guestPlayer4EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(guestPlayer4EditText.getText().toString().length() > 1) {
                    guestPlayer4EditText.setClickable(false);
                    guestPlayer4EditText.setFocusable(false);
                    guestPlayer4EditText.setAlpha(0.5f);
                }
                break;
            case R.id.editText_guestPlayer_5:
                if(guestPlayer5EditText.hasFocus() == false && guestPlayer5EditText.isClickable() == false ){
                    //Toast.makeText(getApplicationContext(), "Locked", Toast.LENGTH_SHORT).show();
                    guestPlayer5EditText.setTextColor(greenColor);
                    popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);
                    UIUtil.hideKeyboard(this);

                } else if(guestPlayer5EditText.getText().toString().length() > 1) {
                    guestPlayer5EditText.setClickable(false);
                    guestPlayer5EditText.setFocusable(false);
                    guestPlayer5EditText.setAlpha(0.5f);
                }
                break;
        }
    }
}
