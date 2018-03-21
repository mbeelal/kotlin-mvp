package com.kotlin.mvp.ui.landing

import android.content.Intent
import android.os.Bundle
import com.kotlin.mvp.R
import com.kotlin.mvp.ui.base.view.BaseActivity
import com.kotlin.mvp.ui.main.view.MainActivity
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_start.setOnClickListener {
            startActivity(Intent(this@LandingActivity, MainActivity::class.java))
            finish()
        }
    }

    override fun getLayoutResourceId() = R.layout.activity_landing
}
