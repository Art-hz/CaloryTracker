package com.plcoding.onboarding_presentation.weight

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.plcoding.core.base.BaseViewModel
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.navigation.Route
import com.plcoding.core.util.UIEvent
import com.plcoding.core.util.UIText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val preferences: Preferences
): BaseViewModel(){

    var weight by mutableStateOf("80.0")
        private set

    fun onWeightEnter(weight: String) {
        this.weight = weight
    }

    fun onNextClick() {
        viewModelScope.launch {
            val weightNumber = weight.toFloatOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UIEvent.ShowSnackbar(UIText.StringResource(com.plcoding.core.R.string.error_weight_cant_be_empty))
                )
                return@launch
            }
            preferences.saveWeight(weightNumber)
            _uiEvent.send(UIEvent.Navigate(Route.ACTIVITY))
        }
    }
}