package com.plcoding.core.base

import androidx.lifecycle.ViewModel
import com.plcoding.core.util.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

open class BaseViewModel: ViewModel() {
    val _uiEvent = Channel<UIEvent>() // para informar a nuestros composables de cambios visuales por ejemplo cambiar pantalla, mostrar un msj etc
    //Channel sirve para hacer eventos o acciones una sola vez, y que al ocurrir cambios de config no se repitan como si pasaria con state flow o livedata
    val uiEvent = _uiEvent.receiveAsFlow()


}