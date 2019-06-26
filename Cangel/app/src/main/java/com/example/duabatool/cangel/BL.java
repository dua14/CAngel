package com.example.duabatool.cangel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class BL extends AppCompatActivity {
Intent intent;
int my_selection=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bl);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        intent=new Intent();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.b0:
                        my_selection=100;
                        intent.putExtra("my_selection", my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b1:
                        my_selection=99;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b2:
                        my_selection=98;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b3:
                        my_selection=97;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b4:
                        my_selection=96;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b5:
                        my_selection=95;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b6:
                        my_selection=94;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b7:
                        my_selection=93;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b8:
                        my_selection=92;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b9:
                        my_selection=91;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b10:
                        my_selection=90;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b11:
                        my_selection=89;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b12:
                        my_selection=88;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b13:
                        my_selection=87;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b14:
                        my_selection=86;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b15:
                        my_selection=85;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b16:
                        my_selection=84;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b17:
                        my_selection=83;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.b18:
                        my_selection=82;
                        intent.putExtra("my_selection",my_selection);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                        break;
                }
            }
        });
    }
}
