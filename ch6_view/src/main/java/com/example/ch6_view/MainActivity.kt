package com.example.ch6_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //객체 생성
        val statusText: TextView = findViewById(R.id.status_text)
        val switchView: SwitchCompat = findViewById(R.id.switchView)

        //switch 체크 이벤트
        switchView.setOnCheckedChangeListener { p0, isChecked ->
            if (isChecked) {
                statusText.text = "앱 잠금 실행 중"
            } else {
                statusText.text = "앱 잠금이 실행중이지 않아요"
            }
        }
    }//onCreate
}