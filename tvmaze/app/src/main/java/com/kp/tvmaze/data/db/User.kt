package com.kp.tvmaze.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Hint: Use singular for table names (user, role), and not plural (users, roles).
//The plural could lead to some weird table names later (instead of user_has_role, you would have users_have_roles, etc.)
//Table names should be singular
//Column names should be snake_case
@Entity
data class User(
    @PrimaryKey val uid: Double,
    @ColumnInfo(name = "first_name") val firstName:String?,
    @ColumnInfo(name = "last_name") val lastName:String?)
