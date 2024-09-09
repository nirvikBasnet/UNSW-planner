package dev.nirvik.unswplanner.utils

fun monthNameFromIndex(i : Int): String{
    val months = arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
    return months[i-1]
}