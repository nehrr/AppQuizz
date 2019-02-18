package com.example.quizz

import java.io.Serializable

class Question(question: String, answer1: String, answer2:String, answer3: String, solution: String) : Serializable {
    @Transient var question: String = question
    @Transient var a1: String = answer1
    @Transient var a2: String = answer2
    @Transient var a3: String = answer3
    @Transient var solution: String = solution
}