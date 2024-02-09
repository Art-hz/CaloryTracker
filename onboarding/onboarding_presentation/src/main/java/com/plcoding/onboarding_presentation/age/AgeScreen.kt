package com.plcoding.onboarding_presentation.age

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.core.R
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.util.UIEvent
import com.plcoding.core_ui.LocalSpacing
import com.plcoding.onboarding_presentation.components.ActionButton
import com.plcoding.onboarding_presentation.components.SelectableButton
import com.plcoding.onboarding_presentation.components.UnitTextField

@Composable
fun AgeScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: AgeViewModel = hiltViewModel()) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {// key1 puede ser por ejemplo un state lo que significa que cuando cambie el valor de ese state, la corrutina de este LaunchedEffect
        //seria cancelada y relanzada con el nuevo valor del state , si se le pasa true solo se ejecuta 1 vez
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UIEvent.Navigate -> onNavigate(event)
                UIEvent.NavigateUp -> {

                }
                is UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.text.asString(context))
                }
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_age),
                style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(value = viewModel.age, onValueChange = viewModel::onAgeEnter, unit = stringResource(
                id = R.string.years
            ))
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}