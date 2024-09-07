import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    text: String
) {
    var expanded by remember { mutableStateOf(false) }

    // Animated height change
    val animatedHeight by animateDpAsState(
        targetValue = if (expanded) 800.dp else 390.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )

    // Scale effect for feedback
    var scale by remember { mutableStateOf(1f) }

    Column(
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .animateContentSize() // Smooth content resizing
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                scale = if (expanded) 1f else 0.97f // Apply scale effect on click
                expanded = !expanded
            }
            .height(animatedHeight)
            .fillMaxWidth()
//            .background(if (expanded) Color(0xFFE8F5E9) else Color.White) // Background color transition
            .scale(scale),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        // Image with rounded corners
        AsyncImage(
            modifier = Modifier
                .height(300.dp)
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth(),
            model = "https://images.pexels.com/photos/1020016/pexels-photo-1020016.jpeg?auto=compress&cs=tinysrgb&w=600",
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = modifier
                .padding(0.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(if (expanded) Color(0xFFE8F5E9) else Color.White)
                .padding(8.dp),
        )
        {
            // Text elements
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                text = "YouTube tar fram verktyg för att upptäcka fejkade AI-grejer",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W300,
                    color = Color.DarkGray
                ),
            )

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 8.dp),
                text = "Wille Wilhelmsson",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.DarkGray,
                    fontStyle = FontStyle.Italic
                ),
            )

            // Animate the appearance of the additional text on expansion
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(animationSpec = spring(stiffness = Spring.StiffnessLow)) + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp), // Background ,
                    text = text,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.DarkGray
                    ),
                )
            }
        }

    }
}
