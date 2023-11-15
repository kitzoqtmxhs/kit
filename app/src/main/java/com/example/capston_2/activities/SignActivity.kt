package com.example.capston_2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.capston_2.R

class SignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_layout)

        val signId =findViewById<EditText>(R.id.sign_id_input)
        val signPassword = findViewById<EditText>(R.id.sign_password_input)
        val signPasswordCheck = findViewById<EditText>(R.id.sign_password_check_input)
        val signName = findViewById<EditText>(R.id.sign_name_input)
        val idDuplicateButton = findViewById<Button>(R.id.sign_id_duplicate)
        val nameDuplicateButton = findViewById<Button>(R.id.sign_name_duplicate)
        val signFinishButton = findViewById<Button>(R.id.sign_sign_button)
        var idDu = 0
        var nameDu = 0
        var passwordSame = 0

        // 아이디와 이름의 중복확인 alertdialog
        val idAlertDialogN = AlertDialog.Builder(this)
            .setMessage("이미 존재하는 아이디입니다.")
            .setPositiveButton("확인"){ dialog, _ ->
                dialog.dismiss()
            }
        val idAlertDialogP = AlertDialog.Builder(this)
            .setMessage("사용 가능한 아이디 입니다.")
            .setPositiveButton("확인"){ dialog, _ ->
                idDu = 1
                dialog.dismiss()
            }
        val nameAlertDialogN = AlertDialog.Builder(this)
            .setMessage("이미 존재하는 이름입니다.")
            .setPositiveButton("확인"){ dialog, _ ->
                dialog.dismiss()
            }
        val nameAlertDialogP = AlertDialog.Builder(this)
            .setMessage("사용 가능한 이름입니다.")
            .setPositiveButton("확인"){ dialog, _ ->
                nameDu = 1
                dialog.dismiss()
            }

        // 중복확인 버튼이나 가입하기 버튼 클릭시 공백일 경우 이벤트 처리 alertdialog
        val signBlankAlertDialog = AlertDialog.Builder(this)
            .setMessage("공백은 입력하실 수 없습니다.")
            .setPositiveButton("확인"){dialog, _->
                dialog.dismiss()
            }

        val finishAlertDialogN = AlertDialog.Builder(this)
            .setMessage("아이디 및 이름의 중복확인 또는 비밀번호를 다시 확인해주세요.")
            .setPositiveButton("확인"){dialog, _->
                dialog.dismiss()
            }

        val finishAlertDialogY = AlertDialog.Builder(this)
            .setMessage("가입이 완료 되었습니다.")
            .setPositiveButton("확인"){dialog, _->
                dialog.dismiss()
            }



        // 아이디 중복확인 버튼 이벤트처리
        idDuplicateButton.setOnClickListener{
            if(signId.text.toString().trim().isEmpty()){
                signBlankAlertDialog.show()
                return@setOnClickListener
            }
                    // signId와 데이터베이스안에 존재하는 id를 비교해서
                    // 중복이면 alertdialog1띄우고
                    // 중복이 아니면 alertdialog2창 띄우기
                    // 중복이 아니면 idDu = 1

        }
        // 아이디 edittext 클릭이벤트 설정
        signId.setOnClickListener{
            if(idDu == 1) {
                idDu = 0
            }
            return@setOnClickListener
        }

        // 이름 중복확인 버튼 이벤트 처리
        nameDuplicateButton.setOnClickListener{
            if(signName.text.toString().trim().isEmpty()){
                signBlankAlertDialog.show()
                return@setOnClickListener
            }
            // signname와 데이터베이스안에 존재하는 name를 비교해서
            // 중복이면 alertdialogN띄우고
            // 중복이 아니면 alertdialogP창 띄우기
            // 중복이 아니면 idName = 1

        }

        // 이름 edittext 클릭이벤트 설정
        signName.setOnClickListener{
            if(nameDu == 1) {
                nameDu = 0
            }
            return@setOnClickListener
        }
        val blueBackgroundResource = R.drawable.sign_edittext_background
        val redBackgroundResource = R.drawable.sign_password_check_edittext_background

        // 비밀번호 onclick이벤트
        signPassword.setOnClickListener {
            signPassword.setText("")
            passwordSame = 0
        }

        // 비밀번호 확인 edittext 포커스 잃었을때 이벤트 설정
        signPasswordCheck.setOnFocusChangeListener { _, hasFocus ->
            if(!hasFocus){
                if(signPassword.text.toString().trim().isEmpty()) {
                    passwordSame = 0
                    signPasswordCheck.setBackgroundResource(blueBackgroundResource)
                    signBlankAlertDialog.show()

                } else if(signPassword.text.toString().trim() == signPasswordCheck.text.toString().trim()){
                    passwordSame = 1
                    signPasswordCheck.setBackgroundResource(blueBackgroundResource)

                } else{
                    passwordSame = 0
                    signPasswordCheck.setBackgroundResource(redBackgroundResource)

                }
                return@setOnFocusChangeListener

                        }
                }
        // 가입버튼 onclick 이벤트처리
        // 데이터베이스로 정보전송 코드 짜야함
        signFinishButton.setOnClickListener{
           if(idDu==0 || nameDu==0 || passwordSame==0){
               finishAlertDialogN.show()
           } else {
               finishAlertDialogY.show()
           }
            return@setOnClickListener
        }
            }
        }





