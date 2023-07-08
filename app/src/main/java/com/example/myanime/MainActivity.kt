package com.example.myanime

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myanime.ui.theme.MyAnimeTheme
import com.example.myanime.ui_component.Home
import com.example.myanime.ui_component.Play
import com.example.myanime.ui_component.Profile
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAnimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    ScreenMain()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMain() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route){
        //First route : Home
        composable(Routes.Home.route) {

            //Lay down the Home Composable and pass the navController
            Home(navController = navController)
        }

        //Another Route : Profile
        composable(Routes.Profile.route) {
            //Profile Screen
            Profile(navController)
        }

        //Settings Route, Notice the "/{id}" in last, its the argument passed down from homeScreen
        composable(Routes.Play.route) {

            Play(navController)

        }
    }
}

fun provideExoPlayer(context : Context, mediaItem: MediaItem): ExoPlayer {
    val player = ExoPlayer.Builder(context).build()
    player.setMediaItem(mediaItem)
    return player
}