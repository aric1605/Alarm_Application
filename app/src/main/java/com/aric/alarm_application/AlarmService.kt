package com.aric.alarm_application

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.IBinder
import android.os.Vibrator
import android.util.Log
import androidx.core.app.NotificationCompat
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build
import androidx.core.content.edit

class AlarmService : Service() {
    private val TAG = "QuizAlarmService"
    private lateinit var ringtone: Ringtone
    private lateinit var vibrator: Vibrator
    companion object {
        const val CHANNEL_ID = "AlarmChannel"
        const val NOTIFICATION_ID = 1
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service created")

        // Create notification channel for Android O+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Alarm Notification",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service started")

        getSharedPreferences("AlarmPrefs", Context.MODE_PRIVATE)
            .edit() {
                putBoolean("alarm_active", true)
            }

        // Set up notification
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Quiz Alarm")
            .setContentText("Complete the quiz to stop the alarm!")
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .build()

        startForeground(NOTIFICATION_ID, notification)

        // Audio setup
        val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.setStreamVolume(AudioManager.STREAM_ALARM, audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM), 0)

        val alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        ringtone = RingtoneManager.getRingtone(this, alarmUri).apply {
            audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ALARM)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) { // API 28+
                isLooping = true
            }

            play()
        }

        // Vibration setup
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(longArrayOf(0, 1000, 500, 1000), 0)

        // Launch quiz
        val quizIntent = Intent(this, AlarmActivity::class.java)
        quizIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(quizIntent)



        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service destroyed")
        getSharedPreferences("AlarmPrefs", Context.MODE_PRIVATE)
            .edit() {
                putBoolean("alarm_active", false)
            }
        ringtone.stop()
        vibrator.cancel()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    fun stopAlarm() {
        stopForeground(true)
        stopSelf()
    }
}