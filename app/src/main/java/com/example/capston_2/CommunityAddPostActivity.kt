package com.example.capston_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG

class CommunityAddPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_addpost_layout)

        val addButton = findViewById<Button>(R.id.community_addpost_button)
        val addPostTitle = findViewById<EditText>(R.id.community_addpost_title)
        val addPostContents = findViewById<EditText>(R.id.community_addpost_contents)

        addButton.setOnClickListener{
            if(addPostTitle.text.toString().trim().isEmpty()||addPostContents.text.toString().trim().isEmpty()){
                Toast.makeText(this, "제목또는 내용을 입력하세요.", LENGTH_LONG).show()
                return@setOnClickListener
            }

        }
    }

}