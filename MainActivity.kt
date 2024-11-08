package com.example.androidstudio_koala_template

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidstudio_koala_template.ui.theme.AndroidStudioKoalaTemplateTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting(
                name = "Android"
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var scrollState = rememberScrollState()
    var expanded by remember {mutableStateOf(false)}
    val iconos = listOf(Icons.Default.Add, Icons.Default.Email, Icons.Default.Phone, Icons.Default.Star, Icons.Default.Check, Icons.Default.Favorite, Icons.Default.CheckCircle, Icons.Default.Create, Icons.Default.Delete, Icons.Default.ThumbUp)
    var selectedIcon by remember { mutableStateOf(iconos[9])}
    var min by remember { mutableStateOf(0)}
    var max by remember { mutableStateOf(10)}
    Box(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ){
            Text(text = "Repte 01 Tiago Navarro", fontSize = 20.sp)

            Row(
                modifier = Modifier
                    .padding(8.dp)
            ){
                Text("Min:        ")
                Text("Max: ")
            }
            Button(
                onClick ={
                    expanded = true
                }
            ){
                Text("Seleccionar icono")
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Add") },
                    onClick = { selectedIcon = iconos[0] }
                )
                DropdownMenuItem(
                    text = { Text("Email") },
                    onClick = { selectedIcon = iconos[1]}
                )
                DropdownMenuItem(
                    text = { Text("Phone")},
                    onClick = { selectedIcon = iconos[2]}
                )
                DropdownMenuItem(
                    text = { Text("Star") },
                    onClick = { selectedIcon = iconos[3] }
                )
                DropdownMenuItem(
                    text = { Text("Check") },
                    onClick = { selectedIcon = iconos[4]}
                )
                DropdownMenuItem(
                    text = { Text("Favourite")},
                    onClick = { selectedIcon = iconos[5]}
                )
                DropdownMenuItem(
                    text = { Text("Check Circle") },
                    onClick = { selectedIcon = iconos[6] }
                )
                DropdownMenuItem(
                    text = { Text("Create") },
                    onClick = { selectedIcon = iconos[7]}
                )
                DropdownMenuItem(
                    text = { Text("Delete")},
                    onClick = { selectedIcon = iconos[8]}
                )
                DropdownMenuItem(
                    text = { Text("Tumbup") },
                    onClick = { selectedIcon = iconos[9] }
                )
            }
            Column(
            ){
                Text("Min:")
                TextField(value = min, label = { Text("$min") })
            }
            Column(
            ){
                Text("Max:")
                TextField(value = max, label = { Text("$max") })
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android")
}