package com.kp.viewdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        var registerButton = findViewById<Button>(R.id.registerButton)
        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        var loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}