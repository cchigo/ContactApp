package com.example.contactapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactapp.Contact
import com.example.contactapp.ContactDatabase

class MyViewModel : ViewModel() {
    private val contact: MutableLiveData<List<Contact>> by lazy {
        MutableLiveData<List<Contact>>().also {
            loadContacts()
        }
    }

    fun getContacts(context: Context): LiveData<List<Contact>> {
        return ContactDatabase.getInstance(context).contactDAO().selectContact()
    }
    fun setContact(contact: Contact, context: Context){
        return ContactDatabase.getInstance(context).contactDAO().insertContact(contact)

    }

    private fun loadContacts() {
         // Do an asynchronous operation to fetch users.
    }
    fun deleteContact (contact: Contact, context: Context){
        return ContactDatabase.getInstance(context).contactDAO().deleteContact(contact)

    }
}