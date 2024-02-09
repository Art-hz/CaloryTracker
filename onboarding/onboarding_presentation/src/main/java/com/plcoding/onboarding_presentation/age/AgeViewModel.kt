package com.plcoding.onboarding_presentation.age

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.base.BaseViewModel
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.domain.use_case.FilterOutDigits
import com.plcoding.core.navigation.Route
import com.plcoding.core.util.UIEvent
import com.plcoding.core.util.UIText
import com.plcoding.onboarding_presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgeViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterDigits: FilterOutDigits
): BaseViewModel(){

    var age by mutableStateOf("2")
        private set

    fun onAgeEnter(age: String) {
        //logica de negocio como por ejemplo filtrar solo numeros para la edad se debe hacer en casos de uso
        if(age.length <= 3){
            this.age = filterDigits(age)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val ageNumber = age.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UIEvent.ShowSnackbar(UIText.StringResource(com.plcoding.core.R.string.error_age_cant_be_empty))
                )
                return@launch
            }
            preferences.saveAge(ageNumber)
            _uiEvent.send(UIEvent.Navigate(Route.HEIGHT))
        }
    }
}