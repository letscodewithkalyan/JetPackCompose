package com.kp.explore

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

class LocalNotificationAcitivity : AppCompatActivity() {
    lateinit var titleText: TextInputEditText
    lateinit var descriptionText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_notification_acitivity)
        titleText = findViewById(R.id.title_text)
        descriptionText = findViewById(R.id.description_text)
        var sendButton = findViewById<Button>(R.id.sendButton)
        createNotificationChannel();
        sendButton.setOnClickListener {
            requestNotificationPermission();
            sendNotification();
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "MYID", "Kalyan", NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Kalyan test notifications"
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /**
     * Requests notification permission if it's not granted.
     * Shows a toast message indicating the permission status.
     */
    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            when {
                ContextCompat.checkSelfPermission(
                    this, permission
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // Action to take when permission is already granted
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show()
                }
                shouldShowRequestPermissionRationale(permission) -> {
                    // Action to take when permission was denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show()
                }
                else -> {
                    // Request permission
                    requestPermissionLauncher.launch(permission)
                }
            }
        } else {
            // Device does not support required permission
            Toast.makeText(this, "No required permission", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * An ActivityResultLauncher for requesting notification permission.
     * It logs whether the user granted or denied permission.
     */
    private var requestPermissionLauncher: ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (!isGranted) {
                Log.d("POST_NOTIFICATION_PERMISSION", "USER DENIED PERMISSION")
            } else {
                Log.d("POST_NOTIFICATION_PERMISSION", "USER GRANTED PERMISSION")
            }
        }

    fun sendNotification() {
        var builder = NotificationCompat.Builder(this, "MYID")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(titleText.text)
            .setContentText(descriptionText.text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // Display the notification
        notificationManager.notify(1, builder.build())
    }

}