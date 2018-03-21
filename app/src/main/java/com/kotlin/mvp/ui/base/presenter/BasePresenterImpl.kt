package com.kotlin.mvp.ui.base.presenter

import com.kotlin.mvp.ui.base.interactor.BaseInteractor
import com.kotlin.mvp.ui.base.view.BaseView

abstract class BasePresenterImpl<V: BaseView, I: BaseInteractor> internal constructor(protected var interactor: I?) : BasePresenter<V, I> {

    private var view: V? = null

    internal val isViewAttached: Boolean
        get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
        interactor = null
    }

    override fun getView(): V? = view
}