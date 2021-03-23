package com.mvvmwithhilt.module.dto

import com.google.gson.annotations.SerializedName

data class HomeScreenListResponse(
    @SerializedName("components")
    val components: ArrayList<DataClass>?
)

data class DataClass(
    @SerializedName("name")
    val name: String?,
    @SerializedName("StaticBanner")
    val staticBanner: ArrayList<BannerList>?,
    @SerializedName("categorydata")
    val categoryData: ArrayList<CategoryList>?,
    @SerializedName("AdsBanner")
    val adsBanner: ArrayList<BannerList>?,
    @SerializedName("CarouselBanner")
    val carouselBanner: ArrayList<BannerList>?
)

data class BannerList(
    val banner_id: Int?,
    @SerializedName("document")
    val banner_image: String?
)

data class CategoryList(
    @SerializedName("category_name")
    val categoryName: String?,
    @SerializedName("category_picture")
    val categoryPicture: String?
)
