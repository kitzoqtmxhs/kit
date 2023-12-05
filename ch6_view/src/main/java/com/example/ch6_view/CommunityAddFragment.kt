package com.example.ch6_view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

private const val ARG_COMMUNITYADDPOST_PARAM1 = "param1"
private const val ARG_COMMUNITYADDPOST_PARAM2 = "param2"

class CommunityAddFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    class AddPostBlankAlertDialog : DialogFragment(){
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return AlertDialog.Builder(requireActivity())
                .setMessage("제목 또는 내용을 입력하지 않으셨습니다.")
                .setPositiveButton("확인") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_COMMUNITYADDPOST_PARAM1)
            param2 = it.getString(ARG_COMMUNITYADDPOST_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_community_addpost, container, false)

        val addButton = view.findViewById<Button>(R.id.community_addpost_button)
        val addPostTitle = view.findViewById<EditText>(R.id.community_addpost_title)
        val addPostContents = view.findViewById<EditText>(R.id.community_addpost_contents)
        val idHideCheckBox = view.findViewById<CheckBox>(R.id.community_addpost_checkbox)

        // 제목또는 내용이 공백일때 이벤트처리


        // 등록하기 button onclick 이벤트 처리
        addButton.setOnClickListener {
            if (addPostTitle.text.toString().trim().isEmpty() || addPostContents.text.toString().trim().isEmpty()){
                val ad = AddPostBlankAlertDialog()
                ad.show(requireActivity().supportFragmentManager, "dialog")

            } else if (idHideCheckBox.isChecked) {
                // 익명 체크 되어있을때 처리

                // 데이터베이스로 보내는 코드

                val intent = Intent (requireContext(), CommunityFragment::class.java)
//                intent.putExtra("title",info.title)
//                intent.putExtra("contents",info.contents)
//                intent.putExtra("writer",info.writer)

                startActivity(intent)

            } else {
                // 익명 체크 되어있지 않을때

                // 데이터베이스로 보내는 코드

                val intent = Intent (requireContext(), CommunityFragment::class.java)
//                intent.putExtra("title",info.title)
//                intent.putExtra("contents",info.contents)
//                intent.putExtra("writer",info.writer)
                startActivity(intent)

            }
            return@setOnClickListener
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommunityAddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_COMMUNITYADDPOST_PARAM1, param1)
                    putString(ARG_COMMUNITYADDPOST_PARAM2, param2)
                }
            }
    }
}
