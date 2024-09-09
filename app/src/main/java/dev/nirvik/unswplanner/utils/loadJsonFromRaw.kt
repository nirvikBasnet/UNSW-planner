package dev.nirvik.unswplanner.utils

import android.content.Context
import java.io.InputStream

fun loadJsonFromRaw(context: Context, resourceId: Int): String {
    val inputStream: InputStream = context.resources.openRawResource(resourceId)
    return inputStream.bufferedReader().use { it.readText() }
}
