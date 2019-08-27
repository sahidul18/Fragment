package com.rjt.loginwithsharedpref.helpers

import android.content.Context
import android.content.SharedPreferences

class SessionManagement ( context: Context){

    private val FILE_NAEM = "sahrePref"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_USER_LOGGEDIN = "loggedin"


   lateinit var sharedPref:SharedPreferences
    lateinit var editor: SharedPreferences.Editor

init {

    this.sharedPref = context.getSharedPreferences(FILE_NAEM, Context.MODE_PRIVATE)
     this.editor = sharedPref.edit()
}

    public fun register(name:String, password:String, email:String){
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_PASSWORD, password)
        editor.putString(KEY_EMAIL, email)
        editor.putBoolean(KEY_USER_LOGGEDIN, true)
        editor.commit()

    }

    public fun isUserLoggedin():Boolean{
        return sharedPref.getBoolean(KEY_USER_LOGGEDIN, false)
    }

    public fun checkUsernamePassword(email:String, password: String): Boolean {
        if (sharedPref.getString(KEY_EMAIL,"").equals(email)
            && sharedPref.getString(KEY_PASSWORD,"").equals(password)){
            return true
        }
        return false
    }

    public fun getName():String{
        return sharedPref.getString(KEY_NAME,"")
    }


}