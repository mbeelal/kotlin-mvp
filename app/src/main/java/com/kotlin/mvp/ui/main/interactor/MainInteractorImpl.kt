package com.kotlin.mvp.ui.main.interactor

import android.content.Context
import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.base.interactor.BaseInteractorImpl
import com.kotlin.mvp.util.AppConstants
import com.kotlin.mvp.util.AppUtils
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import javax.inject.Inject

class MainInteractorImpl @Inject constructor(val context: Context): BaseInteractorImpl(), MainInteractor {

    override fun getRecipesList(): List<RecipeModel> {
        val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, RecipeModel::class.java)
        return GsonBuilder().create().fromJson<List<RecipeModel>>(
                AppUtils.readRecipesJsonFromAsset(context, AppConstants.RECIPES_JSON), type)

    }
}