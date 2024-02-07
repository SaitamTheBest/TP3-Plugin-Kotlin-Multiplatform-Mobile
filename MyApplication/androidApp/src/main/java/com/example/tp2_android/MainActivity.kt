package com.example.tp2_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText


const val NAME_TEXT = "name_text"
const val YEAR_TEXT = "year_text"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton : Button = findViewById(R.id.submitButton)
        val input_name_text : TextInputEditText = findViewById(R.id.input_name_text)
        val input_year_text : TextInputEditText = findViewById(R.id.input_year_text)
        val output_text : TextView = findViewById(R.id.textOutput)

        submitButton.setOnClickListener{
            val intent = Intent(this@MainActivity, NextActivity::class.java)
            intent.putExtra(NAME_TEXT, output_text.text.toString())
            intent.putExtra(YEAR_TEXT, input_year_text.text.toString())
            startActivity(intent)
        }

        input_name_text.addTextChangedListener {
            output_text.text = input_name_text.text
        }

    }
}