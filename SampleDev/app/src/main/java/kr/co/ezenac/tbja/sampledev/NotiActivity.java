package kr.co.ezenac.tbja.sampledev;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class NotiActivity extends AppCompatActivity {
    Button btn_basic_noti;
    Button btn_basic_expand;
    Button btn_basic_custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

        btn_basic_noti = findViewById(R.id.btn_basic_noti);
        btn_basic_expand = findViewById(R.id.btn_basic_expand);
        btn_basic_custom = findViewById(R.id.btn_basic_custom);

        btn_basic_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotiActivity.this)
                        .setSmallIcon(R.drawable.ic_budget)
                        .setContentTitle("title")
                        .setContentText("Hello~");
                Intent intent = new Intent(NotiActivity.this,CalActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotiActivity.this);
                stackBuilder.addParentStack(NotiActivity.class);
                stackBuilder.addNextIntent(intent);
                PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                builder.setContentIntent(pendingIntent);

                RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.custom_noti);
                builder.setContent(remoteViews);

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(2,builder.build());
            }
        });

        btn_basic_expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotiActivity.this)
                        .setSmallIcon(R.drawable.ic_budget)
                        .setContentTitle("title")
                        .setContentText("Hello~");
                Intent intent = new Intent(NotiActivity.this,CalActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotiActivity.this);
                stackBuilder.addParentStack(NotiActivity.class);
                stackBuilder.addNextIntent(intent);
                PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                builder.setContentIntent(pendingIntent);

                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                String[] events = new String[6];

                events[0] = "Monday";
                events[1] = "Tuesday";
                events[2] = "Wedsnday";
                events[3] = "Wedsnday";
                events[4] = "Wedsnday";
                inboxStyle.setBigContentTitle("Event tracker details:");
                inboxStyle.setSummaryText("+3 more");
                for (String str : events) {
                    inboxStyle.addLine(str);
                }

                builder.setStyle(inboxStyle);

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,builder.build());
            }
        });

        btn_basic_noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotiActivity.this)
                        .setSmallIcon(R.drawable.ic_budget)
                        .setContentTitle("title")
                        .setContentText("Hello~");

                Intent intent = new Intent(NotiActivity.this,CalActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotiActivity.this);
                stackBuilder.addParentStack(NotiActivity.class);
                stackBuilder.addNextIntent(intent);
                PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });
    }
}
