package com.nhti.firebasenotify;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
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

        createNotification(remoteMsg);

        super.onMessageReceived(remoteMessage);
    }

    private void createNotification(String messageBody) {
        Intent intent = new Intent(this, FirebaseNotifyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent resultIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_add)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setContentIntent(resultIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, mNotificationBuilder.build());
    }
}
