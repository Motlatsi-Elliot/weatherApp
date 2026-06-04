package com.example.weatherapp_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import  android.widget.TextView
import android.widget.EditText
import android.widget.LinearLayout
import java.io.DataInput
import java.sql.Date

class MainActivity : AppCompatActivity() {

private lateinit var homeScreen: LinearLayout
private lateinit var forecastDisplay : LinearLayout
private lateinit var forecastBtn : Button
private lateinit var dayInputScreen : LinearLayout
private  lateinit var exitBtn : Button

private lateinit var nxtBtn : Button
private lateinit var  prevBtn : Button
private lateinit var inputDay: EditText
private lateinit var day: TextView
private  lateinit var avTemp: TextView
private  lateinit var conditionsImage: TextView
private lateinit var conditionsText: TextView
private lateinit var minTemp: TextView
private lateinit var maxTemp: TextView


    var notFound = true
    var count = 0
    val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    val minTempArr =  arrayOf("8", "3", "2", "4", "9", "2", "5")

    val maxTempArr = arrayOf("400", "30", "60", "60", "90", "48", "85")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)





        //Declaring variables
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

        forecastBtn.setOnClickListener{
            screenShow(dayInputScreen)
        }

        nxtBtn.setOnClickListener {
            screenShow(forecastDisplay)
            inputDay.text.clear()
        }
    }



    fun screenShow (screenShow: LinearLayout){
        homeScreen.visibility = View.GONE
        forecastDisplay.visibility = View.GONE
        dayInputScreen.visibility = View.GONE
        screenShow.visibility = View.VISIBLE
    }
    val userDay = inputDay.text.toString().trim().lowercase()

    fun loadDay(){
    while (count <= days.size && notFound ) {
        if (userDay == days[count]){
            notFound = false
            showForecast()

        }else{
            count++
        }
      }
    }
    fun showForecast(){
        day.text = days[count]
        val minToInt = minTempArr[count].toInt()
        val maxToInt = maxTempArr[count].toInt()
        val avCalculate = maxToInt / minToInt

        avTemp.text = avCalculate.toString()
        minTemp.text = minToInt.toString()
        maxTemp.text = maxToInt.toString()
    }
}






