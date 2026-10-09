package com.example.banderascompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaCuba(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val banda = h / 5f
        val azul = Color(0xFF002A8F)
        val rojo = Color(0xFFCF142B)

        drawRect(Color.White)

        for (i in 0 until 5) {
            if (i % 2 == 0) {
                drawRect(
                    color = azul,
                    topLeft = Offset(0f, i * banda),
                    size = Size(w, banda)
                )
            }
        }

        val anchoTriangulo = w * 0.40f
        val triangulo = Path().apply {
            moveTo(0f, 0f)
            lineTo(anchoTriangulo, h / 2f)
            lineTo(0f, h)
            close()
        }
        drawPath(triangulo, rojo)

        val cx = anchoTriangulo * 0.38f
        val cy = h / 2f
        val radioExterior = h * 0.16f
        val radioInterior = radioExterior * 0.42f
        val estrella = Path()

        for (i in 0 until 10) {
            val angulo = -PI / 2 + i * PI / 5
            val r = if (i % 2 == 0) radioExterior else radioInterior
            val x = cx + cos(angulo).toFloat() * r
            val y = cy + sin(angulo).toFloat() * r

            if (i == 0) estrella.moveTo(x, y)
            else estrella.lineTo(x, y)
        }

        estrella.close()
        drawPath(estrella, Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaCubaPreview() {
    Surface(modifier = Modifier.size(width = 320.dp, height = 200.dp)) {
        BanderaCuba()
    }
}