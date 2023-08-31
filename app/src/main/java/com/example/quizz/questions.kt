package com.example.quizz

data class questions(
    val id:Int,
    val question : String,
    val image:Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionfour: String,
    val CorrectOption: Int
)
