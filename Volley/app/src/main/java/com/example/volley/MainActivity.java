package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

   private SimpleRequest simpleRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String URL = "https://www.google.com";

        simpleRequest = new SimpleRequest(this, URL);
        simpleRequest.request();
    }

    @Override
    protected void onStop() {
        super.onStop();
        simpleRequest.cancel();
    }
}
