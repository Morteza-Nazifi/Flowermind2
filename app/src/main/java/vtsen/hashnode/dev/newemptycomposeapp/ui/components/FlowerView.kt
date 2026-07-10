package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun FlowerView() {

    var bloom by remember {
        mutableFloatStateOf(0f)
    }

    LaunchedEffect(Unit) {
        bloom = 1f
    }

    val progress by animateFloatAsState(
        targetValue = bloom,
        animationSpec = tween(
            durationMillis = 1400,
            easing = FastOutSlowInEasing
        ),
        label = "BloomAnimation"
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        FlowerCanvas()

        val radius = 135f * progress

        petals.forEachIndexed { index, petal ->

            val angle = Math.toRadians(index * 45.0 - 90.0)

            val x = (cos(angle) * radius).dp
            val y = (sin(angle) * radius).dp

            Box(
                modifier = Modifier
                    .offset(x = x, y = y)
                    .graphicsLayer {
                        rotationZ = index * 45f

                        scaleX = 0.25f + progress * 0.75f
                        scaleY = 0.25f + progress * 0.75f

                        alpha = progress
                    }
            ) {

                PetalItem(
                    petal = petal,
                    modifier = Modifier.size(
                        width = 96.dp,
                        height = 170.dp
                    )
                )

            }
        }
    }
}
