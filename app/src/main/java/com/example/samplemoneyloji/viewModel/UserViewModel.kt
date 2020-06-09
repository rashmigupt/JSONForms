package com.example.samplemoneyloji.viewModel

import android.content.Context
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.example.samplemoneyloji.model.BaseViewModel
import com.example.samplemoneyloji.model.ValidationResult
import com.example.samplemoneyloji.view.backend.DataSource
import com.example.samplemoneyloji.view.services.APICall
import com.example.samplemoneyloji.view.validations.Validations

class UserViewModel : BaseViewModel() {
    val _userValidator = MutableLiveData<ValidationResult>()
    val _submitValidator = MutableLiveData<ValidationResult>()


    fun userValidator(context:Context,name:String,email:String,password:String) {
        if (!TextUtils.isEmpty(name)) {
            if (Validations.isValidFields(name,email,password,context!!))
            {
                _userValidator.value = ValidationResult(VL_Success)}
            else
                _userValidator.value = ValidationResult(null, VL_Error)
        } else
            _userValidator.value = ValidationResult(null, VL_Error)
    }

    fun login(context:Context,name:String,email:String,password:String) {
        var arrList: ArrayList<String>? = ArrayList()
        arrList!!.add(name)
        arrList!!.add(email)
        arrList!!.add(password)
        APICall.signIn(DataSource.getInstance(context!!)!!.getForm().fields, arrList)
    }
}