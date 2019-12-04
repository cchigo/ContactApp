package com.example.contactapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
     var name: String? = null

    val args: ProfileFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val firstName = view.findViewById<TextView>(R.id.profile_first_name)
        val lastName = view.findViewById<TextView>(R.id.profile_last_name)


        firstName.text = args.firstName
        lastName.text = args.lastName


        return view
    }
}
