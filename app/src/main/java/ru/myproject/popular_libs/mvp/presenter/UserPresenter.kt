package ru.myproject.popular_libs.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.myproject.popular_libs.mvp.model.entity.GithubUser
import ru.myproject.popular_libs.mvp.view.UserView

class UserPresenter(private val user: GithubUser, private val router: Router) :
    MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(user.login)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}