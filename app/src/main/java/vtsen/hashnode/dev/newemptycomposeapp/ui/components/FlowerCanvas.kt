package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

@Composable
fun FlowerCanvas(
    selectedPetal: Int?,
    waveTrigger: Int,
    onCenterClick: () -> Unit
) {

    val transition = rememberInfiniteTransition(label = "")

    val brightness = transition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    val waveProgress = remember {
        Animatable(0f)
    }

    LaunchedEffect(waveTrigger) {

        waveProgress.snapTo(0f)

        waveProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 700,
                easing = FastOutSlowInEasing
            )
        )
    }

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {

                detectTapGestures { offset ->

                    val center = Offset(
                        size.width / 2f,
                        size.height / 2f
                    )

                    val radius = 42.dp.toPx()

                    if (
                        hypot(
                            offset.x - center.x,
                            offset.y - center.y
                        ) <= radius
                    ) {
                        onCenterClick()
                    }
                }
            }
    ) {

        val center = Offset(
            size.width / 2f,
            size.height / 2f
        )

        val maxRadius = 42.dp.toPx()

        val glowRadius =
            maxRadius *
                (
                    0.20f +
                        0.80f *
                        ((brightness.value - 0.85f) / 0.15f)
                    )

        val rings = 32

        for (i in rings downTo 1) {

            val t = i / rings.toFloat()

            drawCircle(
                color = Color(
                    red = 1f,
                    green = 0.88f,
                    blue = 0.18f,
                    alpha =
                        (
                            (brightness.value + 0.08f) *
                                t *
                                t *
                                0.34f
                            ).coerceIn(0f, 1f)
                ),
                radius = glowRadius * t,
                center = center
            )
        }

        // موج نور

        if (selectedPetal != null) {

            val angle =
                Math.toRadians(
                    selectedPetal * 45.0 - 90.0
                )

            val petalRadius = 135.dp.toPx()

            val destination = Offset(
                x = center.x +
                    cos(angle).toFloat() * petalRadius,
                y = center.y +
                    sin(angle).toFloat() * petalRadius
            )

            val current = Offset(
                x = center.x +
                    (destination.x - center.x) *
                    waveProgress.value,

                y = center.y +
                    (destination.y - center.y) *
                    waveProgress.value
            )

            drawLine(
                color = Color(
                    red = 1f,
                    green = 0.96f,
                    blue = 0.45f,
                    alpha = 0.75f
                ),
                start = center,
                end = current,
                strokeWidth = 7.dp.toPx(),
                cap = StrokeCap.Round
            )

            drawCircle(
                color = Color(
                    red = 1f,
                    green = 0.98f,
                    blue = 0.60f,
                    alpha = 1f
                ),
                radius = 8.dp.toPx(),
                center = current
            )
        }

        // -------------------------
        // مرکز خورشیدی
        // -------------------------

        // هاله طلایی

        drawCircle(
            color = Color(
                red = 1f,
                green = 0.84f,
                blue = 0.12f,
                alpha = 0.55f * brightness.value
            ),
            radius = 42.dp.toPx(),
            center = center
        )

        // هسته خورشید

        drawCircle(
            color = Color(
                red = 1f,
                green = 0.92f,
                blue = 0.20f,
                alpha = brightness.value
            ),
            radius = 26.dp.toPx(),
            center = center
        )

        // نقطه مرکزی بسیار روشن

        drawCircle(
            color = Color(
                red = 1f,
                green = 0.98f,
                blue = 0.70f,
                alpha = brightness.value
            ),
            radius = 13.dp.toPx(),
            center = center
        )
    }
}
