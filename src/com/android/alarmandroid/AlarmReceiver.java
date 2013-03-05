package com.android.alarmandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
	// The alarm action defined in AndroidManifest.xml
	private static final String ALARM_ACTION_NAME = "com.bytefoundry.broadcast.ALARM";

	@Override
	public void onReceive(Context context, Intent intent) {
		// Toast.makeText(context , "Alarm received!",
		// Toast.LENGTH_LONG).show();
		// Handle the alarm broadcast
		if (ALARM_ACTION_NAME.equals(intent.getAction())) {
			// Launch the alarm popup dialog
			Intent alarmIntent = new Intent("android.intent.action.MAIN");

			alarmIntent.setClass(context, AlarmPopUp.class);
			alarmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

			// Pass on the alarm ID as extra data
			alarmIntent.putExtra("AlarmID", intent.getIntExtra("AlarmID", -1));
			alarmIntent.putExtra("AlarmTime",
					intent.getStringExtra("AlarmTime"));

			// Start the popup activity
			context.startActivity(alarmIntent);
		}
		
	}
}