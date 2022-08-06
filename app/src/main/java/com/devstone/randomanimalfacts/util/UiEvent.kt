package com.devstone.randomanimalfacts.util

sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    object PopBackStack : UiEvent()
}
