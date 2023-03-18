package com.example.controlapp

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPreviewScreen(
    uri: String
) {

    Box(modifier = Modifier.fillMaxSize()){

        val context = LocalContext.current

        val exoPlayer = remember(context) {
            ExoPlayer.Builder(context).build().apply {
                setMediaItem(MediaItem.fromUri(uri))
                prepare()
            }
        }

        DisposableEffect(

            AndroidView(
                factory = { context ->

                    StyledPlayerView(context).apply {
                        player = exoPlayer
                    }

                },
                modifier = Modifier.padding(1.dp)
            )

        ) {
            onDispose {
                exoPlayer.release()
            }
        }

        ExtendedFloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(12.dp),
            text = {
                Text("GUARDAR")
            },
            shape = RoundedCornerShape(
                ZeroCornerSize
            ),
            backgroundColor = Color(0xFF83838A),
            contentColor = Color(0xFF041631),
            onClick = { Log.d("Guardar","Guardar") }
        )

    }


}

