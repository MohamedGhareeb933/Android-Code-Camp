package com.example.volley;

import android.app.Activity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SimpleRequest {

    public static final String REQUEST_TAG = "MyTag";

    private TextView text;
    private RequestQueue request;

    private Activity activity;
    private String Url;

    public SimpleRequest(Activity activity, String Url) {
        this.activity = activity;
        this.Url = Url;
    }

    public void request() {

        text = activity.findViewById(R.id.textView);

        // instanciate request queue given by volley
        request = Volley.newRequestQueue(activity);

        // get response and map into string
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, stringListener, errorListener);

        // set tag for request
        stringRequest.setTag(REQUEST_TAG);

        // add request to the queue
        request.add(stringRequest);
    }

    // response
    private Response.Listener<String> stringListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            // display response string
            text.setText("response is: " + response.substring(0, 500));
        }
    };

    // response error
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            text.setText("didnt work ");
        }
    };

    public void cancel() {
        request.cancelAll(REQUEST_TAG);
    }
}
