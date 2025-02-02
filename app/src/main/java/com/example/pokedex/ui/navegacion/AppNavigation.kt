package com.example.pokedex.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.ui.screen.HomeScreen
import com.example.pokedex.ui.screen.PokemonListScreen
import com.example.pokedex.ui.screen.PokemonDetailScreen
import com.example.pokedex.viewmodel.PokemonViewModel

@Composable
fun AppNavigation(viewModel: PokemonViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("list/{type}") { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: "fire"
            PokemonListScreen(type, navController, viewModel)
        }
        composable("detail/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "pikachu"
            PokemonDetailScreen(name, viewModel)
        }
    }
}
