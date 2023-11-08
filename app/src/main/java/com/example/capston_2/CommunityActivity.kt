package com.example.capston_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CommunityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_layout)

        val communityAddButton = findViewById<Button>(R.id.community_add_button)

        communityAddButton.setOnClickListener{
            val intent = Intent (this,CommunityAddPostActivity::class.java)
            startActivity(intent)
        }
    }
}