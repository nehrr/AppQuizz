package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main_admin.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.question_list_item.*

class MainAdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_admin)

        question_list.layoutManager = LinearLayoutManager(this)
        question_list.adapter = QuestionAdapter(Questions.map, this)
    }

    fun toAdd(view: View) {
        val intent = Intent(this, AdminActivity::class.java).apply {
        }
        startActivity(intent)
    }
}
