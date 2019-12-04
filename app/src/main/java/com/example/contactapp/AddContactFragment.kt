package com.example.contactapp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_contact.*


/**
 * A simple [Fragment] subclass.
 */
class AddContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_add_contact, container, false)

        var submit = view.findViewById<Button>(R.id.submit)

        submit.setOnClickListener{
            val firstName = first_name_id.text.toString()
            val lastName = last_name_id.text.toString()
            val email = email_id.text.toString()
            val phone = phone_id.text.toString()
            val address = address_id.text.toString()

            val contact = Contact(0, firstName, lastName, email, phone, address)

            ContactDatabase.getInstance(context!!).contactDAO().insertContact(contact)


           this.findNavController().navigateUp()

        }

        return view
    }
}


