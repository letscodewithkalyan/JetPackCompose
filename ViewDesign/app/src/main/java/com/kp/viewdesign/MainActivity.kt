package com.kp.viewdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var layout = findViewById<LinearLayout>(R.id.firstView)
        layout.setOnClickListener {
            startActivity(Intent(this, LaunchActivity::class.java))
        }
    }
}