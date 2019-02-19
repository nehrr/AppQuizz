package com.example.quizz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var ind = 0
    var points: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (Questions.map.size > 0) {

            question.text = Questions.map[this.ind]?.question
            answer1.text = Questions.map[this.ind]?.a1
            answer2.text = Questions.map[this.ind]?.a2
            answer3.text = Questions.map[this.ind]?.a3
            scorePoints.text = this.points.toString()

        } else {

            question.isVisible = false
            answer1.isVisible = false
            answer2.isVisible = false
            answer3.isVisible = false
            answers_label.isVisible = false
            scoreText.isVisible = false
            a1.isVisible = false
            a2.isVisible = false
            a3.isVisible = false

            question_label.text = "There are no questions available"
        }



        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val header = navigationView.getHeaderView(0)
        val name = header.findViewById<TextView>(R.id.username)
        val score = header.findViewById<TextView>(R.id.bestScoreText)

        name.text = "Hello ${User.nickname}"
        score.text = "Personal best: ${User.bestScore}"



        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_profile -> {
                val intent = Intent(this, ProfileActivity::class.java).apply {
            }
                startActivity(intent)
            }
            R.id.nav_admin -> {
                val intent = Intent(this, MainAdminActivity::class.java).apply {
                }
                startActivity(intent)

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun onPushVal(view: View) {
        val name = view.context.resources.getResourceEntryName(view.id)

        if (name == Questions.map[this.ind]?.solution) {
            this.points++
            Toast.makeText(applicationContext, "Good job, you now have ${this.points} points", Toast.LENGTH_SHORT).show()
        } else {
            if (this.points > 0) this.points-- else this.points = 0
            Toast.makeText(applicationContext, "Sorry, you got the wrong answer", Toast.LENGTH_SHORT).show()
        }


        if (this.ind < Questions.map.size -1) {
            this.ind++
        } else {
            this.ind = 0

            if (this.points > User.bestScore) {
                Toast.makeText(applicationContext, "Congrats, you finished the game with ${this.points} and beat your previous high score (${User.bestScore}), your newest high score is ${this.points}", Toast.LENGTH_SHORT).show()
                User.bestScore = this.points

            } else {
                Toast.makeText(applicationContext, "Congrats, you finished the game with ${this.points}, but you did not beat your high score (${User.bestScore}, try harder next time", Toast.LENGTH_SHORT).show()
            }
            this.points = 0
        }

        question.text = Questions.map[this.ind]?.question
        answer1.text = Questions.map[this.ind]?.a1
        answer2.text = Questions.map[this.ind]?.a2
        answer3.text = Questions.map[this.ind]?.a3
        scorePoints.text = this.points.toString()
    }
}
