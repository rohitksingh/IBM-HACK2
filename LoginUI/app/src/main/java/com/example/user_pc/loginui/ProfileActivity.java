package com.example.user_pc.loginui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private Button openMap;

    @Override
    protected void onCreate(Bundle sis){
        super.onCreate(sis);
        setContentView(R.layout.activity_profile);
        openMap = findViewById(R.id.openMap);
        String name = getIntent().getStringExtra("Name");
        //getSupportActionBar().setTitle(name);

        Toast.makeText(ProfileActivity.this, name, Toast.LENGTH_LONG).show();

        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=1718 S Jentily Lane");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });


    }
}