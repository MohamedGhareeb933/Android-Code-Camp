package com.example.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton mySingletonInstance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context context;

    MySingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue, imageCache);
    }


    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }


    private ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {
        final LruCache<String, Bitmap> cache = new LruCache<>(20);

        @Nullable
        @Override
        public Bitmap getBitmap(String url) {
            return cache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            cache.put(url, bitmap);
        }
    };

    public static synchronized MySingleton getMySingletonInstance(Context context) {
        return mySingletonInstance = new MySingleton(context);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        requestQueue.add(request);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
