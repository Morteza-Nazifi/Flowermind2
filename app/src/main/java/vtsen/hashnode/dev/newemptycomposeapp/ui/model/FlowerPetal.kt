package vtsen.hashnode.dev.newemptycomposeapp.ui.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class FlowerPetal(
    val title: String,
    val color1: Color,
    val color2: Color,
    val icon: ImageVector,
    val angle: Float
)
