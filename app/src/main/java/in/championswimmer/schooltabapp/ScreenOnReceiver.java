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

    public static final String TAG = "ScreenOnReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "received");
        DevicePolicyManager mDPM =
                (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        ComponentName adminComponent =
                new ComponentName(context, SchoolAdminReceiver.class);

        if (mDPM.isAdminActive(adminComponent)) {
            Log.d(TAG, "onReceive: is active");

            Calendar cal = new GregorianCalendar();
            int hour = cal.get(Calendar.HOUR_OF_DAY);

            if (hour > 7 && hour < 14) {
                Log.d(TAG, "onReceive: Time matches = closing cam + audio");
                mDPM.setCameraDisabled(adminComponent, true);
            } else {
                Log.d(TAG, "onReceive: Time doesn't match = opening cam + audio");
                mDPM.setCameraDisabled(adminComponent, false);
            }
        }

    }
}
