package com.rjt.loginwithsharedpref.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.rjt.loginwithsharedpref.R
import com.rjt.loginwithsharedpref.helpers.SessionManagement
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        var session = SessionManagement(view.context)

        view.button.setOnClickListener(){
            var pass = view.edit_text_password_login.text.toString()
            var email = view.edit_text_email_login.text.toString()

            if (session.checkUsernamePassword( email,pass)){
                var fragment = HomeFragment()
                var fragmentManager = activity?.supportFragmentManager
                var transaction = fragmentManager?.beginTransaction()
                var bundle = Bundle()

                transaction?.replace(R.id.fragment_container, fragment)
                transaction?.commit()
            }else{
                Toast.makeText(activity,"failed", Toast.LENGTH_SHORT).show()
            }
        }

        view.text_view_newuser_login.setOnClickListener(){
            var fragment = RegisterFragment()
            var fragmentManager = activity?.supportFragmentManager
            var transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment_container, fragment)
            transaction?.commit()
        }

        return view
    }

}
