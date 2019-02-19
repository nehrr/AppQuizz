package com.example.quizz

object Questions {
    val q1: Question = Question("This is test question 1", "Wrong", "Right", "Wrong", "a2")
    val q2: Question = Question("This is test question 2", "Right", "Wrong", "Wrong", "a1")
    val q3: Question = Question("This is test question 3", "Wrong", "Wrong", "Right", "a3")
    val q4: Question = Question("This is test question 4", "Wrong", "Wrong", "Right", "a3")
    val q5: Question = Question("This is test question 5", "Wrong", "Wrong", "Right", "a3")
    val q6: Question = Question("This is test question 6", "Wrong", "Wrong", "Right", "a3")

    var map: HashMap<Int, Question> = hashMapOf(0 to q1, 1 to q2, 2 to q3, 3 to q4, 4 to q5, 5 to q6)
}