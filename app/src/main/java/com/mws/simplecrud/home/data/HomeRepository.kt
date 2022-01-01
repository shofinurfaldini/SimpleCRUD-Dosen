package com.mws.simplecrud.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mws.simplecrud.network.ApiClient
import com.mws.simplecrud.network.ApiInterface
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class HomeRepository {

    private var apiInterface : ApiInterface? = null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface :: class.java)
    }

    fun fecthAllStudent():LiveData<List<StudentModel>> {
        val data = MutableLiveData<List<StudentModel>>()

        apiInterface?.fetchAllStudent()?.enqueue(object : Callback <List<StudentModel>>{

            override fun onFailure(call: Call<List<StudentModel>>, t: Throwable) {
                data.value=null
            }

            override fun onResponse(
                call: Call<List<StudentModel>>,
                response: Response<List<StudentModel>>
            ) {
                val res = response.body()

                if (response.code() == 200 && res!=null) {
                    data.value = res
                } else {
                    data.value = null
                }
            }
        })
        return data
    }
}