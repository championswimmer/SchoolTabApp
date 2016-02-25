package in.championswimmer.schooltabapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by championswimmer on 25/2/16.
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, LongRunningService.class);
        context.startService(i);

    }
}
