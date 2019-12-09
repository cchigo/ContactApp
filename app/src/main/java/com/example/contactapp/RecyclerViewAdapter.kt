package com.example.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ContactRowBinding
import com.example.contactapp.databinding.FragmentProfileBinding
import com.example.contactapp.viewmodel.MyViewModel

class RecyclerViewAdapter ( val onItemClickListener: OnItemClickListener, val model: MyViewModel): RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder>() {

    var contacts : List<Contact> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {



        val layoutInflater=LayoutInflater.from(parent.context)

        val binding = ContactRowBinding.inflate(layoutInflater, parent, false)

        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
    //create view

    override fun onBindViewHolder(@NonNull holder:ContactViewHolder, position: Int) {
        val contact = contacts.get(position)
        holder.bind(contact, onItemClickListener)



        holder.binding.deleteContactId.setOnClickListener {


            model.deleteContact(contact,holder.binding.deleteContactId.context)

        }

    }


    class ContactViewHolder(var binding: ContactRowBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(contact:Contact, onItemClickListener: OnItemClickListener) {
            binding.contact = contact
            binding.root.setOnClickListener {
                onItemClickListener.onItemClick(contact)
            }
            binding.executePendingBindings()
        }
    }

}


