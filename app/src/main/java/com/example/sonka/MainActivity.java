package com.example.sonka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AddMemberFragment.onFragAddMemberBtn {
NavigationView navigationView;
Toolbar toolbar;
DrawerLayout drawerLayout;
ActionBarDrawerToggle actionBarDrawerToggle;
FragmentManager fragmentManager;
FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new MainFragment());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new MainFragment());
            fragmentTransaction.addToBackStack(null).commit();
        }

        if (item.getItemId() == R.id.members){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new MembersFragment());
            fragmentTransaction.addToBackStack(null).commit();
        }


        return false;
    }


    @Override
    public void addMemberBtn() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new MainFragment());
        fragmentTransaction.addToBackStack(null).commit();
    }
}