package com.google.codelabs.mdc.java.shipping;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class ShippingInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipping_info_activity);


        View viewRoot = findViewById(android.R.id.content);

        final List<TextInputLayout> views = Utils.findViewsWithType(viewRoot, TextInputLayout.class);

        Button button = findViewById(R.id.save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean noError = false;
                for (TextInputLayout textInputLayout : views) {
                    String getEditText = textInputLayout.getEditText().getText().toString();
                    if (getEditText.isEmpty()) {
                        textInputLayout.setError(getResources().getString(R.string.error_string));
                    }else {
                        textInputLayout.setError(null);
                    }
                }

                if (noError) {
                    // all fields are valid
                }
            }
        });

    }
}
