package com.example.volley;

import android.app.Activity;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

public class RequestSetup {

    public static final String REQUEST_SETUP_TAG = "SetupTag";

    private Activity activity;
    private String Url;

    private TextView textView;
    private RequestQueue requestQueue;

    public RequestSetup(Activity activity, String Url) {
        this.activity = activity;
        this.Url = Url;
    }

    public void request() {

        textView = activity.findViewById(R.id.textView);

        Cache cache = new DiskBasedCache(activity.getCacheDir(), 1024* 1024);

        Network network = new BasicNetwork(new HurlStack());

        requestQueue = new RequestQueue(cache, network);

        requestQueue.start();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, responseListener, errorListener);

        stringRequest.setTag(REQUEST_SETUP_TAG);

        requestQueue.add(stringRequest);
    }

    private Response.Listener responseListener = new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            textView.setText("response : " + response);
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            textView.setText("didnt work");
        }
    };

    public void cancel() {
        requestQueue.cancelAll(REQUEST_SETUP_TAG);
    }
}
