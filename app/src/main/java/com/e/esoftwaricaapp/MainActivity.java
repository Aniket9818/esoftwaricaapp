package com.e.esoftwaricaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.e.esoftwaricaapp.adapter.Students;
import com.e.esoftwaricaapp.fragment.AboutFragment;
import com.e.esoftwaricaapp.fragment.AddFragment;
import com.e.esoftwaricaapp.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Students> studentsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        if (studentsList.isEmpty()) {
            studentsList.add(new Students("jone", "male", "Nepal", 28));
            studentsList.add(new Students("max", "female", "China", 27));
            studentsList.add(new Students("ram", "other", "USA", 49));
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.navHome:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navAddStudent:
                    selectedFragment = new AddFragment();
                    break;
                case R.id.navAboutUs:
                    selectedFragment = new AboutFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}
