package com.rjt.loginwithsharedpref.helpers

import android.content.Context
import android.content.SharedPreferences

class SessionManagement constructor(var context: Context){

    private val FILE_NAEM = "sahrePref"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_USER_LOGGEDIN = "loggedin"

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    init {
        this.sharedPreferences = context.getSharedPreferences(FILE_NAEM, Context.MODE_PRIVATE)
        this.editor = sharedPreferences.edit()
    }

    public fun register(name:String, password:String, email:String){
        editor.putString(name, "")
        editor.putString(password, "")
        editor.putString(email, "")
        editor.putBoolean(KEY_USER_LOGGEDIN, true)

    }

    public fun isUserLoggedin():Boolean{
        return sharedPreferences.getBoolean(KEY_USER_LOGGEDIN, false)
    }

    public fun checkUsernamePassword(email:String, password: String): Boolean {
        if (sharedPreferences.getString(KEY_EMAIL,"").equals(email)
            && sharedPreferences.getString(KEY_PASSWORD,"").equals(password)){
            return true
        }
        return false
    }

    public fun getName():String{
        return sharedPreferences.getString(KEY_NAME,"")
    }


}