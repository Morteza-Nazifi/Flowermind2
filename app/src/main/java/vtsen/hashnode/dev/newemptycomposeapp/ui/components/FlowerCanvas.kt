package vtsen.hashnode.dev.newemptycomposeapp.ui.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.hypot

@Composable
fun FlowerCanvas(
    selectedPetal: Int?,
    onCenterClick: () -> Unit
) {

    val transition = rememberInfiniteTransition(label = "")

    // شدت نور مرکز گل
    val brightness = transition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

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
            x = size.width / 2f,
            y = size.height / 2f
        )

        val maxRadius = 42.dp.toPx()

        // شعاع انتشار نور
        val glowRadius =
            maxRadius * (0.20f + 0.80f * ((brightness.value - 0.85f) / 0.15f))

        // تعداد حلقه‌ها
        val rings = 32

        for (i in rings downTo 1) {

            val t = i / rings.toFloat()

            val radius = glowRadius * t

            val alpha =
                ((brightness.value + 0.02f) * t * t * 0.28f)
                    .coerceIn(0f, 1f)

            drawCircle(
                color = Color(
                    red = 1f,
                    green = 0.96f,
                    blue = 0.72f,
                    alpha = alpha
                ),
                radius = radius,
                center = center
            )
        }

        // --------
        // رزرو برای موج نور گلبرگ
        // --------
        if (selectedPetal != null) {

            // در مرحله بعد مسیر نور از مرکز
            // تا گلبرگ انتخاب شده اینجا رسم خواهد شد.
        }

        // هسته نورانی
        drawCircle(
            color = Color(
                red = 1f,
                green = 0.98f,
                blue = 0.90f,
                alpha = brightness.value
            ),
            radius = 18.dp.toPx(),
            center = center
        )

        // مرکز سفید گل
        drawCircle(
            color = Color.White.copy(alpha = brightness.value),
            radius = maxRadius,
            center = center
        )
    }
}
