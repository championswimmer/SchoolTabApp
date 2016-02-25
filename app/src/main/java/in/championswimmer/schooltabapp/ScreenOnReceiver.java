package in.championswimmer.schooltabapp;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by championswimmer on 22/2/16.
 */
public class ScreenOnReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("ARNAV", "received");
        DevicePolicyManager mDPM =
                (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName adminComponent =
                new ComponentName(context, SchoolAdminReceiver.class);

        if (mDPM.isAdminActive(adminComponent)) {
            Log.d("ARNAV", "onReceive: is active");

            Calendar cal = new GregorianCalendar();
            int hour = cal.get(Calendar.HOUR_OF_DAY);

            if (hour > 7 && hour < 23) {
                mDPM.setCameraDisabled(adminComponent, true);
            } else {
                mDPM.setCameraDisabled(adminComponent, false);
            }
        }

    }
}
