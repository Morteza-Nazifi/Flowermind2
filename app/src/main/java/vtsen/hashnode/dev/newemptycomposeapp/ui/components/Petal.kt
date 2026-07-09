package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.AutomaticPetal
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.CognitionPetal
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.ControlPetal
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.EmotionPetal
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.InnerMindPetal
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.OtherPetal
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.OuterMindPetal
import vtsen.hashnode.dev.newemptycomposeapp.ui.theme.SelfPetal

data class Petal(
    val id: Int,
    val title: String,
    val color: Color,
    val icon: ImageVector
)

val petals = listOf(

    Petal(
        id = 0,
        title = "خود",
        color = SelfPetal,
        icon = Icons.Default.Person
    ),

    Petal(
        id = 1,
        title = "قابل کنترل",
        color = ControlPetal,
        icon = Icons.Default.Build
    ),

    Petal(
        id = 2,
        title = "درون ذهنی",
        color = InnerMindPetal,
        icon = Icons.Default.Psychology
    ),

    Petal(
        id = 3,
        title = "هیجانی",
        color = EmotionPetal,
        icon = Icons.Default.Favorite
    ),

    Petal(
        id = 4,
        title = "دیگری",
        color = OtherPetal,
        icon = Icons.Default.Groups
    ),

    Petal(
        id = 5,
        title = "اتوماتیک",
        color = AutomaticPetal,
        icon = Icons.Default.Autorenew
    ),

    Petal(
        id = 6,
        title = "برون ذهنی",
        color = OuterMindPetal,
        icon = Icons.Default.Visibility
    ),

    Petal(
        id = 7,
        title = "شناختی",
        color = CognitionPetal,
        icon = Icons.Default.Lightbulb
    )
)
