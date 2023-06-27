package com.example.myanime.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myanime.R
import com.example.myanime.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    navController: NavHostController,
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo",
                    Modifier.clickable { navController.navigate(Routes.Home.route)})
                Spacer(modifier = Modifier.weight(0.5f))
                Image(painter = painterResource(id = R.drawable.discord2), contentDescription = "discord" )
                Spacer(modifier = Modifier.padding(15.dp))
                Image(imageVector = Icons.Default.Person, contentDescription = "LK",
                    Modifier.clickable { navController.navigate(Routes.Profile.route)})
                Spacer(modifier = Modifier.padding(15.dp))
                Image(imageVector = Icons.Default.Search, contentDescription = "Search")
                Spacer(modifier = Modifier.padding(10.dp))
            }


        },
        modifier = Modifier.background(MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }
        }

    )
}
