package com.mvvmwithhilt.extension

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

fun dpFromPx(context: Context, px: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, px, context.resources.displayMetrics
    ).roundToInt()
}