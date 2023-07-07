package com.team.agestar_android.navigation

sealed class AppNavigationItem(val route: String){

    object Splash : AppNavigationItem("splash")

    object Register : AppNavigationItem("register")

    object Login : AppNavigationItem("login")

    object Main : AppNavigationItem("main")

    object Profile : AppNavigationItem("profile")

    object Setting : AppNavigationItem("setting")

    object Benefit : AppNavigationItem("benefit")

}
