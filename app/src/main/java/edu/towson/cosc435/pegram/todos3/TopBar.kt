package edu.towson.cosc435.pegram.todos3

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TopBar(
    title: String = "",
    buttonIcon: ImageVector,
    onButtonClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() } ) {
                Icon(buttonIcon, contentDescription = "")
            }
        },
        actions = {
                  IconButton(onClick = { /*TODO*/ }) {
                      Icon(Icons.Default.Settings, "Settings")
                  }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    )
}