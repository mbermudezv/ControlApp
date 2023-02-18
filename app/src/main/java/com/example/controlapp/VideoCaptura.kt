package com.example.controlapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun VideoCaptura(
    navController: NavController
) {

    navController.navigate("${Route.VIDEO_PREVIEW}/")

}