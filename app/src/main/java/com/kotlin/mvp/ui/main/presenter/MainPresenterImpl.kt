package com.kotlin.mvp.ui.main.presenter

import android.view.View
import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.base.presenter.BasePresenterImpl
import com.kotlin.mvp.ui.main.interactor.MainInteractor
import com.kotlin.mvp.ui.main.view.MainView
import javax.inject.Inject

class MainPresenterImpl<V : MainView, I : MainInteractor> @Inject constructor(interactor: I) : BasePresenterImpl<V, I>(interactor), MainPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)

        getRecipesList()
    }

    private fun getRecipesList() = interactor?.let {
        getView()?.showRecipesList(it.getRecipesList())
    }

    override fun onRecipeItemClick(recipeModel: RecipeModel, view: View) {
        getView()?.openDetailsActivity(recipeModel, view)
    }
}