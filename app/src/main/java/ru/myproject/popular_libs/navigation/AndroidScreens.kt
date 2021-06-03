package ru.myproject.popular_libs.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.myproject.popular_libs.mvp.model.entity.GithubUser
import ru.myproject.popular_libs.ui.fragment.UserFragment
import ru.myproject.popular_libs.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(user: GithubUser) = FragmentScreen { UserFragment.newInstance(user) }
}