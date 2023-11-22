package com.example.kmpmovieapiint.android.feature.ui.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpmovieapiint.common.doOnFailure
import com.example.kmpmovieapiint.common.doOnLoading
import com.example.kmpmovieapiint.common.doOnSuccess
import com.example.kmpmovieapiint.data.model.Post
import com.example.kmpmovieapiint.data.repository.PostRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _postResponse: MutableState<PostState> = mutableStateOf(PostState())
    val postResponse: State<PostState> = _postResponse

    init {
        viewModelScope.launch {
            repository.getPosts()
                .doOnSuccess {
                    _postResponse.value = PostState(
                        data = it
                    )
                }
                .doOnFailure {
                    _postResponse.value = PostState(
                        error = it?.message ?: "Something went wrong!"
                    )
                }
                .doOnLoading {
                    _postResponse.value = PostState(
                        isLoading = true
                    )
                }
                .collect()
        }
    }

}

data class PostState(
    val data: List<Post> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)