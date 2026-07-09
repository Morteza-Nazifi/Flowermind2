package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun FlowerView() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // مرکز گل
        FlowerCanvas()

        val radius = 135f

        petals.forEachIndexed { index, petal ->

            val angle = Math.toRadians(index * 45.0 - 90.0)

            val x = (cos(angle) * radius).dp
            val y = (sin(angle) * radius).dp

            Box(
                modifier = Modifier
                    .offset(x = x, y = y)
                    .graphicsLayer {
                        rotationZ = index * 45f
                    }
            ) {

                PetalItem(
                    petal = petal,
                    PetalItem = Modifier.size(
                        width = 96.dp,
                        height = 170.dp
                    )
                )

            }
        }
    }
}
