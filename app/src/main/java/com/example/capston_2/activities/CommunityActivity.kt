package com.example.capston_2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.capston_2.R

class CommunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_layout)

        val communityAddButton = findViewById<Button>(R.id.community_add_button)

        // 커뮤니티 add_button onclick 이벤트 처리
        communityAddButton.setOnClickListener{
            val intent = Intent (this, CommunityAddPostActivity::class.java)
            startActivity(intent)
        }
    }
}