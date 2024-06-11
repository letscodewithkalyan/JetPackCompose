package com.kp.mytweet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kp.mytweet.ui.theme.MyTweetTheme
import com.kp.mytweet.utils.Screens
import com.kp.mytweet.views.ShowDetailsView
import com.kp.mytweet.views.ShowView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTweetApp()
        }
    }
}

@Composable
fun MyTweetApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Shows.name
    ) {
        composable(Screens.Shows.name) {
            ShowView()
        }
        composable(
            "${Screens.Details.name}/{showId}",
            arguments = listOf(navArgument("showId") { type = NavType.StringType })
        ) {
            ShowDetailsView()
        }
    }
}