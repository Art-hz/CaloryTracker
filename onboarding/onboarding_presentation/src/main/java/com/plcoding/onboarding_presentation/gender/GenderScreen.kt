package com.plcoding.onboarding_presentation.gender

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.core.util.UIEvent
import com.plcoding.core_ui.LocalSpacing

@Composable 
fun GenderScreen(
    onNavigate: (UIEvent.Navigate) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current

    LaunchedEffect(key1 = true) {// key1 puede ser por ejemplo un state lo que significa que cuando cambie el valor de ese state, la corrutina de este LaunchedEffect
        //seria cancelada y relanzada con el nuevo valor del state , si se le pasa true solo se ejecuta 1 vez

    }

}