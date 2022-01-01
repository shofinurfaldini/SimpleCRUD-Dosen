package com.mws.simplecrud.network


import com.mws.simplecrud.home.data.StudentModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("student")
    fun fetchAllStudent(): Call<List<StudentModel>>
}