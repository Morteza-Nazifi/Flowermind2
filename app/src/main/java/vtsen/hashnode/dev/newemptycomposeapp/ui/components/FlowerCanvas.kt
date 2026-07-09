package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FlowerCanvas() {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        val center = Offset(
            x = size.width / 2f,
            y = size.height / 2f
        )

        drawCircle(
            color = Color.White,
            radius = 42.dp.toPx(),
            center = center
        )
    }
}
