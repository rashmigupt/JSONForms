package com.example.samplemoneyloji.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.samplemoneyloji.view.backend.DataSource

class DynamicFormFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = JsonFormBuilder(context!!, DataSource.getInstance(context!!)!!.getForm()).build()
        return view

    }


}
