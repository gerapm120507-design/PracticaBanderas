package com.example.banderascompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BanderaSuiza(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(Color(0xFFD52B1E))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.2f)
                .fillMaxHeight(0.62f)
                .background(Color.White)
        )

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxHeight(0.2f)
                .fillMaxWidth(0.62f)
                .background(Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSuizaPreview() {
    Surface(modifier = Modifier.size(240.dp)) {
        BanderaSuiza()
    }
}