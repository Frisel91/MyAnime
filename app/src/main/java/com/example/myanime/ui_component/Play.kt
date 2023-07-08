package com.example.myanime.ui_component



import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.myanime.model.MenuItem
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Play(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current
    var playWhenReady by remember { mutableStateOf(true) }
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"))
            repeatMode = ExoPlayer.REPEAT_MODE_ALL
            playWhenReady = playWhenReady
            prepare()
            play()
        }
    }


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

        }
        Text(text = "Здесь будет страница gktthf"
            ,Modifier.padding(vertical = 100.dp))
        Spacer(modifier = Modifier.padding(vertical = 100.dp))
        DisposableEffect(
            AndroidView(
                modifier = Modifier.fillMaxSize(),
                factory = {
                    PlayerView(context).apply {
                        player = exoPlayer
                        useController = true
                        FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                    }
                }
            )
        ) {
            onDispose {
                exoPlayer.release()
            }
        }
    }
}