package com.example.salart.applogin;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Accountactivity extends AppCompatActivity {

//    private FirebaseAuth fauth;
//    private FirebaseAuth.AuthStateListener listen;
//    private Button logout;
//    private TextView text;
    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mainFrame = findViewById(R.id.frameLayout);
        mainNav = findViewById(R.id.nav_main);

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();
        fiveFragment = new FiveFragment();


        mainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_one :
                        mainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(oneFragment);
                        return true;

                    case R.id.nav_two:
                        mainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(twoFragment);
                        return true;

                    case R.id.nav_three:
                        mainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(threeFragment);
                        return true;
                    case R.id.nav_four:
                        mainNav.setItemBackgroundResource(R.color.Yellow);
                        setFragment(fourFragment);
                        return true;
                    case R.id.nav_five:
                        mainNav.setItemBackgroundResource(R.color.LavenderBlush);
                        setFragment(fiveFragment);
                        return true;

                        default:
                            return false;

                }
            }

            private void setFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fragment);
                fragmentTransaction.commit();
            }
        });


        //logout = findViewById(R.id.loutbutton);
       // text = findViewById(R.id.textView2);
//        fauth = FirebaseAuth.getInstance();
//        FirebaseUser user = fauth.getCurrentUser();
//        text.setText("Well ome "+user.getEmail());
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Accountactivity.this,"working",Toast.LENGTH_LONG).show();
//                FirebaseAuth.getInstance().signOut();
//
//            }
//        });
//
//        listener();
//    }
//
//    private void listener(){
//        Log.d("listen","setting up listener");
//        listen = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null){
//
//
//                }
//                else {
//                    Toast.makeText(Accountactivity.this,"Signed Out",Toast.LENGTH_SHORT).show();
//                    Intent intent =new Intent(Accountactivity.this,LoginActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
//                    startActivity(intent);
//
//                }
//
//            }
//        };
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseAuth.getInstance().addAuthStateListener(listen);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (listen != null){
//                FirebaseAuth.getInstance().removeAuthStateListener(listen);
//        }
    }

    

}