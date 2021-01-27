package com.example.popup2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    LinearLayout parentLinearLayout ;
    LinearLayout buttonLinearLayout ;

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

        Button popupButton = findViewById(R.id.button_popup);

        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.buttons, buttonLinearLayout);
        popupWindow = new PopupWindow(popupView, width, height, focus);

        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 popupWindow.showAtLocation(parentLinearLayout, Gravity.BOTTOM ,10, 10);


               /** popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                }); */
            }
        });



    }
}
