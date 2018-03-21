package com.kotlin.mvp.di.builder

import com.kotlin.mvp.ui.detail.DetailActivity
import com.kotlin.mvp.ui.landing.LandingActivity
import com.kotlin.mvp.ui.main.view.MainActivity
import com.kotlin.mvp.ui.main.view.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun bindLandingActivity(): LandingActivity

    @ContributesAndroidInjector()
    abstract fun bindDetailActivity(): DetailActivity
}