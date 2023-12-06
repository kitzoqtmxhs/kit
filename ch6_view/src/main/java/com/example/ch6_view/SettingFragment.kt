package com.example.ch6_view

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Calendar

class SettingFragment : Fragment() {
    private lateinit var selectedDateText: TextView
    private var isDailyButtonClicked = false
    private var isWeeklyButtonClicked = false
    private var savedTime: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        val calendarView = view.findViewById<CalendarView>(R.id.calendarView)
        val button1 = view.findViewById<Button>(R.id.dayButton)
        val button2 = view.findViewById<Button>(R.id.weekButton)
        val button3 = view.findViewById<Button>(R.id.monthButton)

        selectedDateText = view.findViewById(R.id.selectedDateText)

        button1.setOnClickListener {
            isDailyButtonClicked = true
            isWeeklyButtonClicked = false
            button1.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
            button2.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            button3.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            selectedDateText.text = ""
            selectedDateText.visibility = if (isDailyButtonClicked) View.VISIBLE else View.GONE
        }

        button2.setOnClickListener {
            isDailyButtonClicked = false
            isWeeklyButtonClicked = true
            button1.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            button2.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
            button3.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            selectedDateText.visibility = if (isDailyButtonClicked) View.VISIBLE else View.GONE

            // CalendarView에서 선택한 날짜 정보 가져오기
            val selectedDateInMillis = calendarView.date
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selectedDateInMillis

            // 해당 달의 주차 정보 계산
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val weekInMonth = calendar.get(Calendar.WEEK_OF_MONTH)

            // 달의 주차 정보 표시
            val selectedWeekInMonth = "${year}년 ${month + 1}월 ${weekInMonth}주"
            selectedDateText.text = selectedWeekInMonth
            selectedDateText.visibility = View.VISIBLE
        }

        button3.setOnClickListener {
            isDailyButtonClicked = false
            isWeeklyButtonClicked = false
            button1.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            button2.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            button3.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
            selectedDateText.visibility = if (isDailyButtonClicked) View.VISIBLE else View.GONE

            // CalendarView에서 선택한 날짜 정보 가져오기
            val selectedDateInMillis = calendarView.date
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selectedDateInMillis

            // 해당 달의 주차 정보 계산
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)

            // 달의 주차 정보 표시
            val selectedMonth = "${year}년 ${month + 1}월"
            selectedDateText.text = selectedMonth
            selectedDateText.gravity = Gravity.CENTER
        }

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            if (isDailyButtonClicked) {
                // 일일 버튼이 클릭된 경우 날짜 정보 표시
                val selectedDate = "${year}년 ${month + 1}월 ${dayOfMonth}일"
                selectedDateText.text = selectedDate
            } else {
                // 주간 또는 월간 버튼이 클릭된 경우 년월 또는 년월주 정보 표시
                if (isWeeklyButtonClicked) {
                    // 주간 버튼이 클릭된 경우
                    val weekInMonth = calendar.get(Calendar.WEEK_OF_MONTH)
                    val selectedWeekInMonth = "${year}년 ${month + 1}월 ${weekInMonth}주"
                    selectedDateText.text = selectedWeekInMonth
                } else {
                    // 월간 버튼이 클릭된 경우
                    val selectedMonth = "${year}년 ${month + 1}월"
                    selectedDateText.text = selectedMonth
                    selectedDateText.gravity = Gravity.CENTER
                }
            }
        }
        return view
    }
}
