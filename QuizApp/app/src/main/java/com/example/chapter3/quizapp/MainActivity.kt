package com.example.chapter3.quizapp

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter3.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val buttonStart = binding.btnStart
        val nameTxt = binding.etName
        buttonStart.setOnClickListener {
            if (nameTxt.text.toString().isEmpty()) {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@MainActivity, QuizQuestionsActivity::class.java)
                intent.putExtra(Constant.USER_NAME, nameTxt.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}