package com.kp.mytweet.repository

import com.kp.mytweet.data.api.ShowsAPI
import com.kp.mytweet.data.dto.ShowDto
import com.kp.mytweet.models.Show
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ShowsRepository @Inject constructor(val showsAPI: ShowsAPI) {
    private val _shows = MutableStateFlow<List<Show>>(emptyList());
    private val _show = MutableStateFlow<Show>(Show("", ""));

    val shows: StateFlow<List<Show>>
        get() = _shows
    val show: StateFlow<Show>
        get() = _show

    suspend fun getShows() {
        val result = showsAPI.getShows();
        if (result.isSuccessful) {
            result.body()?.let { shows ->
                _shows.emit(shows.map { it -> Show(it.name, it.image.original) })
            }
        }
    }

    suspend fun getShowDetails(showId: Int) {
        val result = showsAPI.getShowDetails(showId);
        if (result.isSuccessful) {
            result.body()?.let { show ->
                {
                    _show.tryEmit(Show(show.name, show.image.original))
                }
            }
        }
    }
}