package com.example.kotlin_demo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlin_demo.room.model.Contact

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null
        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                synchronized(true) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        ContactDatabase::class.java,
                        "contactDatabase"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}