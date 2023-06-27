package com.example.myanime.ui_component


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myanime.AnimeRepository.anime
import com.example.myanime.Routes
import com.example.myanime.model.MenuItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerBody(items = listOf(
                    MenuItem(
                        id = "janr",
                        title = "Жанры",
                        icon = Icons.Default.Home
                    ),
                    MenuItem(
                        id = "type",
                        title = "Тип",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "ongoing",
                        title = "Онгоинги",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "2023",
                        title = "2023",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "game",
                        title = "Игры",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "raspisanie",
                        title = "Расписание",
                        icon = Icons.Default.Info
                    ),
                    MenuItem(
                        id = "zakladki",
                        title = "Закладки",
                        icon = Icons.Default.Info
                    ),
                ), onItemClick = {
                    println("Clicked on ${it.title}")
                })
            }
        }) {
        Scaffold(topBar = {
            AppBar(navController,
                onNavigationIconClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            )
        }
        )

        {
            AnimeContentList(anime = anime)
        }
    }
}