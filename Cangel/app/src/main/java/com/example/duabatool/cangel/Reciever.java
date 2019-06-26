package com.example.duabatool.cangel;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;
import static com.example.duabatool.cangel.R.raw.ring1;

class Reciever extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
    boolean isRunning;
int i=0;
int  my_selection=0;
int bl=0;
        Boolean charger=false;
        @Override
        public void onReceive(Context context, Intent intent) {
           if(intent.getAction().equals("package com.example.duabatool.cangel")){
 my_selection=intent.getExtras().getInt("my_selection");
 bl=intent.getExtras().getInt("bl");
//Toast.makeText(context,"inside receiver battry level"+bl,Toast.LENGTH_LONG).show();

           }

            Intent service = new Intent(context, my_service.class);
   //         service.putExtra("my_selection",my_selection);

           service.putExtra("my_selection",my_selection);
            service.putExtra("bl",bl);
           context.startService(service);


        //    int i=intent.getExtras().getInt("i");
           // int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
           // boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING && status == BatteryManager.BATTERY_STATUS_FULL;
//if(isCharging){
  //  Toast.makeText(context, "If condition is true", Toast.LENGTH_LONG).show();

//}else if(!isCharging){
  //  Toast.makeText(context, "else condition is true", Toast.LENGTH_LONG).show();

//}

          /* if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                //Toast.makeText(context, "The device is  charging", Toast.LENGTH_LONG).show();
               // Toast.makeText(context, "that is shit", Toast.LENGTH_LONG).show();

                charger = true;
            }
            else {
                intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED);
             //   Toast.makeText(context, "The device is not charging", Toast.LENGTH_SHORT).show();
           //     Toast.makeText(context, "that is shit", Toast.LENGTH_LONG).show();

                charger = false;
            }*/
          //  checking(context,charger);
        }

        public void checking(Context context,Boolean charger){

            Intent intent = context.registerReceiver(null,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

            int curLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            //Intent notify = new Intent(context, MainActivity.class);
           // Notification noti;
           // PendingIntent pIntent = PendingIntent.getActivity(context, 0, notify, 0);

                mediaPlayer=MediaPlayer.create(context,R.raw.ring1);
            if(curLevel ==100 && !charger) {
              /*  noti = new Notification.Builder(context).setTicker("Ticker Title")
                        .setContentTitle("Battery Low")
                        .setContentText("Battery " + curLevel + "% Please Connect Charger")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pIntent).getNotification();
                noti.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0, noti);*/
              Toast.makeText(context,"phone is not charging Battery level is"+curLevel,Toast.LENGTH_LONG).show();
if(this.isRunning){
    stopPlaying();
    }isRunning=false;
            }
            else if(curLevel == 100 && charger){
             /*   noti = new Notification.Builder(context).setTicker("Ticker Title")
                        .setContentTitle("Battery Okay")
                        .setContentText("Battery full Please disconnect Charger")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pIntent).getNotification();
                noti.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
              / nm.notify(0, noti);*/
                Toast.makeText(context,"phone is charging Battery level is"+curLevel,Toast.LENGTH_LONG).show();
                if(!this.isRunning){
                mediaPlayer.start();}this.isRunning=true;

            }
            else if(curLevel<100 && charger){
                Toast.makeText(context,"phone is charging Battery level is"+curLevel,Toast.LENGTH_LONG).show();

            }else if(curLevel<100 && !charger){
                Toast.makeText(context,"phone is not charging Battery level is"+curLevel,Toast.LENGTH_LONG).show();
if(this.isRunning ){
    mediaPlayer.stop();

}
            }
        }

    private void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    }

