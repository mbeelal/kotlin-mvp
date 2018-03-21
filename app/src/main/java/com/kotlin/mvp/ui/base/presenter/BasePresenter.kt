package com.kotlin.mvp.ui.base.presenter

import com.kotlin.mvp.ui.base.interactor.BaseInteractor
import com.kotlin.mvp.ui.base.view.BaseView

interface BasePresenter<V: BaseView, I: BaseInteractor?> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}