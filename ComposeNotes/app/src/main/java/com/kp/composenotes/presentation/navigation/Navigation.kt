package com.kp.composenotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.kp.composenotes.presentation.ui.AddEditNoteScreen
import com.kp.composenotes.presentation.ui.NoteListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "note_list"
    ) {
        composable("note_list") {
            NoteListScreen(navController = navController)
        }
        composable("add_edit_note") {
            AddEditNoteScreen(navController = navController)
        }
        composable(
            "add_edit_note/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId")
            AddEditNoteScreen(navController = navController, noteId = noteId)
        }
    }
}