package ru.myproject.popular_libs.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.myproject.popular_libs.mvp.view.MainView
import ru.myproject.popular_libs.navigation.IScreens

class MainPresenter(private val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}