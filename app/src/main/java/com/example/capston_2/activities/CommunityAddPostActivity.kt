package com.example.capston_2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.capston_2.R

class CommunityAddPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community_addpost_layout)

        val addButton = findViewById<Button>(R.id.community_addpost_button)
        val addPostTitle = findViewById<EditText>(R.id.community_addpost_title)
        val addPostContents = findViewById<EditText>(R.id.community_addpost_contents)
        val idHideCheckBox = findViewById<CheckBox>(R.id.community_addpost_checkBox)
        lateinit var title : String
        lateinit var contents : String
        lateinit var writer : String
        // 제목또는 내용이 공백일때 이벤트처리
        val addPostBlankAlertDialog = AlertDialog.Builder(this)
            .setMessage("제목 또는 내용을 입력하지 않으셨습니다.")
            .setPositiveButton("확인"){ dialog, _ ->
                dialog.dismiss()
            }

        // 등록하기 button onclick 이벤트 처리
        addButton.setOnClickListener {
            if (addPostTitle.text.toString().trim().isEmpty() || addPostContents.text.toString().trim().isEmpty()){
                addPostBlankAlertDialog.show()

            } else if (idHideCheckBox.isChecked) {
                // 익명 체크 되어있을때 처리
                title = addPostTitle.text.toString()
                contents = addPostContents.text.toString()
                writer = "익명"

                // 데이터베이스로 보내는 코드

                val intent = Intent (this, CommunityActivity::class.java)
                startActivity(intent)

            } else {
                // 익명 체크 되어있지 않을때
                title = addPostTitle.text.toString()
                contents = addPostContents.text.toString()
                // 로그인한 작성자이름 넣기
                writer = "작성자"

                // 데이터베이스로 보내는 코드

                val intent = Intent (this, CommunityActivity::class.java)
                startActivity(intent)

            }
            return@setOnClickListener
        }
    }

}