package ru.myproject.popular_libs.mvp.presenter

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.myproject.popular_libs.mvp.model.entity.GithubUser
import ru.myproject.popular_libs.mvp.model.repo.GithubUsersRepo
import ru.myproject.popular_libs.mvp.presenter.list.IUserListPresenter
import ru.myproject.popular_libs.mvp.view.UsersView
import ru.myproject.popular_libs.mvp.view.list.UserItemView
import ru.myproject.popular_libs.navigation.IScreens

class UsersPresenter(
    private val usersRepo: GithubUsersRepo,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()
    private var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(screens.user(user))
        }
    }

    private fun loadData() {
        disposables.add(
            usersRepo
                .getUsers()
                .subscribe(
                    { users -> showUsers(users) },
                    { error -> Log.e("ERROR", error.message.toString()) }
                )
        )
    }

    private fun showUsers(users: List<GithubUser>) {
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}