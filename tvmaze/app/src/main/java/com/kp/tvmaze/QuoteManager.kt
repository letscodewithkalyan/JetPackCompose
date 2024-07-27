package com.kp.tvmaze

import android.content.Context
import com.google.gson.Gson
import com.kp.tvmaze.data.Quote
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class QuoteManager @Inject constructor(@ApplicationContext private val context: Context) {
    fun getQuotesList(fileName: String): Array<Quote>{
        val inputStream = context.assets.open(fileName)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        return Gson().fromJson(String(buffer, Charsets.UTF_8), Array<Quote>::class.java)
    }
}