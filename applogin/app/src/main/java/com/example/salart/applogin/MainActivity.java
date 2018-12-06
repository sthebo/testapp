package com.example.salart.applogin;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity{
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener fAuthListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean first = prefs.getBoolean("first", true);


        if (first == true) {
            prefs = getSharedPreferences("prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("first",false);
            editor.apply();
            startActivity(new Intent(this,IntroActivity.class));
        }
        else {
            if (FirebaseAuth.getInstance().getCurrentUser()== null){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
            else {
                startActivity(new Intent(MainActivity.this, Accountactivity.class));
            }
        }
    }
}