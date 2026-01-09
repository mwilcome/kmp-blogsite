package com.mikewilcome.kmp.sharedui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikewilcome.kmp.SharedApi
import com.mikewilcome.kmp.sharedui.content.ContentDocumentView

private enum class Screen { Welcome, Home }

@Composable
fun App() {
    var screen by remember { mutableStateOf(Screen.Welcome) }
    val welcomeDoc = remember { SharedApi.getDocument("welcome") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (screen == Screen.Welcome) {
                Button(
                    onClick = { screen = Screen.Home },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Continue")
                }
            }
        }
    ) { innerPadding: PaddingValues ->
        when (screen) {
            Screen.Welcome -> {
                if (welcomeDoc == null) {
                    Text(
                        text = "Welcome (missing shared doc)",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(innerPadding).padding(24.dp)
                    )
                } else {
                    ContentDocumentView(
                        doc = welcomeDoc,
                        contentPadding = PaddingValues(
                            start = 24.dp,
                            top = innerPadding.calculateTopPadding() + 24.dp,
                            end = 24.dp,
                            bottom = 96.dp
                        )
                    )
                }
            }

            Screen.Home -> {
                val a = 10
                val b = 3
                val result = SharedApi.subtract(a, b)

                Text(
                    text = "Home\n\nSharedApi.subtract($a, $b) = $result",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(innerPadding).padding(24.dp)
                )
            }
        }
    }
}
