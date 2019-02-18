package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    var nickname: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nickname = intent.getStringExtra("nickname")
        this.nickname = nickname

        profileName.text = nickname

        rv_animal_list.layoutManager = LinearLayoutManager(this)
        rv_animal_list.adapter = QuestionAdapter(Questions.map, this)
    }
}