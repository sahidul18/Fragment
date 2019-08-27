package com.rjt.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rjt.myapplication.fragments.FirstFragment
import com.rjt.myapplication.fragments.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    fun init(){
        var fragment = FirstFragment()

        var fragmentManager = supportFragmentManager

        var transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()
    }


    override fun onFragmentInteraction(name:String){
        var fragment = SecondFragment()
        var fragmentManager = supportFragmentManager
        var transaction = fragmentManager.beginTransaction()

        var bundle = Bundle()
        var name = bundle.putString("DATA", name)
        fragment.arguments = bundle

        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

}
