package com.kp.mytweet.repository

import com.kp.mytweet.data.api.ShowsAPI
import com.kp.mytweet.data.dto.ShowDto
import com.kp.mytweet.models.Show
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ShowsRepository @Inject constructor(val showsAPI: ShowsAPI) {
    private val _shows = MutableStateFlow<List<Show>>(emptyList());
    val shows: StateFlow<List<Show>>
        get() = _shows

    suspend fun getShows() {
        val result = showsAPI.getShows();
        if (result.isSuccessful) {
            result.body()?.let { shows ->
                _shows.emit(shows.map { it -> Show(it.name, it.image.original) })
            }
        }
    }
}