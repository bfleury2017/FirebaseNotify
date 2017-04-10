package com.nhti.firebasenotify;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFBMessageService extends FirebaseMessagingService {
    String TAG = "firebasenotify";

    public MyFBMessageService() {
    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String remoteTitle = remoteMessage.getNotification().getTitle();
        String remoteMsg = remoteMessage.getNotification().getBody();

        Log.d(TAG, "Notification title: "+ remoteTitle);
        Log.d(TAG, "Notification message: "+ remoteMsg);

        super.onMessageReceived(remoteMessage);
    }
}
