package com.akbar08.drawer_fragment_application.fragments;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.akbar08.drawer_fragment_application.R;
import com.bumptech.glide.Glide;

public class nav_header extends AppCompatActivity {

    private ImageView userAvatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);
        userAvatar = findViewById(R.id.imageViewProfile);
        Glide.with(getApplicationContext()).load("https://cdn.discordapp.com/attachments/719779367911292938/1196078292143444018/image.png?ex=66129ab6&is=660025b6&hm=46ed531fd3af3cf20510da85e28a39d83a4d0591c98c6c60be8cc708410173a6&").into(userAvatar);
    }
}
