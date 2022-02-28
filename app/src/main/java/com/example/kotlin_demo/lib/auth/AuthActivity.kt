package com.example.kotlin_demo.lib.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_demo.R
import com.example.kotlin_demo.databinding.ActivityMainBinding
import com.example.kotlin_demo.lib.home.HomeActivity
import com.example.kotlin_demo.utils.*


class AuthActivity : AppCompatActivity(), AuthListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: AuthViewModel
    //private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //To hide Action bar
        supportActionBar?.hide()
        //For MyObserver class
        lifecycle.addObserver(AuthActivityLifeCycleObserver())
        Log.d("MAIN", "Main Activity - onCreate called")

        //viewModel object creation without ViewModelFactory
        //viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        //viewModel object creation with ViewModelFactory
        viewModel = ViewModelProvider(
            this,
            AuthViewModelFactory("variable to be set in view model while creating object of authviewmodel")
        ).get(AuthViewModel::class.java)

        //Creating object for binding
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        //assigning view model to binding
        binding.viewModel = viewModel
        binding.progressBar.hide()

        //To make clear that authListener variable in AuthViewModel is AuthListener Interface
        viewModel.authListener = this
        //To inform binding that owner of lifecycle is MainActivity
        binding.lifecycleOwner = this

        //Creating observer for mutable live data variable in AuthViewModel, 'it' is the observed value
        //viewModel.testVariableLiveData.observe(this, Observer {
        //binding.button.text = it
        //})
    }


    override fun waiting() {
        binding.progressBar.show()
        toast("logging in...")
    }

    override fun success() {
        binding.progressBar.hide()
        toast("successfully logged in")
        intent = Intent(this@AuthActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun fail() {
        binding.progressBar.hide()
        toast("error in logging in")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MAIN", "Main Activity - onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MAIN", "Main Activity - onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN", "Main Activity - onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MAIN", "Main Activity - onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN", "Main Activity - onDestroy called")
    }

}