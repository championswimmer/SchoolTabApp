package in.championswimmer.schooltabapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LongRunningService extends Service {

    public static final String TAG = "LongRunningService";
    public LongRunningService() {
    }

    IntentFilter intentFilter;
    ScreenOnReceiver screenOnReceiver;



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");

        intentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        screenOnReceiver = new ScreenOnReceiver();
        try {
            unregisterReceiver(screenOnReceiver);
        } catch (Exception e) {

        }

        registerReceiver(screenOnReceiver, intentFilter);


        return START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
