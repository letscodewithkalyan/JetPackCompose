package com.kp.mytweet.views

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.kp.mytweet.viewmodels.ShowViewModel

@Composable
fun ShowView(){
    val showViewModel: ShowViewModel = hiltViewModel()
    val shows = showViewModel.shows.collectAsState()
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(shows.value){
            Text(text = it.name)
        }
    }
}