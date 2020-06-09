package com.example.samplemoneyloji.model

import android.text.TextUtils
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val VL_Success = "Success"
    val VL_Fail = "Fail"
    val VL_Error = "Error"

    private var data: Any? = null
    private var value: String = String()

    fun setData(model: Any) {
        if (model != null)
            this.data = model
    }

    fun getData(): Any {
        return data!!
    }

    fun setValue(text: String) {
        if (!TextUtils.isEmpty(text))
            this.value = text
    }

    fun getValue(): String {
        return value
    }
}