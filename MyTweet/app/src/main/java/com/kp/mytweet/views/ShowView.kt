package com.kp.mytweet.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kp.mytweet.viewmodels.ShowViewModel

@Composable
fun ShowView(){
    val showViewModel: ShowViewModel = hiltViewModel()
    val shows = showViewModel.shows.collectAsState()
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)){
        items(shows.value){
            Card(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)) {
                Column {
                    AsyncImage(model = it.imageURL, contentDescription = "", modifier = Modifier.size(150.dp))
                    Text(text = it.name)
                }
            }
        }
    }
}