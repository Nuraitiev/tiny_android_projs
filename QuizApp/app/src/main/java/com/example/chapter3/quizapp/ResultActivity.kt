package com.example.chapter3.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter3.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tvName: TextView = binding.tvName
        val tvScore: TextView = binding.tvScore
        val btnFinish: Button = binding.btnFinish

        val userName = intent.getStringExtra(Constant.USER_NAME)
        tvName.text = userName

        val totalQuestions = intent.getIntExtra(Constant.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constant.CORRECT_ANSWERS, 0)

        tvScore.text = resources.getString(R.string.score, correctAnswers, totalQuestions)

        btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }


    }
}