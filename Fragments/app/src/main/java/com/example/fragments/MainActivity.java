package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true) //TODO - READ ABOUT
                    .replace(R.id.fragment_container_view, FragmentExample.class, null, "tag")
                    .addToBackStack("name")
                    .commit();

            // find fragment by tag
            FragmentExample fragmentExample = (FragmentExample) fragmentManager.findFragmentByTag("tag");
        }
    }
}