package com.canopas.dagger2

interface BasePresenter<T> {
    fun attachView(view: T)
    fun detachView()
}