package com.example.contactapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    @ColumnInfo(name = "fname") //changes the first name col to fname
    val firstName: String?,
    val lastName: String?,
    val phone: String?,
    val email: String?,
    val address: String? ){
}
