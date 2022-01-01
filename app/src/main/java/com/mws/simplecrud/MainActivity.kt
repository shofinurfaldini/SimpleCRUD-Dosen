package com.mws.simplecrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mws.simplecrud.R
import com.mws.simplecrud.home.data.StudentModel
import kotlinx.android.synthetic.main.activity_main.*
import com.mws.simplecrud.home.ui.HomeAdapter


import com.mws.simplecrud.home.viewmodel.HomeViewModel

private lateinit var vm:HomeViewModel
private lateinit var adapter: HomeAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[HomeViewModel :: class.java]

        initAdapter()

        vm.fetchAllStudent()

        vm.studentModelListLiveData?.observe(this, Observer{
            if (it!=null){
                rv_home.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<StudentModel>)
            }else{
                showToast("Something went wrong")
            }
            progress_home.visibility= View.GONE
        })
    }

    private fun showToast(s: String) {

    }

    private fun initAdapter() {
        TODO("Not yet implemented")
    }
}