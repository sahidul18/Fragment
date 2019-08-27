package com.rjt.loginwithsharedpref.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rjt.loginwithsharedpref.R
import com.rjt.loginwithsharedpref.helpers.SessionManagement
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.fragment_register.view.editText

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        var session = SessionManagement(view.context)

        view.button2.setOnClickListener{
            var name = editText.text.toString()
            var email = editText2.text.toString()
            var pass = editText3.text.toString()

            session.register(name, pass, email)
            var fragment = LoginFragment()
            var fragmentManager = activity?.supportFragmentManager
            var transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)
            transaction?.commit()
        }



        return view
    }

}
