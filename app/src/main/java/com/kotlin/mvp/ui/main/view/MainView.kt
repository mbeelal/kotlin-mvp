package com.kotlin.mvp.ui.main.view

import android.view.View
import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.base.view.BaseView

interface MainView : BaseView {

    fun showRecipesList(recipesList: List<RecipeModel>)

    fun openDetailsActivity(recipeModel: RecipeModel, view: View)
}