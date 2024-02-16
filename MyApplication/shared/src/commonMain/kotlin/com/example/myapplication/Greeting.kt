package com.example.myapplication

class Greeting {
    private val platform: Platform = getPlatform()
    private val ageCalul : AgeCalculator = TODO();

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
    fun getAge(age : String) : Int{
        return ageCalul.calculateAge(age);
    }
}