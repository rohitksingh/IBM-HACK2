package com.example.user_pc.loginui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {

    private Button myInfo, yourInfo, see;
    private static final String TAG = "UserActivity";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        myInfo = findViewById(R.id.myInro);
        yourInfo = findViewById(R.id.yourIntro);
        see = findViewById(R.id.see);

        myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyIntro();
            }
        });

        yourInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYourIntro();
            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reachOut();
            }
        });

        String extraMsg = getIntent().getStringExtra("click_action");
        if(extraMsg!=null) {
            Log.d(TAG, "onCreate: "+extraMsg);
        }else
        {
            Log.d(TAG, "onCreate: is Null");
        }




    }

    public void openMyIntro(){

        startActivity(new Intent(this, FormActivity.class));

    }

    public void openYourIntro(){

        startActivity(new Intent(this, QuestionnaireActivity.class));

    }

    public void reachOut(){
        startActivity(new Intent(this, ProfileActivity.class));
    }



}
