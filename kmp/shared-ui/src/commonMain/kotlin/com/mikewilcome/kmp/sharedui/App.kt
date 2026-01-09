package com.mikewilcome.kmp.sharedui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikewilcome.kmp.SharedApi

@Composable
fun App() {
    val a = 10
    val b = 3
    val result = SharedApi.subtract(a, b)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding: PaddingValues ->
            Text(
                text = "SharedApi.subtract($a, $b) = $result",
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(24.dp)
            )
        }
    )
}
