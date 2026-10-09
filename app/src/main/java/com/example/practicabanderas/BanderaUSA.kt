
package com.example.banderascompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaEEUU(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            repeat(13) { index ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(
                            if (index % 2 == 0) {
                                Color(0xFFB22234)
                            } else {
                                Color.White
                            }
                        )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .fillMaxHeight(0.54f)
                .background(Color(0xFF3C3B6E))
        ) {
            Canvas(
                modifier = Modifier.fillMaxSize()
            ) {
                val filas = 9
                val radio = size.width.coerceAtMost(size.height) / 22f

                for (fila in 0 until filas) {
                    val cantidad = if (fila % 2 == 0) 6 else 5

                    for (columna in 0 until cantidad) {
                        val x = if (cantidad == 6) {
                            size.width * (columna + 0.5f) / 6f
                        } else {
                            size.width * (columna + 1f) / 6f
                        }

                        val y = size.height * (fila + 0.5f) / filas

                        val estrella = Path()
                        for (punto in 0 until 10) {
                            val angulo =
                                -PI / 2.0 + punto * PI / 5.0

                            val radioPunto =
                                if (punto % 2 == 0) radio
                                else radio * 0.4f

                            val px =
                                x + cos(angulo).toFloat() * radioPunto
                            val py =
                                y + sin(angulo).toFloat() * radioPunto

                            if (punto == 0) {
                                estrella.moveTo(px, py)
                            } else {
                                estrella.lineTo(px, py)
                            }
                        }

                        estrella.close()

                        drawPath(
                            path = estrella,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEEUUPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        BanderaEEUU()
    }
}