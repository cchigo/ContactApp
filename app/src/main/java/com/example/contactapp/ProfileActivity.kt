package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.activity_contact_details.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        Toast.makeText(this, "we are here", Toast.LENGTH_LONG).show()

        if(intent != null){

            val firstName = intent.getStringExtra("firstName")
            val lastName = intent.getStringExtra("lastName")
            val phone = intent.getStringExtra("phone")
            val email = intent.getStringExtra("email")
            val address = intent.getStringExtra("address")

            profile_first_name.text = firstName
            profile_last_name.text = lastName
            profile_email.text = email
            profile_body_first_name.text = firstName
            profile_body_last_name.text = lastName
            profile_address.text = address
            profile_phone.text = phone
        }
    }




}