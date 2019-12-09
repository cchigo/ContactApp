package com.example.contactapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 2)
abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDAO(): ContactDao

    companion object {
        private var instance : ContactDatabase? = null
        fun getInstance(context: Context): ContactDatabase{
          if (instance == null){

              instance = Room.databaseBuilder(context, ContactDatabase::class.java, "contacts")
                        .allowMainThreadQueries()
                        .build()
              return instance!!



          }else{
              return instance!!
          }
        }
    }
}