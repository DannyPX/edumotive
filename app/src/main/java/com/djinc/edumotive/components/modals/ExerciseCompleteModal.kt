package com.djinc.edumotive.components.modals

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djinc.edumotive.R
import com.djinc.edumotive.ui.theme.Background
import com.djinc.edumotive.ui.theme.DarkOverlay
import com.djinc.edumotive.ui.theme.PinkPrimary
import com.djinc.edumotive.ui.theme.fonts

@Composable
fun ExerciseCompleteModal(backCallback: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(
                DarkOverlay
            )
            .clickable(indication = null, interactionSource = interactionSource) {}
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Background)
                .padding(16.dp)
                .width(260.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Goed gedaan!",
                    fontFamily = fonts,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_exercise_passed),
                        contentDescription = "exercise completion svg",
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        val dpBetween = 10.dp
                        Text(
                            "92%",
                            fontFamily = fonts,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 38.sp,
                            modifier = Modifier.offset(y = dpBetween)
                        )
                        Text(
                            "Correct",
                            fontFamily = fonts,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            modifier = Modifier.offset(y = -dpBetween)
                        )
                    }
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                        .height(42.dp)
                        .background(
                            PinkPrimary
                        )
                        .clickable { backCallback.invoke() }
                ) {
                    Text(
                        "Terug naar oefeningen",
                        fontFamily = fonts,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = Background
                    )
                }
            }
        }
    }
}