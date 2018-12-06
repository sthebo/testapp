package com.example.salart.applogin;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    private FirebaseAuth fauth;
    private FirebaseAuth.AuthStateListener listen;
    private Button logout;
    private TextView text;


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view= inflater.inflate(R.layout.fragment_one, container, false);


        logout = view.findViewById(R.id.loutbutton);
         text = view.findViewById(R.id.textView2);
        fauth = FirebaseAuth.getInstance();
        FirebaseUser user = fauth.getCurrentUser();
        text.setText("Well Come "+user.getEmail());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"working",Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();

            }
        });

        listener();

        return view;
    }


    private void listener(){
        Log.d("listen","setting up listener");
        listen = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){


                }
                else {
                    //Toast.makeText(getActivity(),"Signed Out",Toast.LENGTH_SHORT).show();

                    Intent intent =new Intent(getContext(),LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                    startActivity(intent);

                }

            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(listen);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (listen == null) {
            FirebaseAuth.getInstance().removeAuthStateListener(listen);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context = getActivity();
    }
}

