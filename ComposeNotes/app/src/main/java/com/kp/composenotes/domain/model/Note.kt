package com.kp.composenotes.domain.model

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long
)