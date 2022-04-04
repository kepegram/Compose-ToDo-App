package edu.towson.cosc435.pegram.todos3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Home(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Todos",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Home Page content here.")
        }
    }
}

@Composable
fun Add(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Add",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "New Todo", style = MaterialTheme.typography.h4)
        }
    }
}