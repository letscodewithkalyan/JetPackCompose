package com.kp.jetpack

import android.R

open class TestClass(name: String) {
    companion object Campa{
        const val text = "Just check";
    }
    constructor(age: Int):this(""){
        println("First constructor");
    }
    constructor(test: String, second: String): this(""){
        println("Second constructor");
    }
    init {
        println("first init")
    }
}

fun main(){
    val funClass = Success();
    val test = TestClass("test", "second")
    TestClass.text
    TestClass.Campa.text

    val anonymous = object {
       val test = "yest"
    }

    var name = object : TestClass("name"){

    }
    printClass(10)
//    val pair = Pair("Kalyan", 30)
//    val triple = Triple("Kalyan", 30, "Test")
//    var person = Person("Kalyan", "Pidugu")
//    var (first, second) = person
//    val names = listOf("kalyan", "pidugu")

//    val namesSet = setOf("kalyan","kalyan", "pidugu")
//
//    for (name1 in namesSet){
//        println(name1)
//    }
    val numbersList = listOf(1,2,3,4)
    val set = setOf(1,2,3,4)
    var mul =  set.map { it * 2 }
    println(numbersList)
    println(mul)

    var person = object {
       var firstName= "kalyan"
        var age = 32
    }


    var expression1 = person?.let {
        "Name: ${it.firstName}, Age: ${it.age}"
    }
    println(expression1)

    var expression2 = person?.run {
        "Name: $firstName, Age: $age"
    }
    println(expression2)


    with(person) {
        //no null check
        println(firstName)
        println(age)
    }

    val person2 = Person("K","P").apply {
        firstname = "Kalyan"
        secondname = "Pidugu"
    }

    person = person.also {
        println("Logging person: $it")
    }
}

val printName = {firstname: String -> {println(firstname)}};

data class Person(var firstname: String, var secondname: String)

val printClass = {x: Int ->  println(x*x) }

enum class Directions(degress: Int){
    SOUTH(0){
        override fun doSomething() {
            TODO("Not yet implemented")
        }
    },
    NORTH(90){
        override fun doSomething() {
            TODO("Not yet implemented")
        }
    };
    abstract fun doSomething();
}

sealed class Result()

class Success(): Result(){
    val message: String?
    var result: String? = null
    init {
        message = null
        result.toString()
    }
}

interface MainPresenterView{
    fun updateName(name: String)
}

