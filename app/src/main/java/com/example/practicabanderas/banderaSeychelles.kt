
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

@Composable
fun BanderaSeychelles(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val origen = Offset(0f, h)

        fun poligono(puntos: List<Offset>): Path {
            return Path().apply {
                moveTo(origen.x, origen.y)
                puntos.forEach { lineTo(it.x, it.y) }
                close()
            }
        }

        drawRect(Color(0xFFD42828))

        drawPath(
            poligono(
                listOf(
                    Offset(0f, 0f),
                    Offset(w * 0.20f, 0f)
                )
            ),
            Color(0xFF003F87)
        )

        drawPath(
            poligono(
                listOf(
                    Offset(w * 0.20f, 0f),
                    Offset(w * 0.42f, 0f)
                )
            ),
            Color(0xFFFCD856)
        )

        drawPath(
            poligono(
                listOf(
                    Offset(w * 0.42f, 0f),
                    Offset(w * 0.72f, 0f),
                    Offset(w, h * 0.22f)
                )
            ),
            Color(0xFFD62828)
        )

        drawPath(
            poligono(
                listOf(
                    Offset(w, h * 0.22f),
                    Offset(w, h * 0.58f)
                )
            ),
            Color.White
        )

        drawPath(
            poligono(
                listOf(
                    Offset(w, h * 0.58f),
                    Offset(w, h),
                    Offset(0f, h)
                )
            ),
            Color(0xFF007A3D)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSeychellesPreview() {
    Surface(
        modifier = Modifier.size(
            width = 320.dp,
            height = 200.dp
        )
    ) {
        BanderaSeychelles()
    }
}