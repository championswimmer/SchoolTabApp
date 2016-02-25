package in.championswimmer.schooltabapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG  = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate: Going to start LongRunningService");
        Intent i = new Intent(this, LongRunningService.class);
        startService(i);

    }

    @Override
    protected void onStop() {
        super.onStop();

//        unregisterReceiver(screenOnReceiver);
    }
}
