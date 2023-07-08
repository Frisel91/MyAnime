package com.example.myanime

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Profile : Routes("profile")
    object Play : Routes("play")
}