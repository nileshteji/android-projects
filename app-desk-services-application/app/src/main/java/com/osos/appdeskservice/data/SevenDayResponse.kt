package com.osos.appdeskservice.data

data class SevenDayResponse(
    var daily: List<Daily>
)

data class Daily(
    var dt : Long,
    var temp: Details
)

data class Details(
    var day: Double
)