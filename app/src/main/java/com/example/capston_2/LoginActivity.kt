package com.example.capston_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        val signButton = findViewById<Button>(R.id.sign_button)

        signButton.setOnClickListener{
            val intent = Intent (this,SignActivity::class.java)
            startActivity(intent)
        }




    }


}