package com.example.user_pc.loginui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class QuestionnaireActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    public void onCreate(Bundle sis){
        super.onCreate(sis);
        setContentView(R.layout.activity_question);

        imageView = findViewById(R.id.image);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });

    }

    public void takePhoto(){
        Toast.makeText(this, "ss", Toast.LENGTH_LONG).show();
    }

}
