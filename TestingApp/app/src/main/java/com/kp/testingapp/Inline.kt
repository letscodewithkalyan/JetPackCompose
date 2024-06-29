package com.kp.testingapp

import java.util.Date

fun main() {
    Directions.NORTH.degress
}

fun guide() {
    println("guide start")
    teach({ println("abc"); }, { println("xyz") })
    println("guide end")
}

inline fun teach(crossinline abc: () -> Unit,  noinline xyz: () -> Unit) {
    abc()
    xyz()
}

data class Session(val name:String, @JvmField val sessionID: String)
data class Student @JvmOverloads constructor(val firstName:String, val date: Date = Date())

object AppUtils{
    fun getName(){}
    @JvmStatic
    fun install(){ }
}

enum class Directions(val degress: Int){
SOUTH(300),NORTH(200)
}