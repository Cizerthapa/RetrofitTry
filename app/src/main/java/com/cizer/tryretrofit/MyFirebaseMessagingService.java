package com.cizer.tryretrofit;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMessagingCZR";
    private static final String ID_CHANNEL = "notifications";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Check if the message contains data
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message of payload data: " + remoteMessage.getData());

            // Handle the data payload here
            // You can access the data payload using remoteMessage.getData()
        }

        // Check if the message contains a notification payload
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message of notification body: " + remoteMessage.getNotification().getBody());

            showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());

            // Handle the notification payload here
            // You can access the notification payload using remoteMessage.getNotification()
        }
    }

    @Override
    public void onNewToken(String token) {
        // If you need to handle token refresh, override this method
        Log.d(TAG, "Here is Refreshed token: " + token);
    }

    private void showNotification(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ID_CHANNEL)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Make NotificationChannel, but only on API 26 or above because
        // NotificationChannel class is very new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel_name";
            String description = "channel_description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(ID_CHANNEL, name, importance);
            channel.setDescription(description);
            // Register the channel with the system
            notificationManager.createNotificationChannel(channel);
        }

        // Show the notification
        notificationManager.notify(0, builder.build());
    }
}
