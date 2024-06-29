package com.kp.tvmaze.data.dto

data class ShowX(
    val _links: LinksX,
    val averageRuntime: Int,
    val dvdCountry: Any,
    val ended: Any,
    val externals: Externals,
    val genres: List<Any>,
    val id: Int,
    val image: Image,
    val language: String,
    val name: String,
    val network: Network,
    val officialSite: String,
    val premiered: String,
    val rating: RatingX,
    val runtime: Int,
    val schedule: ScheduleX,
    val status: String,
    val summary: String,
    val type: String,
    val updated: Int,
    val url: String,
    val webChannel: Any,
    val weight: Int
)