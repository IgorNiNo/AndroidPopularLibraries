package ru.myproject.popular_libs.navigation

import com.github.terrakok.cicerone.Screen
import ru.myproject.popular_libs.mvp.model.entity.GithubUser

interface IScreens {
    fun users(): Screen
    fun user(user: GithubUser): Screen
}