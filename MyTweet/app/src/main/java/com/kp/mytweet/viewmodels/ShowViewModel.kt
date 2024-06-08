package com.kp.mytweet.viewmodels

import androidx.lifecycle.ViewModel
import com.kp.mytweet.repository.ShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.kp.mytweet.models.Show
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ShowViewModel @Inject constructor(val showsRepository: ShowsRepository) : ViewModel() {
    val shows: StateFlow<List<Show>>
        get() = showsRepository.shows

    init {
        viewModelScope.launch {
            showsRepository.getShows()
        }
    }
}