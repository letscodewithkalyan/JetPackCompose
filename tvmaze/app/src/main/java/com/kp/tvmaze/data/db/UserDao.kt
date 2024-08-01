package com.kp.tvmaze.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    //CRUD
    @Insert
    fun insertAll(vararg users:User)

    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Delete
    fun delete(user: User)

    //Some examples of complex operations
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User
}