package com.nur.bmi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nur.bmi.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var heightValue: Double = 0.0
    private var weightValue: Double = 0.0
    private var bmi: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val heightEt = binding.heightEt

        binding.heightPlusBtn.setOnClickListener{
            if (heightEt.text.toString().isNotEmpty()) {
                heightValue = heightEt.text.toString().toDouble()
            }
            heightValue++
            heightEt.setText(heightValue.toString())
        }

        binding.heightMinusBtn.setOnClickListener{
            if (heightEt.text.toString().isNotEmpty()) {
                heightValue = heightEt.text.toString().toDouble()
            }
            heightValue--
            heightEt.setText(heightValue.toString())
        }


        val weightEt = binding.weightEt

        binding.weightPlusBtn.setOnClickListener {
            if (weightEt.text.toString().isNotEmpty()){
                weightValue = weightEt.text.toString().toDouble()
            }
            weightValue++
            weightEt.setText(weightValue.toString())
        }
        binding.weightMinusBtn.setOnClickListener {
            if (weightEt.text.toString().isNotEmpty()){
                weightValue = weightEt.text.toString().toDouble()
            }
            weightValue--
            weightEt.setText(weightValue.toString())
        }

        binding.calculateBtn.setOnClickListener {
            val height = heightEt.text.toString().toDouble()
            val weight = weightEt.text.toString().toDouble()
            bmi = (weight/(height.times(height)))
            Toast.makeText(this,"$bmi", Toast.
            LENGTH_LONG).show()
            displayBMIResult(bmi)
        }


//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    private fun displayBMIResult(bmi: Double) {
        var bmiLabel = ""
        var bmiDescription = ""
        when {
            bmi < 18.5 -> {
                bmiLabel = "You are underweight"
                bmiDescription = "You should take better care of yourself! Eat more!"
            }
            bmi in 18.5..24.9 -> {
                bmiLabel = "Normal"
                bmiDescription = "Congratulations! You are in a good shape!"
            }
            bmi in 25.0..29.9 -> {
                bmiLabel = "Overweight"
                bmiDescription = "You really need to take care of yourself! Workout maybe!"
            }
            bmi >= 30.0 -> {
                bmiLabel = "Obese Class"
                bmiDescription = "You might be in a dangerous condition! Act now!"
            }
        }
        val bmiValue = BigDecimal(bmi.toDouble())
        // A This is used to access a String's value from the
        // Activity class.
        binding.resultTv.text = resources.getString(R.string.bmi_result,bmiValue,bmiLabel,bmiDescription)
    }
}