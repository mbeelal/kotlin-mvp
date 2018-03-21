package com.kotlin.mvp.util

import android.content.Context
import java.nio.charset.Charset

object AppUtils {

    fun readRecipesJsonFromAsset(context: Context, jsonFileName: String): String {
        context.assets.open(jsonFileName).let {
            val buffer = ByteArray(it.available())
            it.read(buffer)
            it.close()
            buffer

        }.let {
            return String(it, Charset.forName("UTF-8"))
        }
    }
}