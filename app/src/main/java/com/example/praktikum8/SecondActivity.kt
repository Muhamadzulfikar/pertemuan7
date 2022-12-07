package com.example.praktikum8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnClick2 = findViewById<Button>(R.id.btnClick2)

        btnClick2.setOnClickListener{
            finish()
        }

    }
}