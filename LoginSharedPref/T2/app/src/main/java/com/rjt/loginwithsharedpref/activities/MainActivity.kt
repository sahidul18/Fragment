package com.rjt.loginwithsharedpref.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rjt.loginwithsharedpref.R
import com.rjt.loginwithsharedpref.fragments.HomeFragment
import com.rjt.loginwithsharedpref.fragments.RegisterFragment
import com.rjt.loginwithsharedpref.helpers.SessionManagement
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var session:SessionManagement = SessionManagement(this)

        init()
    }

    fun init(){
        var session = SessionManagement(this)

        if (!session.isUserLoggedin()){
            var fragment = RegisterFragment()

            var fragmentManager = supportFragmentManager
            var transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container, fragment)
            transaction.commit()
        }else{

            var fragment = HomeFragment()

            var fragmentManager = supportFragmentManager
            var transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container, fragment)
            transaction.commit()

        }

//        var fragment = HomeFragment()
//
//
//
//        var fragmentManager = supportFragmentManager
//        var transaction = fragmentManager.beginTransaction()
//        transaction.add(R.id.fragment_container, fragment)
//        transaction.commit()



    }
}
