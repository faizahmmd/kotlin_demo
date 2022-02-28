package com.example.kotlin_demo.retrofit

import com.example.kotlin_demo.retrofit.model.APIResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("/posts")
    suspend fun getResponse(): Response<APIResponseModel>
}