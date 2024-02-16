package com.example.tp2_android

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Greeting

class NextActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val intent = intent

        if (intent != null){
            val name = intent.getStringExtra(NAME_TEXT)
            val year = intent.getStringExtra(YEAR_TEXT)
            if (name?.isEmpty() == true || year?.isEmpty() == true){
                findViewById<TextView>(R.id.main_text).text = "Erreur"
            }
            else {
                if (year != null) {
                    val age = Greeting.getAge(year)
                    findViewById<TextView>(R.id.main_text).text =
                        "Hello " + name + " vous avez " + age + " ans !"
                }
            }
        }
    }
}