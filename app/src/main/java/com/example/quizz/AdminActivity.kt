package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    var map: MutableList<Question> = Questions.map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
    }

    fun onAdd(view: View) {
        val q: String = questionText.text.toString()
        val a1: String = answer1.text.toString()
        val a2: String = answer2.text.toString()
        val a3: String = answer3.text.toString()
        val checked: Int = radioGroup.checkedRadioButtonId
        var solution: String = ""

        if (checked != -1) {
            solution = view.context.resources.getResourceEntryName(checked)
        }

        if (q != "" && a1 != "" && a2 != "" && a3 != "" && solution != "") {

            val newQ = Question(q, a1, a2, a3, solution)

            map.add(newQ)

            Toast.makeText(applicationContext,"Your question was added!",
                Toast.LENGTH_SHORT).show()

            questionText.setText("")
            answer1.setText("")
            answer2.setText("")
            answer3.setText("")
            radioGroup.clearCheck()

            val intent = Intent(this, MainAdminActivity::class.java).apply {
            }
            startActivity(intent)

        } else {
            Toast.makeText(applicationContext,"You have not filled all the required fields",
                Toast.LENGTH_SHORT).show()
        }
    }
}
