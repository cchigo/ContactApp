package com.example.contactapp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.contactapp.databinding.AddContactFragmentBinding
import com.example.contactapp.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.fragment_add_contact.*


/**
 * A simple [Fragment] subclass.
 */
class AddContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //var view = inflater.inflate(R.layout.fragment_add_contact, container, false)

        var binding = AddContactFragmentBinding.inflate(inflater, container, false)
        val model = ViewModelProviders.of(this)[MyViewModel::class.java]

        //var submit = view.findViewById<Button>(R.id.submit)

        binding.submit.setOnClickListener{
            var firstName = binding.firstNameId.text.toString()
            var lastName = binding.lastNameId.text.toString()
            var email = binding.emailId.text.toString()
            var phone = binding.phoneId.text.toString()
            var address = binding.addressId.text.toString()

            val contact = Contact(0, firstName, lastName, email, phone, address)

            //ContactDatabase.getInstance(context!!).contactDAO().insertContact(contact)

            model.setContact(contact,context!!)
           this.findNavController().navigateUp()

        }

        return binding.root
    }
}


