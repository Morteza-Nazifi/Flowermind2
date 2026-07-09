package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Petal(
    val title: String,
    val color: Color,
    val icon: ImageVector
)

val petals = listOf(

    Petal(
        "خود",
        Color(0xFFE91E63),
        Icons.Default.Person
    ),

    Petal(
        "قابل کنترل",
        Color(0xFFFF9800),
        Icons.Default.Build
    ),

    Petal(
        "درون ذهنی",
        Color(0xFF4CAF50),
        Icons.Default.Psychology
    ),

    Petal(
        "هیجانی",
        Color(0xFF3F51B5),
        Icons.Default.Favorite
    ),

    Petal(
        "دیگری",
        Color(0xFFE91E63),
        Icons.Default.Groups
    ),

    Petal(
        "اتوماتیک",
        Color(0xFFFF9800),
        Icons.Default.Autorenew
    ),

    Petal(
        "برون ذهنی",
        Color(0xFF4CAF50),
        Icons.Default.Visibility
    ),

    Petal(
        "شناختی",
        Color(0xFF3F51B5),
        Icons.Default.Lightbulb
    )
)
