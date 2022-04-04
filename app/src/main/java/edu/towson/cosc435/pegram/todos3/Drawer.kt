package edu.towson.cosc435.pegram.todos3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.towson.cosc435.pegram.todos3.ui.theme.Todos3Theme

sealed class DrawerScreens(val title: String, val route: String) {
    object Home : DrawerScreens("Todos", "home")
    object Add : DrawerScreens("Add new Todo", "add")
}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Add
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.route)
                }
            )
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    Todos3Theme {
        Drawer{}
    }
}