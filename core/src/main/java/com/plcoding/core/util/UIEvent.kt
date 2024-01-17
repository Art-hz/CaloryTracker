package com.plcoding.core.util

//en esta clase definiremos toda clase de eventos que puedan suceder entre viewmodels con los composables, como backstack, mostrar un snackbar etc
sealed class UIEvent {
    data class Navigate(val route: String): UIEvent()
    object NavigateUp: UIEvent()
}