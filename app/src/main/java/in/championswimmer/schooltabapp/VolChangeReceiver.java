package in.championswimmer.schooltabapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by championswimmer on 25/2/16.
 */
public class VolChangeReceiver extends BroadcastReceiver{

    public static final String TAG = "VolChangeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        int newVolume = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
        int oldVolume = intent.getIntExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", 0);
        if (newVolume == oldVolume) {
            return;
        }
        Log.d(TAG, "onReceive: Volume is changed old,new = " + oldVolume + " , " + newVolume);
        Calendar cal = new GregorianCalendar();
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);



        if (hour > 7 && hour < 14 && newVolume != 0) {
            Log.d(TAG, "onReceive: Time matches = closing cam + audio");
            audioManager.setStreamVolume(AudioManager.STREAM_ALARM, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            audioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            audioManager.setStreamVolume(AudioManager.STREAM_SYSTEM, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        } else {
            Log.d(TAG, "onReceive: Time doesn't match = opening cam + audio");
        }
    }
}
