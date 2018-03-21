package com.kotlin.mvp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeModel(
        @SerializedName("strMeal")
        var recipeName: String?,
        @SerializedName("strMealThumb")
        var recipeThumb: String?,
        @SerializedName("avatar")
        var avatar: String?,
        @SerializedName("likes")
        var likes: String?,
        @SerializedName("description")
        var description: String?,
        @SerializedName("cookName")
        var cookName: String?
): Parcelable