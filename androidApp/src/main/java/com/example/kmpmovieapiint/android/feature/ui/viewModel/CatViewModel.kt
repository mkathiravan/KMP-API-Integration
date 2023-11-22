package com.example.kmpmovieapiint.android.feature.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpmovieapiint.data.model.Cat
import com.example.kmpmovieapiint.data.repository.CatRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CatViewModel constructor(
    private val repository: CatRepository
) : ViewModel() {
    private val _catResponse: MutableState<CatState> = mutableStateOf(CatState())
    val catResponse: State<CatState> = _catResponse

    init {
        viewModelScope.launch {
            repository.getCats()
                .onStart {
                    _catResponse.value = CatState(isLoading = true)
                }.catch {
                    _catResponse.value = CatState(error = it.message ?: "Something went wrong!")
                }.collect {
                    _catResponse.value = CatState(data = it)
                }
        }
    }
}


data class CatState(
    val data: List<Cat> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)