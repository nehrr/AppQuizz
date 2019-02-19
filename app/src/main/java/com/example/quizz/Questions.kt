package com.example.quizz

object Questions {
    val q1: Question = Question("Identify the capital city of Ecuador", "Bogotá", "Quito", "Tegucigalpa", "a2")
    val q2: Question = Question("Identify the capital city of Vietnam", "Hanói", "Bangkok", "Vientián", "a1")
    val q3: Question = Question("Identify the capital city of Portugal", "Rome", "Madrid", "Lisbon", "a3")
    val q4: Question = Question("What is the name of a young rabbit?", "Buck", "Cottontail", "Bunny", "a3")
    val q5: Question = Question("What is the name of a young pig?", "Pigeon", "Piglet", "Pigment", "a2")
    val q6: Question = Question("What is the name of a young donkey?", "Foal", "Veal", "Kitten", "a1")

    var map: MutableList<Question> = mutableListOf(q1, q2, q3, q4, q5, q6)
}