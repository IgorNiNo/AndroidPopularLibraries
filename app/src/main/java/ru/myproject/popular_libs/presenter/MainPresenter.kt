package ru.myproject.popular_libs.presenter

import ru.myproject.popular_libs.model.CountersModel
import ru.myproject.popular_libs.view.MainView

class MainPresenter(val view: MainView) {
    val model = CountersModel()

    fun counterClick1() {
        view.setButtonText1(model.next(0).toString())
    }

    fun counterClick2() {
        view.setButtonText2(model.next(1).toString())
    }

    fun counterClick3() {
        view.setButtonText3(model.next(2).toString())
    }
}