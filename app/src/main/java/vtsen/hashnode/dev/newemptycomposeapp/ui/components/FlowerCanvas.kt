package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
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

        val petalWidth = size.width * 0.18f
        val petalHeight = size.height * 0.28f

        val petalColors = listOf(
            Color(0xFFE91E63), // خود
            Color(0xFFFF9800), // قابل کنترل
            Color(0xFF4CAF50), // درون ذهنی
            Color(0xFF3F51B5), // هیجانی
            Color(0xFFE91E63), // دیگری
            Color(0xFFFF9800), // اتوماتیک
            Color(0xFF4CAF50), // برون ذهنی
            Color(0xFF3F51B5)  // شناختی
        )

        repeat(8) { index ->

            rotate(
                degrees = index * 45f,
                pivot = center
            ) {

                drawOval(
                    color = petalColors[index],
                    topLeft = Offset(
                        center.x - petalWidth / 2f,
                        center.y - petalHeight
                    ),
                    size = Size(
                        petalWidth,
                        petalHeight
                    )
                )
            }
        }

        drawCircle(
            color = Color.White,
            radius = 42.dp.toPx(),
            center = center
        )

    }
}
