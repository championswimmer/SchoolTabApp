package in.championswimmer.schooltabapp;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class LongRunningService extends Service {
    public LongRunningService() {
    }

    IntentFilter intentFilter;
    ScreenOnReceiver screenOnReceiver;



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
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
