package com.mikewilcome.kmp.sharedui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SharedLanding() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Shared UI (Android only)")
        Text("This module has no JS target.")
    }
}
