package com.example.samplemoneyloji.view

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.lifecycle.ViewModelProviders
import com.example.samplemoneyloji.R
import com.example.samplemoneyloji.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private var submit: Button? = null
    private lateinit var userViewModel: UserViewModel
    private  var name=""
    private var email=""
    private var password=""
    private var i=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        setContentView(R.layout.activity_main)
        val dynamicFormFragment = DynamicFormFragment()

        supportFragmentManager.beginTransaction().replace(R.id.container, dynamicFormFragment)
            .commit()
        title = getString(R.string.dynamic_form)
        button.addView(submitButton())

        userViewModel._userValidator.observe(this, Observer {
            val nameResult = it ?: return@Observer
            if (nameResult.error != null) {
                 disableSubmitButton(submit!!)
            } else if (nameResult.success != null) {
                 enableSubmitButton(submit!!)
            }
        })
    }

    private fun disableSubmitButton(submit: Button) {
        submit.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorPrimary))
    }

    private fun enableSubmitButton(submit: Button) {
        submit.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorPrimaryDark))
        userViewModel.login(baseContext!!,name,email,password)
    }

    private fun submitButton(): Button {
         submit = Button(baseContext)
        submitButtonParams()
        submit!!.setOnClickListener {
            validateUser()
              }
        return submit!!
    }

    private fun submitButtonParams() {
        val factor = baseContext!!.resources.displayMetrics.density
        val rootPadding = (16 * factor).toInt()
        submit!!.setPadding(rootPadding, rootPadding, rootPadding, rootPadding)
        submit!!.text = getString(R.string.submit)
        submit!!.setBackgroundColor(ContextCompat.getColor(baseContext, R.color.colorPrimary))
        submit!!.setTextColor(ContextCompat.getColor(baseContext, R.color.colorwhite))
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.weight = 1.0f
        params.gravity = Gravity.CENTER
        params.setMargins(30, 0, 30, 5)
        submit!!.layoutParams = params
    }

    private fun validateUser() {
        name=  (((((container[i] as ViewGroup)[i] as ViewGroup)[i] as ViewGroup)[i] as ViewGroup).getChildAt(i) as EditText).text.toString()
        email=(((((container[i] as ViewGroup)[i] as ViewGroup)[1] as ViewGroup)[i] as ViewGroup).getChildAt(i) as EditText).text.toString()
        password=(((((container[i] as ViewGroup)[i] as ViewGroup)[2] as ViewGroup)[i] as ViewGroup).getChildAt(i) as EditText).text.toString()
        userViewModel.userValidator(baseContext!!,name,email,password)

    }
}
