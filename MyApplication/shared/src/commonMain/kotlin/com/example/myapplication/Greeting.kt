package com.example.myapplication

class Greeting {
    private val platform: Platform = getPlatform()
    private val ageCalul : AgeCalculator = AgeCalculator();

    fun greet(input : String): String {
        return "Hello " + input.split(";").first() + " vous avez " + ageCalul.calculateAge(input) + " ans !";
    }
}