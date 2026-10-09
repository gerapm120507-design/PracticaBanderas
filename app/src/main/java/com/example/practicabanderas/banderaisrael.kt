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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private fun crearTriangulo(
    cx: Float,
    cy: Float,
    radio: Float,
    rotacion: Float
): Path {
    return Path().apply {
        for (i in 0..2) {
            val angulo = (rotacion + i * 120f) * PI / 180.0
            val x = cx + radio * cos(angulo).toFloat()
            val y = cy + radio * sin(angulo).toFloat()

            if (i == 0) moveTo(x, y) else lineTo(x, y)
        }
        close()
    }
}

@Composable
fun BanderaIsrael(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val azul = Color(0xFF0038B8)

        drawRect(Color.White)

        drawRect(
            color = azul,
            topLeft = Offset(0f, h * 0.16f),
            size = androidx.compose.ui.geometry.Size(w, h * 0.10f)
        )
        drawRect(
            color = azul,
            topLeft = Offset(0f, h * 0.74f),
            size = androidx.compose.ui.geometry.Size(w, h * 0.10f)
        )

        val cx = w / 2f
        val cy = h / 2f
        val radio = h * 0.25f

        drawPath(
            path = crearTriangulo(cx, cy, radio, -90f),
            color = azul,
            style = Stroke(width = h * 0.035f)
        )
        drawPath(
            path = crearTriangulo(cx, cy, radio, 90f),
            color = azul,
            style = Stroke(width = h * 0.035f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaIsraelPreview() {
    Surface(modifier = Modifier.size(width = 320.dp, height = 200.dp)) {
        BanderaIsrael()
    }
}