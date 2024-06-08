package com.kp.mytweet.data.dto

data class ShowDto(
    val averageRuntime: Int,
    val dvdCountry: Any,
    val ended: String,
    val genres: List<String>,
    val id: Int,
    val image: Image,
    val language: String,
    val name: String,
    val officialSite: String,
    val premiered: String,
    val runtime: Int,
    val status: String,
    val type: String,
    val url: String,
    val webChannel: Any,
    val weight: Int
)