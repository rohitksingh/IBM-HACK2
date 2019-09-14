package com.example.user_pc.loginui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private Button openMap, call;

    private TextView mobNum, address;

    @Override
    protected void onCreate(Bundle sis) {
        super.onCreate(sis);
        setContentView(R.layout.activity_profile);
        openMap = findViewById(R.id.openMap);
        String name = getIntent().getStringExtra("Name");

        mobNum = findViewById(R.id.mobNum);
        call = findViewById(R.id.call);
        mobNum.setMovementMethod(LinkMovementMethod.getInstance());
        //getSupportActionBar().setTitle(name);



        String extraMsg = getIntent().getStringExtra("click_action");
        if(extraMsg!=null) {
            Toast.makeText(ProfileActivity.this,extraMsg , Toast.LENGTH_LONG).show();
        }else
        {
            Toast.makeText(ProfileActivity.this,"NULL" , Toast.LENGTH_LONG).show();
        }



        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=1718 S Jentily Lane");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + getNum()));
                if (ActivityCompat.checkSelfPermission(ProfileActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });


    }

    private String getNum(){
        return "480-937-6079";
    }
}