package com.kp.explore.data

import android.os.Parcel
import android.os.Parcelable

data class User(val firstName: String, val secondName:String) : Parcelable{
    constructor(parcel: Parcel) : this(
        firstName = parcel.readString() ?: "",
        secondName = parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(secondName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<User> {
            override fun createFromParcel(parcel: Parcel) = User(parcel)
            override fun newArray(size: Int) = arrayOfNulls<User>(size)
        }
    }
}

class CompanionTest{
    companion object config {
        const val MAX_SLOTS = 10
    }
}
fun test(){
    val slots = CompanionTest.MAX_SLOTS
    val slots2 = CompanionTest.config.MAX_SLOTS
}

class ObjectTest{
    object config{
        const val MAX_SLOTS = 10
    }
}

fun main(){
    val slots3 = ObjectTest.config.MAX_SLOTS
    val added = 2 addvalue 3
    creatUser("admin", "user", username = "kalyan", age = 42)

    val users = listOf(CurrentUser("1","Kalyan", true))
    val (mentor, notMentors) = users.partition { it.isMentor }
}

infix fun Int.addvalue(value: Int): Int = this + value

fun creatUser(vararg roles:String, username: String, age: Int){ }

data class CurrentUser(val id:String, val name: String, val isMentor: Boolean)

