package com.kp.testingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val name:String by lazy { "" }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickButton = findViewById<Button>(R.id.clickButton)
        clickButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                    coroutineScope {
                        firstTask()
                        secondTask()
                        println("task completed")
                    }
                } catch (ex: Exception) {
                    println(ex)
                }
            }
        }
    }

    suspend fun firstTask() {
        delay(1000)
        println("First Task")
    }

    suspend fun secondTask() {
        delay(500)
        throw Exception("exception")
        println("Second Task")
    }
}