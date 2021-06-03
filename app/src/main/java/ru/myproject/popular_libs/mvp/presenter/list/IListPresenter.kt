package ru.myproject.popular_libs.mvp.presenter.list

import ru.myproject.popular_libs.mvp.view.list.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}