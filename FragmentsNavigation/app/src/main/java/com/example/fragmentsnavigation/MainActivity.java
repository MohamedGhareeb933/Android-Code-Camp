package com.example.fragmentsnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navListner);

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragment_container_view, new HomeFragment())
                .commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragmentSelected = null;

            switch (item.getItemId()) {
                case R.id.nav_home :
                    fragmentSelected = new HomeFragment();
                    break;
                case R.id.nav_group :
                    fragmentSelected = new GroupFragment();
                    break;
                case R.id.nav_photo :
                    fragmentSelected = new PhotoFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, fragmentSelected)
                    .commit();
            return true;
        }
    };
}