package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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

    var opened by remember {
        mutableStateOf(false)
    }

    // گلبرگ انتخاب شده
    var selectedPetal by remember {
        mutableStateOf<Int?>(null)
    }

    LaunchedEffect(Unit) {
        opened = true
    }

    val transition = updateTransition(
        targetState = opened,
        label = "flowerOpening"
    )

    val openingProgress by transition.animateFloat(
        transitionSpec = {
            tween(
                durationMillis = 1800,
                easing = FastOutSlowInEasing
            )
        },
        label = "openingProgress"
    ) { isOpened ->
        if (isOpened) 1f else 0f
    }

    val breathing by rememberInfiniteTransition(
        label = "breathing"
    ).animateFloat(
        initialValue = 0.97f,
        targetValue = 1.03f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "breathing"
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // مرکز گل
        FlowerCanvas(
            selectedPetal = selectedPetal,
            onCenterClick = {
                selectedPetal = null
            }
        )

        val radius = 135f * openingProgress

        petals.forEachIndexed { index, petal ->

            val angle = Math.toRadians(index * 45.0 - 90.0)

            val x = (cos(angle) * radius).dp
            val y = (sin(angle) * radius).dp

            Box(
                modifier = Modifier
                    .offset(x = x, y = y)
                    .graphicsLayer {

                        rotationZ = index * 45f

                        scaleX = openingProgress * breathing
                        scaleY = openingProgress * breathing
                    }
            ) {

                PetalItem(
                    petal = petal,

                    modifier = Modifier.size(
                        width = 96.dp,
                        height = 170.dp
                    ),

                    selected = selectedPetal == index,

                    onClick = {
                        selectedPetal = index
                    }
                )
            }
        }
    }
}
