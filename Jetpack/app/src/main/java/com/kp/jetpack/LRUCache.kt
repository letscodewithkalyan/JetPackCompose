package com.kp.jetpack

import android.R

//class LRUCache<K,V>(private val maxSize: Int) {
//    //last parameter true means accessorder
//    //last parameter false means insertionorder default
//    private val cache: LinkedHashMap<K,V> = object : LinkedHashMap<K,V>(maxSize, 0.75f, false){
//        override fun removeEldestEntry(eldest: Map.Entry<K?, V?>?): Boolean {
//            return size > maxSize
//        }
//    }
//
//    fun get(key:K): V?{
//        return cache[key]
//    }
//
//    fun put(key:K, value:V){
//        cache[key] = value
//    }
//
//    fun size(): Int{
//        return cache.size
//    }
//
//    fun remove(key: K){
//        cache.remove(key)
//    }
//
//    fun contains(key: K): Boolean{
//        return cache.containsKey(key)
//    }
//
//    override fun toString(): String {
//        return cache.toString()
//    }
//}


class LRUCache<K,V>(private val  maxSize: Int){
    //0.75 is form factor after this reached cache will be resized
    //true insertion order or accessorder
    val cache: LinkedHashMap<K,V> =
        object : LinkedHashMap<K,V>(maxSize, 0.75f, true){
        override fun removeEldestEntry(eldest: Map.Entry<K?, V?>?): Boolean {
            return  size > maxSize
        }
    }

    fun put(key: K, value: V){
        cache[key] = value
    }

    fun remove(key: K){
        cache.remove(key)
    }

    fun get(key: K): V?{
        return cache[key]
    }

    fun containeKey(key: K): Boolean{
        return cache.containsKey(key)
    }

    override fun toString(): String {
        return cache.toString()
    }
}
fun main() {
    reverseWords("Welcome Kalyan")

    val lruCache = LRUCache<Int, String>(3)

    lruCache.put(1, "One");
    lruCache.put(2, "two");
    lruCache.put(3, "three");

    println(lruCache) //1, 2, 3
    lruCache.get(1)
    println(lruCache) //2,3,1
    lruCache.put(4, "four")
    println(lruCache) //3,1,4

    val arr = intArrayOf(2, 0, 2, 1, 1, 0)
    dutchFlagSort(arr)
    println(arr.joinToString()) // Output: 0, 0, 1, 1, 2, 2
}

//Three pointer technique
fun dutchFlagSort(arr: IntArray){
    var left = 0
    var mid = 0;
    var right = arr.size - 1
    while(mid<= right){
        when(arr[mid]) {
            0 -> {
                //Swap left and mid and increase  both
                arr[left] = arr[mid].also { arr[mid] = arr[left] }
                left++
                mid++
            }

            1 -> {
                mid++
            }

            2 -> {
                //swap right and mid
                arr[mid] = arr[right].also { arr[right] = arr[mid] }
                right--
            }
        }
    }
}

fun reverseWords(str: String){
    var charArray = str.toCharArray()
    var sb = StringBuilder()
    val words = mutableListOf<String>()
    for(char in charArray){
        if(char != ' '){
            sb.append(char)
        }else if(sb.isNotEmpty()){
            words.add(sb.toString());
            sb.clear();
        }
    }
    if (sb.isNotEmpty()) words.add(sb.toString())
    words.reverse();
    println(words.joinToString(" "))
}