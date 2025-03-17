package com.jwplayer.compose.ui.jw

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jwplayer.compose.viewmodel.VideoViewModel

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Video(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
    val viewModel: VideoViewModel = viewModel()

    LazyColumn(modifier = Modifier.size(900.dp)) {
        item {
            Box(modifier = Modifier.background(Color.Transparent)) {
                Button(onClick = {}) {
                    Text("Test", color = Color.Black)
                }
            }
            VideoPlayer(
                modifier = Modifier.size(300.dp),
                videoState = viewModel.uiState.collectAsState().value,
                lifecycleOwner = lifecycleOwner,
                handleEvent = viewModel::handleEvent
            )

            Spacer(modifier = Modifier.size(100.dp))

            VideoPlayer(
                modifier = Modifier.size(300.dp),
                videoState = viewModel.uiState.collectAsState().value,
                lifecycleOwner = lifecycleOwner,
                handleEvent = viewModel::handleEvent
            )
        }
    }
}