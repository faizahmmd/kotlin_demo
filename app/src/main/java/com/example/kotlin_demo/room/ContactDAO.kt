package com.example.kotlin_demo.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlin_demo.room.model.Contact

@Dao
interface ContactDAO {
    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM contact")
    fun read(): LiveData<List<Contact>>
}