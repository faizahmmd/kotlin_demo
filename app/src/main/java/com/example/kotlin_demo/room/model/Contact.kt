package com.example.kotlin_demo.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val number: Long,
    val name: String,
    val date: Date
)