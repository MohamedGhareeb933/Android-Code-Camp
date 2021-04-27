package com.example.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final String URL = "https://www.google.com";
    private SimpleRequest simpleRequest;
    private RequestSetup requestSetup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestSetupCall();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //simpleRequest.cancel();
        //requestSetup.cancel();
    }


    private void simpleRequestCall() {
        simpleRequest = new SimpleRequest(this, URL);
        simpleRequest.request();
    }

    private void requestSetupCall() {
        requestSetup = new RequestSetup(this, URL);
        requestSetup.request();
    }

    private void mySingletelonInstance() {

        MySingleton.getMySingletonInstance(getApplicationContext()).getRequestQueue();

        //MySingleton.getMySingletonInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);

    }

}
