package com.kotlin.mvp

import android.app.Activity
import android.app.Application
import com.kotlin.mvp.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MVPApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }
}