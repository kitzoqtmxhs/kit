package com.example.ch6_view

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager


class LockScreenActivity() : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)
        window.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
        )
    } // 나머지는 알아서 구성하기!
}