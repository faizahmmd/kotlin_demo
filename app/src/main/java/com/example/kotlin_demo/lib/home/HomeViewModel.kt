package com.example.kotlin_demo.lib.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_demo.repository.Repository
import com.example.kotlin_demo.retrofit.model.APIResponseModel
import com.example.kotlin_demo.room.model.Contact
import com.example.kotlin_demo.utils.Response

class HomeViewModel(private val repository: Repository) : ViewModel() {
    var screenLoading = MutableLiveData<Boolean>(false)
    val responseAPILiveData: LiveData<Response<APIResponseModel>>
        get() {
            return repository.apiResponseLiveData
        }

    fun showLoading() {
        screenLoading.postValue(true)
    }

    fun hideLoading() {
        screenLoading.postValue(false)
    }

    suspend fun getResponseApi() {
        repository.getResponseApi()
    }

    fun readFromDatabase(): LiveData<List<Contact>> {
        return repository.readFromDatabase()
    }
}