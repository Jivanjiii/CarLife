package com.example.glamify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.glamify.ui.theme.screens.about.AboutScreen
import com.example.glamify.ui.theme.screens.home.HomeScreen
import com.example.glamify.ui.theme.screens.login.LoginScreen
import com.example.glamify.ui.theme.screens.menu.MenuScreen
import com.example.glamify.ui.theme.screens.products.AddShoesScreen
import com.example.glamify.ui.theme.screens.products.UpdateShoeScreen
import com.example.glamify.ui.theme.screens.products.ViewShoeScreen
import com.example.glamify.ui.theme.screens.products.ViewShoesScreen
import com.example.glamify.ui.theme.screens.signup.SignupScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = LOGIN_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }
        composable(ADD_SHOES_URL){
            AddShoesScreen(navController = navController)
        }
        composable(VIEW_SHOES_URL){
            ViewShoesScreen(navController = navController)
        }

        composable(MORE_URL){
            MenuScreen(navController = navController)
        }
        composable(ABOUT_URL){
            AboutScreen(navController = navController)
        }
        composable(VIEW_USER_SHOE){
            ViewShoeScreen(navController = navController)
        }
        composable(ROUTE_UPDATE_SHOES){
            UpdateShoeScreen(navController = navController)
        }
    }
}