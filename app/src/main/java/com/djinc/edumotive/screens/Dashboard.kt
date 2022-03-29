package com.djinc.edumotive.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.djinc.edumotive.components.LazySlider
import com.djinc.edumotive.components.ScreenTitle
import com.djinc.edumotive.components.SliderComponent
import com.djinc.edumotive.components.SliderDirection
import com.djinc.edumotive.models.Exercise
import com.djinc.edumotive.models.Part
import com.djinc.edumotive.utils.WindowSize

@ExperimentalFoundationApi
@Composable
fun Dashboard(nav: NavController, windowSize: WindowSize) {
    LazyColumn(contentPadding = if (windowSize == WindowSize.Compact) PaddingValues(bottom = 65.dp) else PaddingValues(bottom = 24.dp)) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            ScreenTitle("Welkom!", manualPadding = true)

            val parts = listOf(
                    Part(
                            id = "abcdef",
                            name = "Onderdeel 1",
                            imageUrl = "https://picsum.photos/seed/edumotive-1/400"
                    ),
                    Part(
                            id = "abcdefg",
                            name = "Onderdeel 2",
                            imageUrl = "https://picsum.photos/seed/edumotive-2/400"
                    ),
                    Part(
                            id = "abcdefgh",
                            name = "Onderdeel 3",
                            imageUrl = "https://picsum.photos/seed/edumotive-3/400"
                    ),
                    Part(
                            id = "abcdefghi",
                            name = "Onderdeel 4",
                            imageUrl = "https://picsum.photos/seed/edumotive-4/400"
                    ),
            )
            LazySlider(
                    title = "Recent bekeken onderdelen",
                    titleManualPadding = true,
                    direction = SliderDirection.Horizontal,
                    list = parts,
                    component = SliderComponent.PartCard,
                    nav = nav,
                    windowSize = windowSize
            )

            Spacer(modifier = Modifier.height(36.dp))

            val exercises = listOf(
                    Exercise(
                            id = "abcdef",
                            name = "Oefening 1",
                            imageUrl = "https://picsum.photos/seed/edumotive-9/400/200",
                            description = "Consectetur amet met da adipiscing maecenas. Daia di consectetur amet met."
                    ),
                    Exercise(
                            id = "abcdefg",
                            name = "Oefening 2",
                            imageUrl = "https://picsum.photos/seed/edumotive-10/400/200",
                            description = "Consectetur amet met da adipiscing maecenas. Daia di consectetur amet met."
                    ),
                    Exercise(
                            id = "abcdefgh",
                            name = "Oefening 3",
                            imageUrl = "https://picsum.photos/seed/edumotive-11/400/200",
                            description = "Consectetur amet met da adipiscing maecenas. Daia di consectetur amet met."
                    ),
                    Exercise(
                            id = "abcdefghi",
                            name = "Oefening 4",
                            imageUrl = "https://picsum.photos/seed/edumotive-12/400/200",
                            description = "Consectetur amet met da adipiscing maecenas. Daia di consectetur amet met."
                    ),
            )
            LazySlider(
                    title = "Oefeningen voor dit hoofdstuk",
                    titleManualPadding = true,
                    direction = SliderDirection.Horizontal,
                    list = exercises,
                    component = SliderComponent.ExerciseCard,
                    nav = nav,
                    windowSize = windowSize
            )
        }
    }
}
