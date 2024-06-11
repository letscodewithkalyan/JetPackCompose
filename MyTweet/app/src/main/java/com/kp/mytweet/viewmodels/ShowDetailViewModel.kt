package com.kp.mytweet.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.mytweet.models.Show
import com.kp.mytweet.repository.ShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDetailViewModel @Inject constructor(
    val showsRepository: ShowsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val show: StateFlow<Show>
        get() = showsRepository.show

    init {
        viewModelScope.launch {
            var showId = savedStateHandle.get<Int>("showId") ?: 1
            showsRepository.getShowDetails(showId)
        }
    }
}