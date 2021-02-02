package com.canopas.dagger2.ui

import com.canopas.dagger2.BasePresenter
import com.canopas.dagger2.model.User
import com.canopas.dagger2.rest.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(private val userService: UserService) :
    BasePresenter<MainPresenter.View> {

    private val compositeDisposable = CompositeDisposable()

    private var view: View? = null

    override fun attachView(view: View) {
        this.view = view
        fetchUser()
    }

    private fun fetchUser() {
        compositeDisposable.add(
            userService.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.setUser(it)
                }, {
                    view?.showError(it.localizedMessage)
                })
        )
    }

    override fun detachView() {
        view = null
        compositeDisposable.clear()
    }

    interface View {
        fun showError(message: String)
        fun setUser(users: List<User>)
    }
}