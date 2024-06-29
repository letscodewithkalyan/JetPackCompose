package com.kp.tvmaze.data.dto

data class Schedule(
    val airdate: String,
    val airstamp: String,
    val airtime: String,
    val id: Int,
    val image: Any,
    val name: String,
    val number: Int,
    val rating: Rating,
    val runtime: Int,
    val season: Int,
    val show: ShowX,
    val summary: Any,
    val type: String,
    val url: String
)