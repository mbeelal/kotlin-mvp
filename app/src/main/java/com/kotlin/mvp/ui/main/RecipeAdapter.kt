package com.kotlin.mvp.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.mvp.R
import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.main.view.MainActivity
import com.kotlin.mvp.util.loadCircleImage
import com.kotlin.mvp.util.loadImage
import kotlinx.android.synthetic.main.item_recipe_list.view.*


class RecipeAdapter(private val recipeItemsList: MutableList<RecipeModel>, private val activity: MainActivity) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private var recipeClickListener: RecipeItemClickListener? = null

    interface RecipeItemClickListener {
        fun onClick(recipeModel: RecipeModel, view: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_recipe_list, parent, false)
        return RecipeViewHolder(view, recipeClickListener)
    }

    override fun getItemCount() = recipeItemsList.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.onBindData(recipeItemsList[position])
    }

    internal fun addRecipesToList(recipes: List<RecipeModel>) {
        this.recipeItemsList.addAll(recipes)
    }

    fun setRecipeClickListener(listener: RecipeItemClickListener) {
        recipeClickListener = listener
    }


    inner class RecipeViewHolder(view: View, private val listener: RecipeItemClickListener?) : RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            listener?.onClick(recipeItemsList[adapterPosition], itemView)
        }

        fun onBindData(recipeModel: RecipeModel) {
            val (recipeName, recipeThumb, avatar, likes, description, cookName) = recipeModel
            recipeName?.let { itemView.recipe_name.text = it }
            cookName?.let { itemView.cook_name.text = it }
            likes?.let { itemView.likes.text = it }
            description?.let { itemView.description.text = it }

            recipeThumb?.let {
                itemView.recipe_image.loadImage(url = recipeThumb)
            }

            avatar?.let {
                itemView.avatar.loadCircleImage(url = avatar)
            }
        }
    }
}