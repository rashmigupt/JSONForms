package com.example.samplemoneyloji.view.validations

import android.content.Context
import com.example.samplemoneyloji.view.backend.DataSource
import java.util.regex.Matcher
import java.util.regex.Pattern

object Validations {

var nameValid:Boolean=false
    var emailValid:Boolean=false
    var passwordValid:Boolean=false
    var p:Int=1

    fun isValidFields(name : String,email: String,password: String,context:Context): Boolean {
        val list=(DataSource.getInstance(context!!)!!.getForm().fields)
        for (i in list.indices) {


        if( Pattern.compile(list[i].validator[p].value).matcher(name).find()){
          nameValid =true;
        }
           else if(Pattern.compile(list[i].validator[p].value).matcher(email).find()){
                emailValid =true;
            }
           else if(Pattern.compile(list[i].validator[p].value).matcher(password).find()){
                passwordValid =true;
            }
        }
        return emailValid && passwordValid
    }


}
