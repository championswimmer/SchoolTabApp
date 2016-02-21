package in.championswimmer.schooltabapp;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

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
            mDPM.setCameraDisabled(adminComponent, true);
        }

    }
}
