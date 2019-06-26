package com.example.duabatool.cangel;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button start;
    Button stop;
    Button music;
    BroadcastReceiver receiver;
    Context context;
String r="";
int bl=0;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    private static final int THIRD_ACTIVITY_REQUEST_CODE = 0;

    int my_selection=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize the buttons
         start=(Button)findViewById(R.id.start);
         music=(Button)findViewById(R.id.music);
       // Toast.makeText(getApplicationContext(),"my selection"+my_selection,Toast.LENGTH_LONG).show();

    }

    public void music(View view) {
        Intent music=new Intent(MainActivity.this,Music.class);
        startActivityForResult(music,SECOND_ACTIVITY_REQUEST_CODE );
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
         int mine=data.getExtras().getInt("my_selection");
         this.my_selection=mine;
            }
        }
        if (requestCode == THIRD_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                int min=data.getExtras().getInt("my_selection");
                this.bl=min;
            }
        }
    }
    public void Start(View view) {
//method to register the receiver
register_receiver();
       // Toast.makeText(getApplicationContext(),"my selection"+my_selection,Toast.LENGTH_LONG).show();
        Intent intent = new Intent("package com.example.duabatool.cangel");
        intent.putExtra("my_selection",my_selection);
        intent.putExtra("bl",bl);
        sendBroadcast(intent);
    }
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    public void register_receiver(){
        IntentFilter filter = new IntentFilter();
     // filter.addAction("android.intent.action.BATTERY_CHANGED");
    filter.addAction("package com.example.duabatool.cangel");
        receiver = new Reciever();
        registerReceiver(receiver, filter);;
        }

//create action bar
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.actnbr, menu);
    return true;
}
    public boolean onOptionsItemSelected(MenuItem item){
        Intent i;
        switch (item.getItemId()){
            case R.id.help:
               i=new Intent(MainActivity.this,help.class);
               startActivity(i);
                return true;
            case R.id.info:
                i=new Intent(MainActivity.this,info.class);
                startActivity(i);
                return true;
default:return super.onOptionsItemSelected(item);
        }

    }

    public void BL(View view) {
        Intent music=new Intent(MainActivity.this,BL.class);
        startActivityForResult(music,THIRD_ACTIVITY_REQUEST_CODE );
    }

    public void mode(View view) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }
}
