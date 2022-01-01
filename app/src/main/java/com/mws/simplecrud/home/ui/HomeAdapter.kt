package com.mws.simplecrud.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mws.simplecrud.R
import com.mws.simplecrud.home.data.StudentModel
import kotlinx.android.synthetic.main.list_item_student.view.*

class HomeAdapter(var listener:HomeListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var data : ArrayList<StudentModel>?=null

    interface HomeListener {
        fun onItemDeleted(studentModel: StudentModel, position: Int)
    }

    fun setData (list: ArrayList<StudentModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_student,parent,true))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size?:0
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: StudentModel?) {
            itemView.lbNimList.text = item?.nim.toString()
            itemView.lbNameList.text = item?.name.toString()
            itemView.lbAddressList.text = item?.address.toString()
            itemView.lbGenderList.text = item?.address.toString()
        }

    }


}
