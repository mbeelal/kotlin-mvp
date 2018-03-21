package com.kotlin.mvp.ui.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.mvp.util.setActivityOrientation
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())

        this.setActivityOrientation()

        injectActivity()
    }

    abstract fun getLayoutResourceId(): Int

    private fun injectActivity() = AndroidInjection.inject(this)
}