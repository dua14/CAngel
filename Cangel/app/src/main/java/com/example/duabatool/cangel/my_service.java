package com.example.duabatool.cangel;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class my_service extends Service {
 MediaPlayer mediaPlayer;
    static boolean isRunning=false;
    Boolean charger=false;
   int my_selection=0;
   int bl=100;

    private BroadcastReceiver mBatteryStateReceiver = new BroadcastReceiver() {

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            Toast.makeText(getApplicationContext(), "battery" + bl, Toast.LENGTH_SHORT).show();

            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

            //selection of my music
            switch (my_selection) {
                case 0:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm1);
                    break;
                case 1:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm2);
                    break;
                case 3:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm3);
                    break;
                case 4:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm4);
                    break;
                case 5:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm5);
                    break;
                case 6:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm6);
                    break;
                case 7:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm7);

                    break;
                case 8:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm8);

                    break;
                case 9:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm9);

                    break;
                case 10:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm10);

                    break;
                case 11:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm11);

                    break;
                case 12:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm12);

                    break;
                case 13:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm13);

                    break;
                case 14:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm14);

                    break;
                case 15:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm15);

                    break;
                case 16:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm16);

                    break;
                case 17:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm17);

                    break;
                case 18:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm18);

                    break;
                case 19:
                    mediaPlayer = MediaPlayer.create(context, R.raw.alarm19);

                    break;
            }


            //Toast.makeText(getApplicationContext(),""+charger,Toast.LENGTH_SHORT).show();
            checking(context, isCharging);

            if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                int notificationId = 1;
                String channelId = "channel-01";
                String channelName = "Channel Name";
                int importance = NotificationManager.IMPORTANCE_HIGH;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(
                            channelId, channelName, importance);
                    notificationManager.createNotificationChannel(mChannel);
                }

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Cangel")
                        .setBadgeIconType(R.drawable.ic_launcher_background)
                        .setAutoCancel(false)
                        .setContentText("Charger removed");


                TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                stackBuilder.addNextIntent(intent);
                PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
                mBuilder.setContentIntent(resultPendingIntent);
                notificationManager.notify(notificationId, mBuilder.build());

            }
        }
    };

    public void onCreate() {
        super.onCreate();

        IntentFilter ifilter = new IntentFilter();
      //  ifilter.addAction(Intent.ACTION_POWER_CONNECTED);
        ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        ifilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        //ifilter.addAction(Intent.ACTION_BATTERY_OKAY);
        registerReceiver(mBatteryStateReceiver, ifilter);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
//receive intent
int my_selection=intent.getExtras().getInt("my_selection");
        int bl=intent.getExtras().getInt("bl");
//   Toast.makeText(getApplicationContext(),"inside service"+my_selection,Toast.LENGTH_LONG).show();
      this.my_selection=my_selection;
    this.bl=bl;
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mBatteryStateReceiver);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void checking(Context context,Boolean charger){
        Intent intent = context.registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int curLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
//        mediaPlayer=MediaPlayer.create(context,R.raw.ring2);

        if(curLevel==100 && !charger) {
//            Toast.makeText(context, "phone is not charging Battery level is" + curLevel, Toast.LENGTH_LONG).show();
                if (isRunning) {
                    stopPlaying();
                }

            } else if (curLevel ==100 && charger) {
  //              Toast.makeText(context, "phone is charging Battery level is" + curLevel, Toast.LENGTH_LONG).show();
                if (!this.isRunning) {
                    mediaPlayer.start();
                }
                this.isRunning = true;

            } else if (curLevel<100 && charger) {
    //            Toast.makeText(context, "phone is charging Battery level is" + curLevel, Toast.LENGTH_LONG).show();

            } else if (curLevel < 100 && !charger) {
      //          Toast.makeText(context, "phone is not charging Battery level is" + curLevel, Toast.LENGTH_LONG).show();
                if (this.isRunning) {
                    mediaPlayer.stop();

                }

            }
        }




    private void stopPlaying() {

            mediaPlayer.stop();
            mediaPlayer.release();


    }
}
