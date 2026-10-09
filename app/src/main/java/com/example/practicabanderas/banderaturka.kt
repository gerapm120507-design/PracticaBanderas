package com.example.banderascompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaTurquia(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val rojo = Color(0xFFE30A17)

        drawRect(rojo)

        val cy = h / 2f
        val cx = w * 0.38f
        val radio = h * 0.30f

        drawCircle(Color.White, radio, Offset(cx, cy))
        drawCircle(
            rojo,
            h * 0.24f,
            Offset(cx + h * 0.09f, cy)
        )

        val estrella = Path()
        val centroX = w * 0.68f
        val centroY = cy
        val radioExterior = h * 0.13f
        val radioInterior = radioExterior * 0.42f

        for (i in 0 until 10) {
            val angulo = -PI / 2 + i * PI / 5
            val r = if (i % 2 == 0) radioExterior else radioInterior
            val x = centroX + cos(angulo).toFloat() * r
            val y = centroY + sin(angulo).toFloat() * r

            if (i == 0) estrella.moveTo(x, y)
            else estrella.lineTo(x, y)
        }

        estrella.close()
        drawPath(estrella, Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaTurquiaPreview() {
    Surface(modifier = Modifier.size(width = 320.dp, height = 200.dp)) {
        BanderaTurquia()
    }
}