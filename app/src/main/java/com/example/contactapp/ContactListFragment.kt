package com.example.contactapp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 */
class ContactListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_contact_list, container, false)

        var contactList = ContactDatabase.getInstance(context!!).contactDAO().selectContact()

        val recycler: RecyclerView = view.findViewById(R.id.recycler_view_id)
        recycler.layoutManager = LinearLayoutManager(context)

        recycler.adapter = RecyclerViewAdapter(contactList, object: OnItemClickListener{
            override fun onItemClick(contact: Contact) {
//                val intent = Intent(this@ContactListActivity, ProfileActivity::class.java)
//
//                intent.putExtra("firstName", contact.firstName)
//                intent.putExtra("lastName", contact.lastName)
//                intent.putExtra("email", contact.email)
//                intent.putExtra("phone", contact.phone)
//                intent.putExtra("address", contact.address)
//
//                startActivity(intent)
                val action = ContactListFragmentDirections.actionContactListFragmentToProfileFragment(contact.firstName!!, contact.lastName!!)
                findNavController().navigate(action)

            }
        })





        //contains id
        val btn_newContact = view.findViewById<View>(R.id.fab_button)

        btn_newContact.setOnClickListener {
            findNavController().navigate(R.id.action_contactListFragment_to_addContactFragment)

        }

        return view
    }



}
