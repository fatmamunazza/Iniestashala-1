package com.buddheshwar.iniestashala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.buddheshwar.iniestashala.MainScreen.Mainscreen;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        startActivity(new Intent(LoginActivity.this, Mainscreen.class));


    }
}
