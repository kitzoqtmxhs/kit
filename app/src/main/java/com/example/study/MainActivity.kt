package com.example.study

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var selectedDateText: TextView
    private var isDailyButtonClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val button1 = findViewById<Button>(R.id.dayButton)
        val button2 = findViewById<Button>(R.id.weekButton)
        val button3 = findViewById<Button>(R.id.monthButton)

        selectedDateText = findViewById(R.id.selectedDateText)

        button1.setOnClickListener {
            isDailyButtonClicked = true
            button1.setTextColor(ContextCompat.getColor(this, R.color.blue))
            button2.setTextColor(ContextCompat.getColor(this, R.color.black))
            button3.setTextColor(ContextCompat.getColor(this, R.color.black))
            selectedDateText.text = ""
            selectedDateText.visibility = if (isDailyButtonClicked) View.VISIBLE else View.GONE
        }

        button2.setOnClickListener {
            isDailyButtonClicked = false
            button1.setTextColor(ContextCompat.getColor(this, R.color.black))
            button2.setTextColor(ContextCompat.getColor(this, R.color.blue))
            button3.setTextColor(ContextCompat.getColor(this, R.color.black))
            selectedDateText.visibility = if (isDailyButtonClicked) View.VISIBLE else View.GONE
        }

        button3.setOnClickListener {
            isDailyButtonClicked = false
            button1.setTextColor(ContextCompat.getColor(this, R.color.black))
            button2.setTextColor(ContextCompat.getColor(this, R.color.black))
            button3.setTextColor(ContextCompat.getColor(this, R.color.blue))
            selectedDateText.visibility = if (isDailyButtonClicked) View.VISIBLE else View.GONE
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            if (isDailyButtonClicked) {
                val selectedDate = "${year}년 ${month + 1}월 ${dayOfMonth}일"
                selectedDateText.text = "$selectedDate"
                selectedDateText.visibility = if (isDailyButtonClicked) View.VISIBLE else View.GONE
            }
        }
    }
}