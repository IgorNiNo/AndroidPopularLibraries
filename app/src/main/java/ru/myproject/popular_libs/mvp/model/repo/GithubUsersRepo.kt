package ru.myproject.popular_libs.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.myproject.popular_libs.mvp.model.entity.GithubUser

class GithubUsersRepo {
    private val repositories = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    fun getUsers(): Single<List<GithubUser>> = Single.just(repositories)
}