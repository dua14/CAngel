package com.example.duabatool.cangel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Music extends AppCompatActivity {
public int my_selection=0;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        intent=new Intent();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.b0:
                        my_selection=0;
                        intent.putExtra("my_selection", my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b1:
                        my_selection=1;
                       intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b2:
                        my_selection=2;
                       intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b3:
                        my_selection=3;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b4:
                        my_selection=4;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b5:
                        my_selection=5;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b6:
                        my_selection=6;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b7:
                        my_selection=7;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b8:
                        my_selection=8;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b9:
                        my_selection=9;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b10:
                        my_selection=10;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b11:
                        my_selection=11;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b12:
                        my_selection=12;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b13:
                        my_selection=13;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b14:
                        my_selection=14;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b15:
                        my_selection=15;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b16:
                        my_selection=16;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b17:
                        my_selection=17;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b18:
                        my_selection=18;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                }
            }
        });
        //Toast.makeText(getApplicationContext(),"id"+my_selection,Toast.LENGTH_LONG).show();
    }
}
