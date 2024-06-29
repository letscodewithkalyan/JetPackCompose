package com.kp.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import com.kp.explore.data.User

class FirstActivity : AppCompatActivity() {
    lateinit var handlerTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        var navigateButton = findViewById<Button>(R.id.navigateButton)
        navigateButton.setOnClickListener {
            var secondActivityIntent = Intent(this, SecondActivity::class.java)
            secondActivityIntent.putExtra("data", User("Kalyan", "Pidugu"))
            startActivity(secondActivityIntent);
        }
        var handlerButton = findViewById<Button>(R.id.handlerButton);
        handlerTextView = findViewById(R.id.handlerTextView)

//        var mhandler = Handler(applicationContext.mainLooper)
//        handlerButton.setOnClickListener {
//            var count = 0
//            Thread(Runnable {
//                repeat(10) {
//                    Thread.sleep(1000)
//                    count++
//                    mhandler.post(Runnable {
//                        run {
//                            handlerTextView.text = count.toString()
//                        }
//                    })
//                }
//            }).start()
//        }
        handlerButton.setOnClickListener {
            var count = 0
            Thread(Runnable {
                repeat(10) {
                    Thread.sleep(1000)
                    count++
                    handlerTextView.post {
                        handlerTextView.text = count.toString()
                    }
                }
            }).start()
        }

    }
}