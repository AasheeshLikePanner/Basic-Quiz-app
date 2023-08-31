package com.example.quizz

object Details {

    var ans:String = "this"

    fun getQuestions():ArrayList<questions>{
        val list = ArrayList<questions>();
        val q1 = questions(
            1, "What is the name of this t-shirt"
            , R.drawable.tshirt2,"Supreme",
            "Follow devil", "Follow God",
            "Nike devil", 3
        )

        val q2 = questions(2,"What is the name of this t-shirt",

            R.drawable.black, "Lucky me",
            "Ghost me", "HandDrawn Ghost"
            ,"Ghost with me", 2
            )
        val q3 = questions(
            1, "What is the name of this t-shirt"
            , R.drawable.tshirt2,"Supreme",
            "Follow devil", "Follow God",
            "Nike devil", 3
        )
        list.add(q1)
        list.add(q2)
        list.add(q3)
        return list
    }
}