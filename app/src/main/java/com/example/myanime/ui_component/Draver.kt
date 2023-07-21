package com.example.myanime.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myanime.R
import com.example.myanime.model.MenuItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Draver(
    navController: NavController
) {
    val items = listOf(
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
    )
    
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember {
        mutableStateOf(items[0])
    }
    
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(painter = painterResource(id = R.drawable._617724545_screenshot_3), contentDescription = "Header",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                items.forEach{
                    item -> NavigationDrawerItem(
                    label = { 
                            Text(text = item.title)
                    },
                    selected = selectedItem.value == item,
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    onClick = {
                        scope.launch {
                            selectedItem.value = item
                            drawerState.close()
                        }
                    })
                }
            }
        },
    content = {
            AppBar(navController = ) {

            }
    } )
}