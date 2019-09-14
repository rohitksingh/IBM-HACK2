package com.example.user_pc.loginui.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh()
    {
        String tokenid = FirebaseInstanceId.getInstance().getToken();
        Log.d("FCM",tokenid);
    }
}