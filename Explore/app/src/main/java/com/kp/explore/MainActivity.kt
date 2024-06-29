package com.kp.explore

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var parcebleButton = findViewById<Button>(R.id.parcebleButton);
        parcebleButton.setOnClickListener {
            var firstActivity = Intent(this,FirstActivity::class.java)
            startActivity(firstActivity);
        }
        var notificationsButton = findViewById<Button>(R.id.notificationsButton)
        notificationsButton.setOnClickListener {
            var notificationAcitivity = Intent(this, LocalNotificationAcitivity::class.java)
            startActivity(notificationAcitivity)
        }
        var contactsButton = findViewById<Button>(R.id.contanctsButton)
        contactsButton.setOnClickListener {
            var contactsActivity = Intent(this, ContactsActivity::class.java)
            startActivity(contactsActivity)
        }
        var pushButton = findViewById<Button>(R.id.pushNotificationsButton)
        pushButton.setOnClickListener {
            var pushActivity = Intent(this,PushNotificationActivity::class.java)
            startActivity(pushActivity)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("explore",newConfig.toString())
    }
}