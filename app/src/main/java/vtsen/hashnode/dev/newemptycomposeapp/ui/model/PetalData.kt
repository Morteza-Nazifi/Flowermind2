
package vtsen.hashnode.dev.newemptycomposeapp.ui.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class PetalData(
    val id: Int,
    val title: String,
    val icon: ImageVector,
    val color: Color,
    val angle: Float
)
