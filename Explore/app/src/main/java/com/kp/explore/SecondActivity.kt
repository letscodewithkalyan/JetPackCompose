package com.kp.explore

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kp.explore.data.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val userData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("data", User::class.java)
        } else {
            intent.getParcelableExtra<User>("data")
        }
    }

    val myname:String ="SecondActivity"
}