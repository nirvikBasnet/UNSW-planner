package dev.nirvik.unswplanner.models

import kotlinx.serialization.Serializable

@Serializable
data class Calendar(
    val term: String,
    val calendar: List<Week>,
)

@Serializable
data class Week(
    val week: Int,
    val days: List<Day>
)

@Serializable
data class Day(
    val day: Int,
    val month: Int,
    val weekday: String,
    val event: String
)
