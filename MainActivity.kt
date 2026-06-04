package com.example.weatherapp_1

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

class MainActivity : AppCompatActivity() {


    /*val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    val minTempArr =  arrayOf(8, 3, 2, 4, 9, 2, 5)

    val maxTempArr = arrayOf(400, 30, 60, 60, 90, 48, 85)*/

    //Declaring variables
    val homeScreen = findViewById<LinearLayout>(R.id.homeScreen)
    val forecastDisplay = findViewById<LinearLayout>(R.id.forecastDisplay)
    val forecastBtn = findViewById<Button>(R.id.forecastBtn)
    val dayInputScreen = findViewById<LinearLayout>(R.id.dayInputScreen)
    val exitBtn = findViewById<Button>(R.id.exitBtn)
    val prevBtn = findViewById<Button>(R.id.prevBtn)
    val nxtBtn = findViewById<Button>(R.id.nxtBtn)
    val inputDay = findViewById<EditText>(R.id.inputDay)
    val day = findViewById<TextView>(R.id.day)
    val avTemp = findViewById<TextView>(R.id.avTemp)
    val conditionsImage = findViewById<TextView>(R.id.conditionsImage)
    val conditionsText = findViewById<TextView>(R.id.conditionsText)
    val minTemp = findViewById<TextView>(R.id.minTemp)
    val maxTemp = findViewById<TextView>(R.id.maxTemp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        showScreen(homeScreen)

    }


    fun setupWelcomeScreen() {
        // Show the welcome screen when the app opens
        showScreen(homeScreen)
        forecastBtn.setOnClickListener {
            /*currentQuestion= 0
            score= 0
            userAnswers= arrayOfNulls(10)*/
            showScreen(homeScreen)//calling the showScreen function to show the question screen
            //All other screens are hidden(visbility set to gone)
            //loadQuestion()//calling the loadQuestion function to load the first question
        }
    }


    fun showScreen(screenToShow: View) {
        forecastDisplay.visibility = View.GONE
        dayInputScreen.visibility= View.GONE
        /*screenReview.visibility= View.GONE*/
        homeScreen.visibility= View.VISIBLE
    }
}



