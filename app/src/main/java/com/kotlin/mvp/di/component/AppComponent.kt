package com.kotlin.mvp.di.component

import android.app.Application
import com.kotlin.mvp.MVPApplication
import com.kotlin.mvp.di.builder.ActivityBuilder
import com.kotlin.mvp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MVPApplication)
}