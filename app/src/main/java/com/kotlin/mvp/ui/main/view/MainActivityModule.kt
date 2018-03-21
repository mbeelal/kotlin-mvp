package com.kotlin.mvp.ui.main.view

import android.support.v7.widget.GridLayoutManager
import com.kotlin.mvp.R
import com.kotlin.mvp.ui.main.RecipeAdapter
import com.kotlin.mvp.ui.main.interactor.MainInteractorImpl
import com.kotlin.mvp.ui.main.interactor.MainInteractor
import com.kotlin.mvp.ui.main.presenter.MainPresenter
import com.kotlin.mvp.ui.main.presenter.MainPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenterImpl<MainView, MainInteractor>): MainPresenter<MainView, MainInteractor> = mainPresenter

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractorImpl): MainInteractor = mainInteractor

    @Provides
    internal fun provideAdapter(activity: MainActivity): RecipeAdapter = RecipeAdapter(ArrayList(), activity)

    @Provides
    internal fun provideGridLayoutManager(activity: MainActivity): GridLayoutManager =
            GridLayoutManager(activity, activity.resources.getInteger(R.integer.recipe_list_columns), GridLayoutManager.VERTICAL, false)
}