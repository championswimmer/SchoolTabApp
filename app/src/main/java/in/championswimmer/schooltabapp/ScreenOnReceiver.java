package in.championswimmer.schooltabapp;

import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.VolumeProvider;
import android.os.SystemClock;
import android.support.v4.media.VolumeProviderCompat;
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
        final DevicePolicyManager mDPM =
                (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        final ComponentName adminComponent =
                new ComponentName(context, SchoolAdminReceiver.class);

        if (mDPM.isAdminActive(adminComponent)) {
            Log.d(TAG, "onReceive: is active");

            Calendar cal = new GregorianCalendar();
            int hour = cal.get(Calendar.HOUR_OF_DAY);

            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);


            if (hour > 7 && hour < 14) {
                Log.d(TAG, "onReceive: Time matches = closing cam + audio");
                mDPM.setCameraDisabled(adminComponent, true);
                audioManager.setStreamVolume(AudioManager.STREAM_ALARM, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
                audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
                audioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
                audioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            } else {
                Log.d(TAG, "onReceive: Time doesn't match = opening cam + audio");
                mDPM.setCameraDisabled(adminComponent, false);
            }
        }

    }
}
