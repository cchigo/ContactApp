package com.example.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (val contacts: List<Contact>, val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder>() {



    class ContactViewHolder (val view:View) :RecyclerView.ViewHolder(view) {
        lateinit var contactImage: ImageView
        lateinit var firstName: TextView
        lateinit var  lastName: TextView
        lateinit var  contactPhone: TextView

        init {
            contactImage = view.findViewById(R.id.contact_image_id)
            firstName = view.findViewById(R.id.first_name_id)
            lastName = view.findViewById(R.id.last_name_id)
            contactPhone = view.findViewById(R.id.contact_phone_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_row, parent, false)

        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
    //create view

    override fun onBindViewHolder(@NonNull holder:ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.firstName.text = contact.firstName
        holder.lastName.text = contact.lastName
        holder.contactPhone.text = contact.phone
        holder.view.setOnClickListener {
            onItemClickListener.onItemClick(contact)
        }

    }

}


