package com.example.weatherapp_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var homeScreen: LinearLayout
    private lateinit var forecastDisplay: LinearLayout
    private lateinit var forecastBtn: Button
    private lateinit var dayInputScreen: LinearLayout
    private lateinit var exitBtn: Button
    private lateinit var nxtBtn: Button
    private lateinit var prevBtn: Button
    private lateinit var inputDay: EditText
    private lateinit var day: TextView
    private lateinit var avTemp: TextView
    private lateinit var conditionsImage: TextView
    private lateinit var conditionsText: TextView
    private lateinit var minTemp: TextView
    private lateinit var maxTemp: TextView

    val days = arrayOf("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")
    val minTempArr = arrayOf("8", "3", "2", "4", "9", "2", "5")
    val maxTempArr = arrayOf("18", "14", "12", "16", "20", "13", "17")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        homeScreen = findViewById(R.id.homeScreen)
        forecastDisplay = findViewById(R.id.forecastDisplay)
        forecastBtn = findViewById(R.id.forecastBtn)
        dayInputScreen = findViewById(R.id.dayInputScreen)
        exitBtn = findViewById(R.id.exitBtn)
        prevBtn = findViewById(R.id.prevBtn)
        nxtBtn = findViewById(R.id.nxtBtn)
        inputDay = findViewById(R.id.inputDay)
        day = findViewById(R.id.day)
        avTemp = findViewById(R.id.avTemp)
        conditionsImage = findViewById(R.id.conditionsImage)
        conditionsText = findViewById(R.id.conditionsText)
        minTemp = findViewById(R.id.minTemp)
        maxTemp = findViewById(R.id.maxTemp)

        screenShow(homeScreen)

        forecastBtn.setOnClickListener {
            screenShow(dayInputScreen)
        }

        nxtBtn.setOnClickListener {
            val userDay = inputDay.text.toString().trim().lowercase()

            if (userDay.isEmpty()) {
                Toast.makeText(this, "Please enter a day", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val found = loadDay(userDay)

            if (found) {
                screenShow(forecastDisplay)
                inputDay.text.clear()
            } else {
                Toast.makeText(this, "Day not found. Try e.g. Monday", Toast.LENGTH_SHORT).show()
            }
        }

        exitBtn.setOnClickListener {
            screenShow(homeScreen)
        }

        prevBtn.setOnClickListener {
            screenShow(dayInputScreen)
        }
    }

    fun screenShow(screenToShow: LinearLayout) {
        homeScreen.visibility = View.GONE
        forecastDisplay.visibility = View.GONE
        dayInputScreen.visibility = View.GONE
        screenToShow.visibility = View.VISIBLE
    }

    fun loadDay(userDay: String): Boolean {
        for (i in days.indices) {
            if (userDay == days[i]) {
                showForecast(i)
                return true
            }
        }
        return false
    }

    fun showForecast(index: Int) {
        val minToInt = minTempArr[index].toInt()
        val maxToInt = maxTempArr[index].toInt()
        val avCalculate = (minToInt + maxToInt) / 2

        day.text = days[index].replaceFirstChar { it.uppercase() }
        avTemp.text = "$avCalculate°C"
        minTemp.text = "Min Temp: $minToInt°C"
        maxTemp.text = "Max Temp: $maxToInt°C"

    }
}