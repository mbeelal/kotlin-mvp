package com.kotlin.mvp.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.View
import com.kotlin.mvp.R
import com.kotlin.mvp.data.RecipeModel
import com.kotlin.mvp.ui.base.view.BaseActivity
import com.kotlin.mvp.ui.detail.DetailActivity
import com.kotlin.mvp.ui.main.RecipeAdapter
import com.kotlin.mvp.ui.main.interactor.MainInteractor
import com.kotlin.mvp.ui.main.presenter.MainPresenterImpl
import com.kotlin.mvp.util.RecipeItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.item_recipe_list.view.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenterImpl<MainView, MainInteractor>
    @Inject
    lateinit var gridLayoutManager: GridLayoutManager
    @Inject
    lateinit var recipeListAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpActionBar()

        presenter.onAttach(this)
    }

    override fun getLayoutResourceId() = R.layout.activity_main

    private fun setUpActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        toggle.syncState()
    }

    override fun showRecipesList(recipesList: List<RecipeModel>) {
        movies_list.layoutManager = gridLayoutManager
        movies_list.itemAnimator = DefaultItemAnimator()
        movies_list.addItemDecoration(RecipeItemDecoration(resources.getDimension(R.dimen.recipe_item_decoration_space).toInt()))
        recipeListAdapter.addRecipesToList(recipesList)

        recipeListAdapter.setRecipeClickListener(object: RecipeAdapter.RecipeItemClickListener{
            override fun onClick(recipeModel: RecipeModel, view: View) {
                presenter.onRecipeItemClick(recipeModel, view)
            }
        })

        movies_list.adapter = recipeListAdapter
    }

    override fun openDetailsActivity(recipeModel: RecipeModel, view: View) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.RECIPE_OBJECT, recipeModel)

        val p1 = android.support.v4.util.Pair.create(view.recipe_image as View, "food")

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1)

        ActivityCompat.startActivity(this, intent, options.toBundle())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bar_menu, menu)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        presenter.onAttach(this)
        super.onDestroy()
    }
}
