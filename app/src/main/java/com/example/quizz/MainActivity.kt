package com.example.quizz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.HashMap

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var ind: Int = 1
    var points: Int = 0
    var nickname: String = ""
    val q1: Question = Question("This is test question 1", "Wrong", "Right", "Wrong", "a2")
    val q2: Question = Question("This is test question 2", "Right", "Wrong", "Wrong", "a1")
    val q3: Question = Question("This is test question 3", "Wrong", "Wrong", "Right", "a3")
    val q4: Question = Question("This is test question 4", "Wrong", "Wrong", "Right", "a3")
    val q5: Question = Question("This is test question 5", "Wrong", "Wrong", "Right", "a3")
    val q6: Question = Question("This is test question 6", "Wrong", "Wrong", "Right", "a3")

    val map = Questions.map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val nickname = intent.getStringExtra("nickname")
        this.nickname = nickname
        question.text = map[this.ind]?.question
        answer1.text = map[this.ind]?.a1
        answer2.text = map[this.ind]?.a2
        answer3.text = map[this.ind]?.a3
        scorePoints.text = this.points.toString()

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

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
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_profile -> {
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    val profileName = nickname
                    putExtra("nickname", nickname)
            }
                startActivity(intent)
            }
            R.id.nav_admin -> {
                val intent = Intent(this, AdminActivity::class.java).apply {
                }
                startActivity(intent)

            }

            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun onPushVal(view: View) {
        val name = view.context.resources.getResourceEntryName(view.id)

        if (name == map[this.ind]?.solution) {
            this.points++
            Toast.makeText(applicationContext, "Good job, you now have ${this.points} points", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Sorry, you got the wrong answer", Toast.LENGTH_SHORT).show()
        }


        if (this.ind < map.size) {
            this.ind++
        } else {
            this.ind = 1
            Toast.makeText(applicationContext, "Congrats, you finished the game with ${this.points} points", Toast.LENGTH_SHORT).show()
            this.points = 0
        }

        question.text = map[this.ind]?.question
        answer1.text = map[this.ind]?.a1
        answer2.text = map[this.ind]?.a2
        answer3.text = map[this.ind]?.a3
        scorePoints.text = this.points.toString()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 1) {
            if (resultCode === RESULT_OK) {
                val nickname = data!!.getStringExtra("nickname")
                this.nickname = nickname
            }
        }
    }
}
