package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

//        Toast.makeText(this, "Oncreate", Toast.LENGTH_LONG).show()

        submit.setOnClickListener{
            val firstName = first_name_id.text.toString()
            val lastName = last_name_id.text.toString()
            val email = email_id.text.toString()
            val phone = phone_id.text.toString()
            val address = address_id.text.toString()

            val contact = Contact(0, firstName, lastName, email, phone, address)

            ContactDatabase.getInstance(applicationContext).contactDAO().insertContact(contact)


            val intent = Intent(this@AddContactActivity, ContactListActivity::class.java)

//            intent.putExtra("firstName", firstName)
//            intent.putExtra("lastName", lastName)
//            intent.putExtra("email", email)
//            intent.putExtra("phone", phone)
//            intent.putExtra("email", email)
//            intent.putExtra("address", address)


            startActivity(intent)

//            Toast.makeText(this, "Register $firstName", Toast.LENGTH_LONG).show()
        }


    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show()
    }


    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Starts", Toast.LENGTH_SHORT).show()
    }

}
