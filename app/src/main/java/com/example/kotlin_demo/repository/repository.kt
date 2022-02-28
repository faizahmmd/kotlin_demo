package com.example.kotlin_demo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_demo.retrofit.RetrofitInterface
import com.example.kotlin_demo.retrofit.model.APIResponseModel
import com.example.kotlin_demo.room.ContactDAO
import com.example.kotlin_demo.room.model.Contact
import com.example.kotlin_demo.utils.Response

class Repository(
    private val contactDAO: ContactDAO,
    private val retrofitInterface: RetrofitInterface
) {
    private val apiResponseMutableLiveData = MutableLiveData<Response<APIResponseModel>>()
    val apiResponseLiveData: LiveData<Response<APIResponseModel>>
        get() {
            return apiResponseMutableLiveData
        }

    suspend fun insertIntoDatabase(contact: Contact) {
        contactDAO.insert(contact)
    }

    suspend fun updateIntoDatabase(contact: Contact) {
        contactDAO.update(contact)
    }

    suspend fun deleteFromDatabase(contact: Contact) {
        contactDAO.delete(contact)
    }

    fun readFromDatabase(): LiveData<List<Contact>> {
        return contactDAO.read()
    }

    suspend fun getResponseApi() {
        try {
            apiResponseMutableLiveData.postValue(Response.Loading())
            val response = retrofitInterface.getResponse()
            if (response?.body() != null) {
                apiResponseMutableLiveData.postValue(Response.Success(response.body()))
            } else {
                apiResponseMutableLiveData.postValue(Response.Error("Something went wrong"))
            }
        } catch (e: Exception) {
            apiResponseMutableLiveData.postValue(Response.Error(e.message.toString()))
        }

    }
}