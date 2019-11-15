package com.example.contactapp

import androidx.room.*

@Dao
interface ContactDao {

    @Query ("SELECT * FROM contacts")
    fun selectContact():List<Contact>

    @Insert
    fun insertContact(contact:Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

}