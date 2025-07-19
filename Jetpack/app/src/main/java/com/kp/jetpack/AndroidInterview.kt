package com.kp.jetpack

fun main(){
    countVowelsWithLoop("test vowels exist in the string");
}

fun countVowelsWithLoop(input: String){
    val vowels = "aeiouAEIOU";
    val charArray = input.toCharArray()
    val mutableMap = mutableMapOf<Char, Int>()
    for(char in charArray){
        if(vowels.contains(char)){
            mutableMap[char] = mutableMap.getOrDefault(char, 0) + 1
        }
    }
    for ((key,value) in mutableMap){
        println("Key $key repeatedtimes $value")
    }
}

fun checkDuplicateChars(str: String){
    val charset = str.toCharArray()
    val countMap = mutableMapOf<Char, Int>()
    for(char in charset){
        countMap[char] = countMap.getOrDefault(char, 0) + 1
    }
    for ((key, value) in countMap){
        if(value > 2){
            println("${key} repeated ${value} times")
        }
    }
}

//Duplicates in int array
fun findDuplicatesArray(arr: IntArray){
    val countMap = mutableMapOf<Int, Int>()
    for (num in arr){
        countMap[num] = countMap.getOrDefault(num,0) + 1
    }
    for((key,value) in countMap){
        if(value > 2){
            println("${key} repeated ${value} times")
        }
    }
}