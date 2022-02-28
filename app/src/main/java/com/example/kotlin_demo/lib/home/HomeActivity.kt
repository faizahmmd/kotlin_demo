package com.example.kotlin_demo.lib.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_demo.R
import com.example.kotlin_demo.databinding.ActivityHomeBinding
import com.example.kotlin_demo.repository.Repository
import com.example.kotlin_demo.retrofit.RetrofitHelper
import com.example.kotlin_demo.retrofit.RetrofitInterface
import com.example.kotlin_demo.room.ContactDAO
import com.example.kotlin_demo.room.ContactDatabase
import com.example.kotlin_demo.room.model.Contact
import com.example.kotlin_demo.utils.Response
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class HomeActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var dataBase: ContactDatabase
    private lateinit var repository: Repository
    private lateinit var contactDAO: ContactDAO
    private lateinit var retrofitInterface: RetrofitInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactDAO = ContactDatabase.getDatabase(applicationContext).contactDao()
        retrofitInterface =
            RetrofitHelper.getRetrofitInstance().create(RetrofitInterface::class.java)
        repository = Repository(contactDAO, retrofitInterface)
        homeViewModel =
            ViewModelProvider(this, HomeViewModelFactory(repository)).get(HomeViewModel::class.java)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeBinding.homeViewModel = homeViewModel
        homeBinding.lifecycleOwner = this

        //For LifeCycleObserver
        lifecycle.addObserver(HomeActivityLifeCycleObserver())

        //For database
        //dataBase = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contactDatabase").build()
        //For singleton
        dataBase = ContactDatabase.getDatabase(applicationContext)

        GlobalScope.launch {
            dataBase.contactDao().insert(Contact(0, 9645396284, "Faiz Ahammed", Date()))
        }
        homeBinding.buttonDataBase.setOnClickListener {
            homeViewModel.showLoading()
            homeViewModel.readFromDatabase().observe(this) {
                homeViewModel.hideLoading()
                Log.d("data", it.toString())
            }
        }
        homeBinding.buttonAPI.setOnClickListener {
            GlobalScope.launch {
                homeViewModel.getResponseApi()
            }
        }
        homeViewModel.screenLoading.observe(this) {
            if (it) {
                homeBinding.progressBar.visibility = View.VISIBLE
            } else {
                homeBinding.progressBar.visibility = View.GONE
            }
        }
        homeViewModel.responseAPILiveData.observe(this) {
            when (it) {
                is Response.Loading -> {
                    homeViewModel.showLoading()
                }
                is Response.Success -> {
                    homeViewModel.hideLoading()
                    Log.d("APIResponse", it.data.toString())
                }
                is Response.Error -> {
                    homeViewModel.hideLoading()
                    Log.d("APIResponse", it.errorMessage.toString())
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}