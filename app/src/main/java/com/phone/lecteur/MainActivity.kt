package com.phone.lecteur

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.phone.lecteur.ui.theme.LecteurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LecteurTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen("Android", this)
                }
            }
        }
    }
}

@Composable
fun Screen(name: String, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Music Player",
            style = MaterialTheme.typography.h3.copy(color = MaterialTheme.colors.primary),
            modifier = Modifier.padding(bottom = 50.dp)
        )
        Button(onClick = {
            context.startService(
                Intent(context, MyServices::class.java)
            )
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Lancer")
        }
        Button(onClick = {
            context.stopService(Intent(context, MyServices::class.java))
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Arreter")
        }
    }
}

