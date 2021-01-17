package com.example.bottombarcardview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF
import android.app.Activity

val backColor : Int = Color.parseColor("#BDBDBD")
val sizeFactor : Float = 2.9f
val delay : Long = 20
val colors : Array<Int> = arrayOf(
    "#F44336",
    "#009688",
    "#FF5722",
    "#FF9800",
    "#795548"
).map {
    Color.parseColor(it)
}.toTypedArray()
val barSizeFactor : Float = 9.2f
val rot : Float = 90f
val lines : Int = 4
