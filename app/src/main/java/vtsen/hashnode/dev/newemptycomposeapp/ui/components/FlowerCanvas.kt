package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.asFrameworkPaint
import androidx.compose.ui.unit.dp

@Composable
fun FlowerCanvas() {

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val glowAlpha = infiniteTransition.animateFloat(
        initialValue = 0.20f,
        targetValue = 0.55f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2200,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        val center = Offset(
            x = size.width / 2f,
            y = size.height / 2f
        )

        // هاله نور
        drawIntoCanvas { canvas ->

            val paint = Paint()

            val frameworkPaint = paint.asFrameworkPaint().apply {
                isAntiAlias = true
                color = android.graphics.Color.argb(
                    (glowAlpha.value * 255).toInt(),
                    255,
                    245,
                    180
                )

                setShadowLayer(
                    70f,
                    0f,
                    0f,
                    android.graphics.Color.argb(
                        (glowAlpha.value * 180).toInt(),
                        255,
                        230,
                        120
                    )
                )
            }

            canvas.nativeCanvas.drawCircle(
                center.x,
                center.y,
                30.dp.toPx(),
                frameworkPaint
            )
        }

        // مرکز گل
        drawCircle(
            color = Color.White,
            radius = 42.dp.toPx(),
            center = center
        )
    }
}
