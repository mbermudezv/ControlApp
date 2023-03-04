package com.example.controlapp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPreviewScreen(
    uri: String
) {
    val context = LocalContext.current

    val exoPlayer = remember(context) {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(uri))
            prepare()
        }
    }

    DisposableEffect(

        Column
        {
            AndroidView(
                factory = { context ->

                    StyledPlayerView(context).apply {
                        player = exoPlayer
                    }

                },
                modifier = Modifier.padding(1.dp)
            )

            // Compose Button
            androidx.compose.material.Button(onClick = {Log.d("Guardar","Guardar") }) {
                Text("Guardar")
            }

        }

    ) {
        onDispose {
            exoPlayer.release()
        }
    }
}

