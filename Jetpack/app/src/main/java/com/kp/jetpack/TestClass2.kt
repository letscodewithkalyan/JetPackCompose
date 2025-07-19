package com.kp.jetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TestClass2 {
    lateinit var name: String
    val name2: String by lazy { "Kalyan" }
    fun test(){
        if(this::name.isInitialized){

        }
    }
}
//
//fun  main(){
//    Name({println("XYZ function")})
//}
//
//inline fun Name(xyz:() -> Unit){
//    println("Name function")
//    xyz()
//}

fun main(){
  println("Start")
    funNames({println("abc")}) { println("Fun Names abc");}
    println("end")
}

inline fun funNames(xyz: () -> Unit, noinline  abc: () -> Unit){
    xyz()
   abc()
}


class JavaClass{
    @JvmField
    var name = "Kalyan";
    var age = 32;
}

class  MainViewModel(): ViewModel(){
    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                loadProfile()
            }
            //updateUI
        }
    }

    suspend fun loadProfile(){

    }
}