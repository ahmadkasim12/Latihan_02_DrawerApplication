package com.akbar08.drawer_fragment_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.akbar08.drawer_fragment_application.fragments.fragment_fav_food_list;
import com.akbar08.drawer_fragment_application.fragments.fragment_food_list;
import com.akbar08.drawer_fragment_application.fragments.fragment_beverage_list;
import com.akbar08.drawer_fragment_application.fragments.fragment_homepage;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ImageView userAvatar;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        showHomePage();

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, findViewById(R.id.toolbar), R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        userAvatar = header.findViewById(R.id.imageViewProfile);
        Glide.with(header.getContext()).load("https://cdn.discordapp.com/attachments/719779367911292938/1196078292143444018/image.png?ex=66129ab6&is=660025b6&hm=46ed531fd3af3cf20510da85e28a39d83a4d0591c98c6c60be8cc708410173a6&").into(userAvatar);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigationView.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                int itemId = item.getItemId();

                if (itemId == R.id.menu_item0) {
                    showHomePage();
                } else if (itemId == R.id.menu_item1) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new fragment_food_list())
                            .commit();
                    getSupportActionBar().setTitle("Makanan daerah");
                } else if (itemId == R.id.menu_item2){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new fragment_beverage_list())
                            .commit();
                    getSupportActionBar().setTitle("Minuman daerah");
                }  else if (itemId == R.id.menu_item3){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, new fragment_fav_food_list())
                            .commit();
                    getSupportActionBar().setTitle("Makanan favorit");
                }

                drawerLayout.closeDrawers();
                return true;

            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void showHomePage() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new fragment_homepage())
                .commit();
        getSupportActionBar().setTitle("Home");
    }
}