package com.example.contactapp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.FragmentContactListBinding
import com.example.contactapp.databinding.FragmentProfileBinding
import com.example.contactapp.viewmodel.MyViewModel


/**
 * A simple [Fragment] subclass.
 */
class ContactListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentContactListBinding.inflate(inflater, container, false)

        val model = ViewModelProviders.of(this)[MyViewModel::class.java]

        val recyclerView = binding.recyclerViewId

        recyclerView.layoutManager = LinearLayoutManager(context)

        var adapter = RecyclerViewAdapter(object :OnItemClickListener{

            override fun onItemClick(contact: Contact){
                val action = ContactListFragmentDirections.actionContactListFragmentToProfileFragment(contact)

                findNavController().navigate(action)
            }
        } , model.apply {

        })
        recyclerView.adapter = adapter

        model.getContacts(context!!).observe(this, Observer <List<Contact>>{ contacts ->

            contacts?.let {
                adapter.contacts = contacts

                adapter.notifyDataSetChanged()


        } })


        binding.fabButton.setOnClickListener {
            findNavController().navigate(R.id.action_contactListFragment_to_addContactFragment)
        }

        return binding.root
    }
}
