package com.aric.alarm_application

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    private val TAG = "QuizAlarmReceiver"

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Alarm triggered")
        val serviceIntent = Intent(context, AlarmService::class.java)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            context.startForegroundService(serviceIntent)
        } else {
            context.startService(serviceIntent)
        }
    }

}