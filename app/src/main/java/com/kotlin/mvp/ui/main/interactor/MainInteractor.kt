package com.kotlin.mvp.ui.main.interactor

import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.base.interactor.BaseInteractor

interface MainInteractor : BaseInteractor {

    fun getRecipesList(): List<RecipeModel>
}