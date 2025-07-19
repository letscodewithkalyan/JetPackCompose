package com.kp.jetpack

import android.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext


fun<T> debounce(waitTime: Long, scope: CoroutineScope, destinationFunction: (T) -> Unit): (T) -> Unit{
    var doubounceJob: Job? = null
    //returning lambda function
    return { param: T ->
        doubounceJob?.cancel()
        doubounceJob = scope.launch {
            delay(waitTime)
            destinationFunction(param)
        }
    }
}

fun<T> throttle(waitTime: Long, scope: CoroutineScope, destinationFunction: (T) -> Unit): (T) -> Unit{
    var isThrottled = false
    return { param: T ->
        if (!isThrottled) {
            isThrottled = true
            scope.launch {
                    destinationFunction(param);
                    delay(waitTime)
                    isThrottled = false
                }
        }
    }
}

fun main() = runBlocking {
    val debounceSearch = debounce<String>(300, this) { param ->
        //The function need to be executed after sometime
        println("$param")
    }

    debounceSearch("hi")
    debounceSearch("Hello")
    //CoroutineScope(Dispatchers.Main)
    val thottleClick = throttle<String>(300,this) { param ->
        println(param)
    }
    thottleClick("hi")
    thottleClick("Hello")

}

