package com.mvvmwithhilt.module.homeScreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvmwithhilt.R
import com.mvvmwithhilt.common.Constants
import com.mvvmwithhilt.module.dto.CategoryList
import kotlinx.android.synthetic.main.category_row.view.*

class CategoryListAdapter(
    val context: Context,
    private var categoryList: ArrayList<CategoryList>?
) :
    RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.category_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (categoryList == null) 0 else categoryList?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(categoryList?.get(position)!!, context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(data: CategoryList, context: Context) {
            itemView.category_name.text = data.categoryName
            Glide.with(context).load(Constants.BASE_URL + data.categoryPicture).into(itemView.category_img)
        }
    }

}