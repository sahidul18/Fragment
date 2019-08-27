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
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        var session = SessionManagement(this.context!!)

        view.text_view_home.text = "Welcome ${session.getName()}"

        return view
    }



}
