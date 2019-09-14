package com.example.user_pc.loginui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


public class LoginActivity extends AppCompatActivity {

    private TextView registerTv, loginTv, forgotTv;
    private EditText usernameEt, passwordEt;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupUIViews();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user!=null) {
            //Log.d("displayname", user.getDisplayName());
            Log.d("user", user.toString());
            Log.d("email", user.getEmail());
            //finish();  //Destroys Current Activity ie. LoginActivity
            startActivity(new Intent(LoginActivity.this, GetStartedActivity.class));
        }

        loginTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : Validatethe fields first
                Toast.makeText(LoginActivity.this, "Starting Validation", Toast.LENGTH_LONG);
                validate(usernameEt.getText().toString().trim(), passwordEt.getText().toString().trim());
            }
        });

        registerTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                startActivity(new Intent(LoginActivity.this, FormActivity.class));
            }
        });

        forgotTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });

    }

    private void setupUIViews() {
        loginTv = (TextView) findViewById(R.id.login);
        registerTv = (TextView) findViewById(R.id.register);
        usernameEt = (EditText) findViewById(R.id.username);
        passwordEt = (EditText) findViewById(R.id.password);
        forgotTv = (TextView) findViewById(R.id.forgotpwd);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(LoginActivity.this);
    }

    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("Hang tight!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, GetStartedActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
