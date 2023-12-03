package com.example.ch6_view

import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat


class MainActivity : AppCompatActivity(){

    var imageView: ImageView? = null
    var toggleButton: ToggleButton? = null
    var aSwitch: Switch? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //객체 생성
        val statusText: TextView = findViewById(R.id.status_text)
        val switchView: SwitchCompat = findViewById(R.id.switchView)
        val statusCircle: ImageView = findViewById(R.id.imageView4)

        //switch 체크 이벤트
        switchView.setOnCheckedChangeListener { p0, isChecked ->
            if (isChecked) {
                statusText.text = "앱 잠금 실행 중"
                statusCircle.setImageResource(R.drawable.blue_circle2)
            } else {
                statusText.text = "앱 잠금이 실행중이지 않아요"
                statusCircle.setImageResource(R.drawable.blue_circle)
            }
        }
    }//onCreate
}