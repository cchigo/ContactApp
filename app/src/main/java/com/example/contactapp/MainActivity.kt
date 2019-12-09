package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewConfiguration
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.contactapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var  appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setSupportActionBar(toolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)

        fun loadImage(){
            var url ="https://next.json-generator.com/api/json/get/4kMizfloD"

            AndroidNetworking.initialize(this)
            AndroidNetworking.get(url)
                .build()
                .getAsObjectList(Contact::class.java, object:
                    ParsedRequestListener<List<Contact>> {
                    override fun onResponse(response: List<Contact>) {
                        ContactDatabase.addAll(response)
                        RecyclerViewAdapter.notifyDataSetChanged()
                    }

                    override fun onError(anError: ANError) {
                        anError.printStackTrace()
                    }
                })
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }



}
