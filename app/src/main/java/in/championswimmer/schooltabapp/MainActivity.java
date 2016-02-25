package in.championswimmer.schooltabapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    IntentFilter intentFilter;
    ScreenOnReceiver screenOnReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        screenOnReceiver = new ScreenOnReceiver();
        try {
            unregisterReceiver(screenOnReceiver);
        } catch (Exception e) {

        }
        registerReceiver(screenOnReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();

//        unregisterReceiver(screenOnReceiver);
    }
}
