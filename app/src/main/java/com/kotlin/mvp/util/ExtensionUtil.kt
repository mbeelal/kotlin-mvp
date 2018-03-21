package com.kotlin.mvp.util

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.kotlin.mvp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
            .asBitmap()
            .load(url)
            .into(this)

}

internal fun ImageView.loadCircleImage(url: String) {
    Glide.with(this.context)
            .asBitmap()
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
}

internal fun AppCompatActivity.setActivityOrientation() {
    if (resources.getBoolean(R.bool.isTablet)) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }
}