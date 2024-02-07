package com.plcoding.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.navigation.Route
import com.plcoding.core.util.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


//con la anotacion @Inject constructor, hilt automaticamente definira esta instancia de preferences que definimos en el objeto AppModule, por lo tanto
//no es necesario que hagamos la instancia manualmente
@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set //de este modo solo se puede cambiar su valor desde el viewmodel

    private val _uiEvent = Channel<UIEvent>() // para informar a nuestros composables de cambios visuales por ejemplo cambiar pantalla, mostrar un msj etc
    //Channel sirve para hacer eventos o acciones una sola vez, y que al ocurrir cambios de config no se repitan como si pasaria con state flow o livedata
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveGender(selectedGender)
            _uiEvent.send(UIEvent.Navigate(Route.AGE))

        }
    }

}