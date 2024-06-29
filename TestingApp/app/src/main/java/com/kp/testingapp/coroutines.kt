package com.kp.testingapp

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

suspend  fun main() = supervisorScope{
    try {
        var first = async { firstTask() }
        var second = async { secondTask() }
        println("run")
        first.await()
        println("after")
    }
    catch (ex: Exception){
        println("exception caught")
        println(ex)
    }
}

suspend fun firstTask(){
    delay(1000)
    println("First Task")
}

suspend fun secondTask(){
    delay(500)
    throw Exception("Test Exception")
    println("Second Task")
}