package com.example.kotlin_demo.lib.auth

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_demo.utils.AuthListener

class AuthViewModel(testVariableFromActivity: String?) : ViewModel() {
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null
    var testVariableViewModelFactory: String? = testVariableFromActivity
    var testVariableLiveData = MutableLiveData<String>("LOGIN")

    init {
        Log.d(
            "Test",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX called init in AuthViewModel XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
        )
    }
    fun onLoginClick() {
        Log.d(
            "Test",
            "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX $testVariableViewModelFactory XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
        )
        authListener?.waiting()
        testVariableLiveData.value = "WAIT"
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                authListener?.fail()
                testVariableLiveData.value = "LOGIN"
            } else {
                authListener?.success()
                testVariableLiveData.value = "LOGIN"
            }
        }, 3000)

    }

}