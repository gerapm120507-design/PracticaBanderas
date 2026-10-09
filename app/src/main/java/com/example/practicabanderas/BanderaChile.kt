
package com.example.banderascompose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaChile(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color(0xFFD52B1E))
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(1f / 3f)
                .fillMaxHeight(0.5f)
                .background(Color(0xFF0039A6)),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier.size(48.dp)
            ) {
                val radioExterior = size.minDimension / 2f
                val radioInterior = radioExterior * 0.4f

                val centroX = size.width / 2f
                val centroY = size.height / 2f

                val estrella = Path()

                for (punto in 0 until 10) {
                    val angulo =
                        -PI / 2.0 + punto * PI / 5.0

                    val radio = if (punto % 2 == 0) {
                        radioExterior
                    } else {
                        radioInterior
                    }

                    val x = centroX +
                            cos(angulo).toFloat() * radio

                    val y = centroY +
                            sin(angulo).toFloat() * radio

                    if (punto == 0) {
                        estrella.moveTo(x, y)
                    } else {
                        estrella.lineTo(x, y)
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

@Preview(showBackground = true)
@Composable
fun BanderaChilePreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        BanderaChile()
    }
}