package com.chacha.financeapp.core.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.chacha.financeapp.R
import com.chacha.financeapp.core.presentation.activity.MainActivity

class MessageService {
    @RequiresApi(Build.VERSION_CODES.M)
    private fun displayNotification(context: Context, title: String, message: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name =  context.resources.getString(R.string.default_notification_channel_id)
            val descriptionText = context.resources.getString(R.string.fcm_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(
                context.resources.getString(R.string.default_notification_channel_id),
                name,
                importance
            ).apply {
                description = descriptionText
            }

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notificationBuilder = NotificationCompat.Builder(
            context,
            context.resources.getString(R.string.default_notification_channel_id)
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setOnlyAlertOnce(true)

        with(NotificationManagerCompat.from(context)) {
            notify(1, notificationBuilder.build())
        }
    }
}