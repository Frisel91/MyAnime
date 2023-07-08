package com.example.myanime.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myanime.Routes
import com.example.myanime.model.Anime
import com.example.myanime.model.MenuItem


@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: androidx.compose.ui.text.TextStyle = androidx.compose.ui.text.TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier){
        items(items){item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(item) }
                .padding(16.dp)
            ) {
                Icon(imageVector = item.icon, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title
                    , style = itemTextStyle
                    ,modifier = Modifier.weight(1f))
            }
        }
    }
}


@Composable
fun AnimeCard(
    anime: Anime,
    modifier: Modifier = Modifier
){
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .sizeIn(minHeight = 72.dp)
        ){
            Image(painter = painterResource(anime.imageRes), contentDescription = null)
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = stringResource(anime.nameRes), style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = anime.dateRes, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = anime.serialRes, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


@Composable
fun AnimeContentList(
    anime: List<Anime>,
    navController: NavController
){
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(top = 70.dp)
            .background(Color.Blue)){
            Text(text = "Последние обновления аниме", modifier = Modifier
                .align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge)
        }
        LazyColumn {
            itemsIndexed(anime) {
                    index, anime -> AnimeCard(anime = anime,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        println("Clicked on ")
                        navController.navigate(Routes.Play.route)
                    })
            }
        }
    }
}

