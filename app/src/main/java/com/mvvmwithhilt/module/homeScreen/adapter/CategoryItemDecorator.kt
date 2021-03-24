package com.mvvmwithhilt.module.homeScreen.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CategoryItemDecorator(
    private val left: Int,
    private val right: Int,
    private val top: Int,
    private val bottom: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = bottom
        outRect.top = top
        outRect.left = left
        outRect.right = right
    }

}