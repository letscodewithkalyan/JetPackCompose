package com.kp.jetpack

//fun main(){
////    println(reverseString("Hello, Kotlin!"))
////    println(isPalindrome("CHC"))
////    println(checkDuplicateChars("Hello, Kotlin!"))
////    println(numberPalindrome(56765))
//    fizBuzz();
//}

//Two pointer technique
//First pointer one at start second at end
fun reverseString(str: String): String {
    //Make it char array
    val charSet = str.toCharArray()
    var first = 0;
    var last = charSet.count() - 1;
    //Swap characters
    while (first < last){
        val temp = charSet[first];
        charSet[first] = charSet[last];
        charSet[last] = temp;
        first++
        last--
    }
    return charSet.concatToString()
}

//two pointer
fun isPalindrome(str: String): Boolean {
    val charset = str.toCharArray();
    var first = 0;
    var last = charset.count() - 1
    while (first<last){
        if(charset[first] != charset[last]){
            return false
        }
        first++;
        last--;
    }
    return true;
}


fun main(){
    val arrival = intArrayOf(900, 940, 950, 1100, 1500, 1800)
    val departure = intArrayOf(910, 1200, 1120, 1130, 1900, 2000)

    val result = findMinPlatforms(arrival, departure)
    println("Minimum platforms needed: $result")

    val resultSum = findSumIndexInArray(intArrayOf(1,4,5,8,10), 9)
    if( resultSum != null)
        println("Indexes are ${resultSum.first} and ${resultSum.second}" )
    else
        println("Not found")
}
//Two pointer techniqiue
//minimum number of platforms needed at a bus stop
fun findMinPlatforms(arrival: IntArray, departure: IntArray)
            : Int{
    val size = arrival.size
    arrival.sort()
    departure.sort()
    var maxPlatforms = 0
    var platforms = 0
    var i = 0
    var j = 0
    while(i<size && j <size){
      if(arrival[i] <= departure[j] ){
          platforms++
          i++;
          maxPlatforms= maxOf(platforms, maxPlatforms)
      }else{
          j++
          platforms--
      }
    }
   return maxPlatforms
}
//Check suppllied sum exist in the array
//assume array is sorted
fun findSumInArray(arr: IntArray, sum: Int){
    var start = 0;
    var end = arr.size - 1;
    while (start < end){
        val positionSum = arr[start] + arr [end]
        when {
            positionSum < sum -> start ++
            positionSum > sum -> end --
            positionSum == sum ->
                {println("positions are $start $end"); break; }
        }
    }
}

//Array no need to be sorted,
//ContainsKey takes time
fun findSumIndexInArray(array: IntArray, sum: Int): Pair<Int, Int>?{
    var seen = mutableMapOf<Int, Int>();
    for ((index, value) in array.withIndex()){
        val diff = sum - value
        if(seen.containsKey(diff)){
            return Pair(seen[diff]!!, index);
        }
        //We are storing value as ket because
        //Search Key is faster in HashMap
        seen[value] = index;
    }
    return null;
}

fun numberPalindrome(number: Int){
    var num = number  // create a mutable copy
    var reverseNum = 0;
    while (num > 0){
        val digit = num % 10;
        reverseNum = reverseNum * 10 + digit;
        num = num/10;
    }
    if(reverseNum == number){
        println("$reverseNum is palindrome");
    }else{
        println("$reverseNum is palindrome");
    }
}

fun minMaxArray(arr: IntArray){
    var min = arr[0]
    var max = arr[0]
    for (num in arr){
        if(num > max)  max = num
        if(num < min) min = num
    }
}

fun fizBuzz(){
    for (i in 1..100){
        when {
            i % 15 == 0 -> println("FizzBuzz")
            i % 5 == 0 -> println("Fizz")
            i % 3 == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}