package com.kotlin.mvp.ui.detail

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.kotlin.mvp.R
import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.base.view.BaseActivity
import com.kotlin.mvp.util.loadCircleImage
import com.kotlin.mvp.util.loadImage
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.recipe_detail.*

class DetailActivity : BaseActivity(), View.OnClickListener {

    companion object {
        const val RECIPE_OBJECT = "RecipeObject"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpActionBar()

        setUpData()

        windowTransition()
    }

    override fun getLayoutResourceId() = R.layout.activity_detail

    private fun setUpActionBar(){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setUpData() {
        val recipeModel = intent.getParcelableExtra<RecipeModel>(RECIPE_OBJECT)

        val (recipeName, recipeThumb, avatarUrl, likesText, descriptionText, cookNameText ) = recipeModel

        collapsing_toolbar.title = recipeName

        recipeThumb?.let { recipe_image.loadImage(recipeThumb) }
        avatarUrl?.let { avatar.loadCircleImage(avatarUrl) }

        description.text = descriptionText
        likes.text = likesText
        cook_name.text = cookNameText
        recipe_name.text = recipeName

        fab.setOnClickListener(this)
    }

    private fun windowTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.enterTransition.addListener(object : android.transition.Transition.TransitionListener {
                override fun onTransitionEnd(transition: android.transition.Transition?) {
                    fab.animate().alpha(1.0f)
                }

                override fun onTransitionResume(p0: android.transition.Transition?) {}
                override fun onTransitionPause(p0: android.transition.Transition?) {}
                override fun onTransitionCancel(p0: android.transition.Transition?) {}
                override fun onTransitionStart(p0: android.transition.Transition?) {}
            })
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.fab -> {
                when (fab.isSelected) {
                    true -> {
                        fab.isSelected = false
                    }
                    else -> {
                        fab.isSelected = true
                    }
                }
            }
                else -> {
            }
        }
    }

    override fun onBackPressed() {
        fab.visibility = View.GONE
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        fab.visibility = View.GONE
        supportFinishAfterTransition()
        return super.onOptionsItemSelected(item)
    }
}
