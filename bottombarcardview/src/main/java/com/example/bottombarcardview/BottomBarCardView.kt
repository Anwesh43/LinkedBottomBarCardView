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
val parts : Int = 1 + lines
val scGap : Float = 0.02f / parts
val strokeFactor : Float = 90f

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBottomBarCard(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val size : Float = Math.min(w, h) / sizeFactor
    val barSize : Float = size / barSizeFactor
    save()
    translate(w / 2, h / 2)
    for (j in 0..(parts - 1)) {
        save()
        rotate(rot * j)
        drawLine(-size, -size, -size + 2 * size * sf.divideScale(j, parts), -size, paint)
        restore()
    }
    drawRect(RectF(-size, size - barSize * sf.divideScale(lines, parts), size, size), paint)
    restore()
}

fun Canvas.draweBBCNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawBottomBarCard(scale, w, h, paint)
}
