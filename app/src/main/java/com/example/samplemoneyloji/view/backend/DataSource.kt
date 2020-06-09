package com.example.samplemoneyloji.view.backend

import android.content.Context
import android.content.res.AssetManager
import com.example.samplemoneyloji.Form
import com.google.gson.Gson


class DataSource private constructor(context: Context) {
    private val assetManager: AssetManager = context.assets
    private val gson: Gson = Gson();
    private val FILE_NAME: String = "sampleForm.json"

    companion object {
        private var instance: DataSource? = null
        fun getInstance(context: Context): DataSource? {
            return if (instance == null) DataSource(
                context
            ).also { instance = it } else instance
        }
    }

    fun getForm(): Form {
        return gson.fromJson(assetManager.open(FILE_NAME).reader(), Form::class.java)
    }
}
