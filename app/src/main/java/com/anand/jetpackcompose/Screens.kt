package com.anand.jetpackcompose

sealed class Screens(val screen:String) {
    data object Home:Screens("home")
    data object Profile:Screens("profile")
    data object Settings:Screens("settings")
    data object AddScreen:Screens("add")
    data object Search:Screens("search")

}