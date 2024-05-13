package com.cizer.tryretrofit;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    Homefrag homeFragment = new Homefrag();

    AppInfo appInfo = new AppInfo();

    ProductFragment productFragment = new ProductFragment();

    Contactfrag contactFragment = new Contactfrag();

    Profilefragment pf = new Profilefragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home_screen);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.homeItem);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.homeItem) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.profileItem){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, productFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.skillItem){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.cvItem) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, appInfo).commit();
            return true;
        }else if(item.getItemId() == R.id.pfItem) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, pf).commit();
            return true;
        } else {
            return false;
        }
    }
}
