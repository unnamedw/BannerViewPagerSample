package com.example.ultraviewpagertest

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
fun pxToDp(context: Context, px: Int): Float {
    val metrics = context.resources.displayMetrics
    return px/metrics.density
}