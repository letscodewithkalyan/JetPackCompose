package com.kp.tvmaze.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kp.tvmaze.QuoteManager
import com.kp.tvmaze.data.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(val quoteManager: QuoteManager) : ViewModel() {
    val _quotesList = MutableStateFlow<List<Quote>>(emptyList())
    val quoteList: StateFlow<List<Quote>>
        get() = _quotesList
    init {
        loadItems()
    }

    fun loadItems(){
        viewModelScope.launch {
            var quotes = quoteManager.getQuotesList("quotes.json")
            _quotesList.emit(quotes.asList());
        }
    }
}