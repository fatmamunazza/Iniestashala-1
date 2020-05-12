package com.buddheshwar.iniestashala.MainScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.buddheshwar.iniestashala.R;
import com.google.android.material.navigation.NavigationView;

public class Mainscreen extends AppCompatActivity {

    FrameLayout mainscreenContainer;
    NavigationView navigationDrawerLayout;
    public DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout actionLayout;
    TextView appTitle;
    public static boolean resumeFlag = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        mainscreenContainer=findViewById(R.id.container_mainscreen);
        navigationDrawerLayout=findViewById(R.id.navigation_drawer_view);
        drawerLayout=findViewById(R.id.drawerLayout);
        actionLayout=findViewById(R.id.actionLayout);
        menu=actionLayout.findViewById(R.id.menu_img);
        appTitle=actionLayout.findViewById(R.id.app_title);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        navigationDrawerLayout.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fr;
                switch (menuItem.getItemId()) {
                    case R.id.home_drawer: {

                        return false;

                    }
                    case R.id.resume_drawer: {
                        fr=new EditResume();
                        if(!resumeFlag){
                            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).addToBackStack(null).commit();
                            resumeFlag=true;
                        }
                        else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.container_mainscreen,fr).commit();
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        appTitle.setText("RESUME");

                        return false;

                    }
                    default: {
                        return false;
                    }

                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        resumeFlag=false;
    }
}
