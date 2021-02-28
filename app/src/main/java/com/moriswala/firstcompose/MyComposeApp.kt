package com.moriswala.firstcompose

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.moriswala.firstcompose.utils.LocalBackDispatcher
import com.moriswala.firstcompose.utils.ProvideImageLoader
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun MyComposeApp(backDispatcher: OnBackPressedDispatcher) {

    CompositionLocalProvider(LocalBackDispatcher provides backDispatcher) {
        ProvideWindowInsets {
            ProvideImageLoader {
                NavGraph()
            }
        }
    }
}
