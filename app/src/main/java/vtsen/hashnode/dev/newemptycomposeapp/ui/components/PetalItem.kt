package vtsen.hashnode.dev.newemptycomposeapp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

private val PetalShape: Shape = GenericShape { size, _ ->

    moveTo(size.width / 2f, 0f)

    cubicTo(
        size.width,
        size.height * 0.18f,
        size.width,
        size.height * 0.75f,
        size.width / 2f,
        size.height
    )

    cubicTo(
        0f,
        size.height * 0.75f,
        0f,
        size.height * 0.18f,
        size.width / 2f,
        0f
    )

    close()
}

@Composable
fun PetalItem(

    petal: Petal,

    modifier: Modifier = Modifier,

    selected: Boolean,

    onClick: () -> Unit

) {

    Surface(

        modifier = modifier
            .clickable {
                onClick()
            }
            .graphicsLayer {

                shadowElevation = 16.dp.toPx()

                shape = PetalShape

                clip = true

            },

        shape = PetalShape,

        border = BorderStroke(
            3.dp,
            Color.White
        ),

        color = Color.Transparent

    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(

                    brush = Brush.verticalGradient(

                        listOf(

                            petal.color.copy(alpha = 0.85f),

                            petal.color

                        )

                    )

                )
                .padding(12.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center

        ) {

            Icon(

                imageVector = petal.icon,

                contentDescription = petal.title,

                tint = Color.White

            )

            Text(

                text = petal.title,

                color = Color.White,

                style = MaterialTheme.typography.bodyMedium,

                fontWeight = FontWeight.Bold,

                textAlign = TextAlign.Center

            )
        }
    }
}
