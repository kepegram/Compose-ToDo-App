package edu.towson.cosc435.pegram.todos3

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController,
    openDrawer: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Todos",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            TodoCards()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            onClick = { navController.navigate(route = DrawerScreens.Add.route) },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add , contentDescription = null)
        }
    }
}

@Composable
fun Add(openDrawer: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(
            title = "Todos",
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = { openDrawer() },
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "New Todo",
                style = MaterialTheme.typography.h4
            )
            var title by remember { mutableStateOf("") }
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
            )
            var content by remember { mutableStateOf("") }
            TextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Contents") },
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
            )
            LabelledCheckbox()
            saveButton()
        }
    }
}

@Composable
fun TodoCards() {
    LazyColumn(
    ) {
        items(10) {index ->
            Card(
                shape = RoundedCornerShape(5.dp),
                elevation = 16.dp,
                modifier = Modifier
                    .padding(start=16.dp, end=16.dp, top=5.dp, bottom=5.dp)
                    .fillMaxWidth()
            ) {
                Column(
                ) {
                    Text(text = "Todo0", fontSize = 30.sp)
                    Text(text = "Contents0", fontSize = 20.sp)
                    Text(text = "Sun Mar 06 18:36:43 EST 2022", fontSize = 10.sp)
                }
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(){
                        val checkedState = remember { mutableStateOf(false)}
                        Checkbox(
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it },
                            colors = CheckboxDefaults.colors(MaterialTheme.colors.primaryVariant),
                            modifier = Modifier.scale(1f)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun LabelledCheckbox() {
    Row(modifier = Modifier.padding(8.dp)) {
        val isChecked = remember { mutableStateOf(false) }
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            enabled = true,
            colors = CheckboxDefaults.colors(MaterialTheme.colors.primaryVariant)
        )
        Text(text = "Completed")
    }
}

@Composable
fun saveButton() {
    Column() {
        Button(onClick = {},
            modifier = Modifier.padding(all = Dp(10F)),
            enabled = true,
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Gray)),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
        )
        {
            Text(text = "Save", color = Color.White)
        }
    }
}