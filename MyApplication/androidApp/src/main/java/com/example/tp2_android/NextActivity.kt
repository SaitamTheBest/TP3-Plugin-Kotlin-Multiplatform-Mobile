package com.example.tp2_android

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.Calendar
import java.text.ParseException
import java.util.*

fun getAge(dobString: String): Int {
    var date: Date? = null
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    try {
        date = sdf.parse(dobString)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    if (date == null) return 0

    val dob = Calendar.getInstance()
    val today = Calendar.getInstance()

    dob.time = date

    val year = dob.get(Calendar.YEAR)
    val month = dob.get(Calendar.MONTH)
    val day = dob.get(Calendar.DAY_OF_MONTH)

    dob.set(year, month, day)

    var age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
        age--
    }

    return age
}
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
                    val age = getAge(year)
                    findViewById<TextView>(R.id.main_text).text =
                        "Hello " + name + " vous avez " + age + " ans !"
                }
            }
        }
    }
}