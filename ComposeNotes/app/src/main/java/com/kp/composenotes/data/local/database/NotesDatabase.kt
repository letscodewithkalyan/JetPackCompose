package com.kp.composenotes.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kp.composenotes.data.database.NoteDao
import com.kp.composenotes.data.database.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NotesDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}