package com.ecotrack

data class Recyclable(
    val type: String,
    val weight: Double,
    val points: Int = (weight * 10).toInt(),
    val timestamp: Long = System.currentTimeMillis()
)