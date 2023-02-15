package com.example.controlapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Inicio()
        }

    }
}

@Composable
fun Inicio()
{
    Row(modifier = Modifier.padding(all = 8.dp))
    {
        Column {
            Text(
                "Hola Mundo"
                )
        }
    }
}

@Preview
@Composable
fun PreviewInicio() {
    Inicio()
}