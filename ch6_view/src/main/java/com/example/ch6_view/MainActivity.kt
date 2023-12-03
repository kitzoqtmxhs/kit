package com.example.ch6_view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //객체 생성
        val statusText: TextView = findViewById(R.id.status_text)
        val switchView: SwitchCompat = findViewById(R.id.switchView)
        val statusCircle: ImageView = findViewById(R.id.imageView4)
        val statusLock: ImageView = findViewById(R.id.imageView)

        //switch 체크 이벤트
        switchView.setOnCheckedChangeListener { p0, isChecked ->
            if (isChecked) {
                statusText.text = "앱 잠금 실행 중"
                statusCircle.setImageResource(R.drawable.blue_circle2)
                statusLock.setImageResource(R.drawable.baseline_lock_24)
                statusLock.bringToFront();
                switchView.bringToFront();

            } else {
                statusText.text = "앱 잠금이 실행중이지 않아요"
                statusCircle.setImageResource(R.drawable.blue_circle)
                statusLock.setImageResource(R.drawable.baseline_lock_open_24)
            }
        }
    }//onCreate
}

