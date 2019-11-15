package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        var contactList = ContactDatabase.getInstance(applicationContext).contactDAO().selectContact()

//        contactList.add(Contact("Chisom", "iwowo", "090947623145","chisom@gmail.com", "4 ijeoma street"))
//        contactList.add(Contact("Chisom", "iwowo", "090947623145","chisom@gmail.com", "4 ijeoma street"))
//        contactList.add(Contact("Chisom", "iwowo", "090947623145","chisom@gmail.com", "4 ijeoma street"))
//        contactList.add(Contact("Chisom", "iwowo", "090947623145","chisom@gmail.com", "4 ijeoma street"))
//        contactList.add(Contact("Chisom", "iwowo", "090947623145","chisom@gmail.com", "4 ijeoma street"))
//        contactList.add(Contact("Chisom", "iwowo", "090947623145","chisom@gmail.com", "4 ijeoma street"))
//        contactList.add(Contact("Chisom", "iwowo", "090947623145","chisom@gmail.com", "4 ijeoma street"))


        if(intent != null){

            val firstName = intent.getStringExtra("firstName")
            val lastName = intent.getStringExtra("lastName")
            val phone = intent.getStringExtra("phone")
            val email = intent.getStringExtra("email")
            val address = intent.getStringExtra("address")

//           contactList.add(Contact(firstName, lastName, phone, email, address))

        }




        val recycler: RecyclerView = findViewById(R.id.recycler_view_id)
        recycler.layoutManager = LinearLayoutManager(this)

        recycler.adapter = RecyclerViewAdapter(contactList, object: OnItemClickListener{
            override fun onItemClick(contact: Contact) {
                val intent = Intent(this@ContactListActivity, ProfileActivity::class.java)

                intent.putExtra("firstName", contact.firstName)
                intent.putExtra("lastName", contact.lastName)
                intent.putExtra("email", contact.email)
                intent.putExtra("phone", contact.phone)
                intent.putExtra("address", contact.address)

                startActivity(intent)


            }
        })

        val fragmentManager = supportFragmentManager.beginTransaction()

        fragmentManager.add(R.id.registerFragment, RegisterFragment(), "addContact fragment")

        //contains id
        val btn_newContact = findViewById<View>(R.id.fab_button)

        btn_newContact.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }

//        btn_newContact.setOnClickListener {
//            val change = supportFragmentManager.beginTransaction().apply{
//                replace(R.id.registerFragment, RegisterFragment())
//                    .addToBackStack(null)
//            }
//            change.commit()
//        }



    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Starts", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


}