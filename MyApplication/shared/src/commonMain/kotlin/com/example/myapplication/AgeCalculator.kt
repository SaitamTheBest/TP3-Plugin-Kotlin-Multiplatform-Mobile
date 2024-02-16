package com.example.myapplication
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class AgeCalculator {
    fun calculateAge(input: String): Int {
        val yearOfBirth = input.split(";").last().toInt()
        val currentYear = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).year
        return currentYear - yearOfBirth
    }
}