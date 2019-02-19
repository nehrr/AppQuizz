package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        hiText.text = "Hey ${User.nickname}"
    }

    fun getToQuestions(view: View) {
            val intent = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(intent)
        }
}
