package in.championswimmer.schooltabapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by championswimmer on 25/2/16.
 */
public class BootCompleteReceiver extends BroadcastReceiver {

    public static final String TAG = "BootCompleteReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive: ");

        Intent i = new Intent(context, LongRunningService.class);
        context.startService(i);

    }
}
