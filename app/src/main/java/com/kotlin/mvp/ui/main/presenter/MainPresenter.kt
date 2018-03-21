package com.kotlin.mvp.ui.main.presenter

import android.view.View
import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.base.presenter.BasePresenter
import com.kotlin.mvp.ui.main.interactor.MainInteractor
import com.kotlin.mvp.ui.main.view.MainView

interface MainPresenter<V: MainView, I: MainInteractor> : BasePresenter<V, I> {

    fun onRecipeItemClick(recipeModel: RecipeModel, view: View)
}

