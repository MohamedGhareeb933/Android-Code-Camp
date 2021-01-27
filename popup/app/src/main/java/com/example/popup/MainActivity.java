package com.example.popup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {

    PopupWindow popUp;
    LinearLayout linearLayout; //
    TextView textView; //
    LinearLayout.LayoutParams linearLayoutParams; //
    LinearLayout mainLayout;
    Button button;
    boolean bClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        popUp = new PopupWindow(this);
        linearLayout = new LinearLayout(this); //
        mainLayout = new LinearLayout(this);

        textView = new TextView(this); //
        button = new Button(this);
        button.setText("Click me!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bClick) { // which is true , happens
                    popUp.showAtLocation(linearLayout, Gravity.END, 10, 10);
                    popUp.update(50, 50, 300, 300);
                    bClick = false;
                } else {
                    popUp.dismiss();
                    bClick = true;
                }
            }
        });

        linearLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        textView.setText("simple pop up window");
        linearLayout.addView(textView,linearLayoutParams);

        popUp.setContentView(linearLayout);

        mainLayout.addView(button, linearLayoutParams);
        setContentView(mainLayout);
    }
}
