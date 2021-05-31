package ru.myproject.popular_libs.presenter

import ru.myproject.popular_libs.model.CountersModel
import ru.myproject.popular_libs.view.MainView

class MainPresenter(private val view: MainView, private val model: CountersModel) {
    fun counterClick1() {
        view.showCounter1(model.next(0).toString())
    }

    fun counterClick2() {
        view.showCounter2(model.next(1).toString())
    }

    fun counterClick3() {
        view.showCounter3(model.next(2).toString())
    }
}