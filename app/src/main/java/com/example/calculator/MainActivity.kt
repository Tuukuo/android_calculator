package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etNum1: EditText
    lateinit var etNum2: EditText
    lateinit var btnPlus: Button
    lateinit var btnSubtract: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivide: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        castViews()

        btnPlus.setOnClickListener {
            validate("+")
        }


        btnSubtract.setOnClickListener {
            validate("-")
        }

        btnMultiply.setOnClickListener {
           validate("*")
        }

        btnDivide.setOnClickListener {
            validate("/")
        }


    }

    fun castViews() {
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        btnPlus = findViewById(R.id.btnPlus)
        btnSubtract = findViewById(R.id.btnPlus)
        btnPlus = findViewById(R.id.btnSubtract)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        tvResult = findViewById(R.id.tvResult)
    }
    fun validate(operation: String) {
        val num1 = etNum1.text.toString()
        val num2 = etNum2.text.toString()
        var error = false
        if (num1.isBlank()) {
            error = true
            etNum1.error = "Num1 is required"
        }
        if (num1.isBlank()) {
            error = true
            etNum2.error = "num2 is required"

        }
        if (!error) {
            calculate(num1.toDouble(), num2.toDouble(), operation)
        }
    }

    fun calculate(num1:Double,num2:Double,operation: String) {
        var result = 0.0
        when (operation) {
            "+" -> {
                result = num1 + num2
            }

            "-" -> {
                result = num1 - num2
            }

            "*" -> {
                result = num1 * num2
            }

            "/" -> {
                result = num1 / num2
            }
        }
        tvResult.text=result.toString()
    }
}

