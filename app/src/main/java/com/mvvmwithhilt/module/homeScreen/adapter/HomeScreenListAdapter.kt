package com.mvvmwithhilt.module.homeScreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvmwithhilt.R
import com.mvvmwithhilt.common.Constants
import com.mvvmwithhilt.extension.dpFromPx
import com.mvvmwithhilt.module.dto.DataClass
import kotlinx.android.synthetic.main.list_row.view.*

class HomeScreenListAdapter(val context: Context, private var data: ArrayList<DataClass>?) :
    RecyclerView.Adapter<HomeScreenListAdapter.ViewHolder>() {

    fun notifyHomeList(data: ArrayList<DataClass>?) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data?.get(position)!!, context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(data: DataClass, context: Context) {
            if (data.categoryData != null && data.categoryData.size > 0) {
                itemView.sub_list_parent_layout.visibility = View.VISIBLE
                itemView.banner.visibility = View.GONE

                itemView.category_hint.text = data.name

                val categoryListAdapter = CategoryListAdapter(context, data.categoryData)
                itemView.sub_list.layoutManager = GridLayoutManager(context, 3)
                itemView.sub_list.setHasFixedSize(true)
                itemView.sub_list.addItemDecoration(
                    CategoryItemDecorator(
                        0,
                        dpFromPx(context, 10f),
                        0,
                        dpFromPx(context, 5f)
                    )
                )
                itemView.sub_list.adapter = categoryListAdapter

            } else {
                itemView.sub_list_parent_layout.visibility = View.GONE
                itemView.banner.visibility = View.VISIBLE
                var imageURL = ""
                if (data.staticBanner != null && data.staticBanner.size > 0) {
                    itemView.banner.layoutParams.height = dpFromPx(context, 180f)
                    imageURL = data.staticBanner[0].bannerImage!!
                } else if (data.adsBanner != null && data.adsBanner.size > 0) {
                    itemView.banner.layoutParams.height = dpFromPx(context, 100f)
                    imageURL = data.adsBanner[0].bannerImage!!
                } else if (data.carouselBanner != null && data.carouselBanner.size > 0) {
                    itemView.banner.layoutParams.height = dpFromPx(context, 120f)
                    imageURL = data.carouselBanner[0].bannerImage!!
                } else {
                    itemView.banner.visibility = View.GONE
                }
                Glide.with(context).load(Constants.BASE_URL + imageURL).into(itemView.banner)
            }
        }
    }

}