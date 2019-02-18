package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    var map: HashMap<Int, Question> = Questions.map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(applicationContext," On checked change : ${radio.text}",
                Toast.LENGTH_SHORT).show()
        }

    }

    fun onAdd(view: View) {
        val q: String = questionText.text.toString()
        val a1: String = answer1.text.toString()
        val a2: String = answer2.text.toString()
        val a3: String = answer3.text.toString()
        val checked = radioGroup.checkedRadioButtonId
        val solution: String = view.context.resources.getResourceEntryName(checked)


        val newQ = Question(q, a1, a2, a3, solution)
        var idx = map.size
        idx++

        map.put(idx, newQ)
    }
}
