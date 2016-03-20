package com.abmessenger.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.abmessenger.R;

/**
 * Created by PRIYANKA on 3/8/2016.
 */
public class FriendRequestNotificationActivity extends AppCompatActivity {
/*
    NotificationManager nm;
    static final int uniqueID=1394885;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button stat = (Button) findViewById(R.id.btn_friend_request);
        stat.setOnClickListener((View.OnClickListener) this);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(uniqueID);

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, activity_home.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        String body = "This is a message from your friend";
        String title = "One new message";
        Notification n = new Notification(R.drawable.friend_request, body, System.currentTimeMillis());
        n.setLatestEventInfo(this, title, body, pi);
        n.defaults = Notification.DEFAULT_ALL;
        nm.notify(uniqueID,  n);
    }
*/
}

