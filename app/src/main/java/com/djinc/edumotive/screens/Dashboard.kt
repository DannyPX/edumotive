package com.djinc.edumotive.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.djinc.edumotive.R
import com.djinc.edumotive.components.LazySlider
import com.djinc.edumotive.components.ScreenTitle
import com.djinc.edumotive.components.SliderComponent
import com.djinc.edumotive.components.SliderDirection
import com.djinc.edumotive.models.ViewModels
import com.djinc.edumotive.utils.WindowSize

@ExperimentalFoundationApi
@Composable
fun Dashboard(nav: NavController, windowSize: WindowSize, viewModels: ViewModels) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = if (windowSize == WindowSize.Compact) 65.dp else 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Spacer(modifier = Modifier.height(12.dp))
        }
        item {
            ScreenTitle(
                title = stringResource(R.string.welcome),
                languageButton = true,
                manualPadding = true,
                spacerHeight = 0,
                windowSize = windowSize,
                viewModels = viewModels
            )
        }
        item {
            LazySlider(
                title = stringResource(R.string.recent_updated),
                titleManualPadding = true,
                direction = SliderDirection.Horizontal,
                list = viewModels.models,
                component = SliderComponent.PartCard,
                nav = nav,
                windowSize = windowSize,
                viewModels = viewModels
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))

            LazySlider(
                title = stringResource(R.string.exercises_this_chapter),
                titleManualPadding = true,
                direction = SliderDirection.Horizontal,
                list = viewModels.exercises,
                component = SliderComponent.ExerciseCard,
                nav = nav,
                windowSize = windowSize,
                viewModels = viewModels
            )
        }
    }
}
