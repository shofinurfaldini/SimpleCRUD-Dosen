package com.mws.simplecrud.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mws.simplecrud.home.data.HomeRepository
import com.mws.simplecrud.home.data.StudentModel

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private var homeRepository : HomeRepository?=null

    var studentModelListLiveData : LiveData<List<StudentModel>>?=null

    init {
        homeRepository = HomeRepository()
        studentModelListLiveData = MutableLiveData()
    }

    fun fetchAllStudent() {
        studentModelListLiveData = homeRepository?.fecthAllStudent()
    }
}