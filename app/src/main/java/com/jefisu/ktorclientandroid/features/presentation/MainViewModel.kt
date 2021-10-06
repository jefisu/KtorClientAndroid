package com.jefisu.ktorclientandroid.features.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jefisu.ktorclientandroid.features.domain.use_cases.DigimonUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val digimonUseCases: DigimonUseCases
) : ViewModel() {

    private val _state = mutableStateOf(DigimonState())
    val state: State<DigimonState> = _state

    init {
        getDigimons()
    }

    private fun getDigimons() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                digimons = digimonUseCases.getDigimons(),
                isLoading = false
            )
        }
    }
}