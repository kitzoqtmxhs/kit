package com.example.ch6_view


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        val loginButton = findViewById<Button>(R.id.login_button)
        val signButton = findViewById<Button>(R.id.sign_button)
        val loginId = findViewById<EditText>(R.id.id_text)
        val loginPassword = findViewById<EditText>(R.id.password_text)

        val loginAlertDialogN = AlertDialog.Builder(this)
            .setMessage("아이디 또는 패스워드를 다시 확인해주세요.")
            .setPositiveButton("확인"){dialog, _->
                dialog.dismiss()
            }

        // 로그인버튼 이벤트 구현
        loginButton.setOnClickListener{
            if(loginId.text.toString().trim().isEmpty()||loginPassword.text.toString().trim().isEmpty()){
                Toast.makeText(this, "아이디 또는 패스워드를 입력하지 않으셨습니다.", Toast.LENGTH_LONG).show()
            } else if(false) {
                //아이디 또는 패스워드가 틀렸을때
                loginAlertDialogN.show()
            } else{
                val intent = Intent (this, AppActivity::class.java)
                startActivity(intent)
            }
            return@setOnClickListener
        }

        signButton.setOnClickListener{
            val intent = Intent (this, SignActivity::class.java)
            startActivity(intent)
        }




    }
    }

