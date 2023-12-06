package com.example.ch6_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ch6_view.NoticeItem

private const val ARG_NOTICEDETAIL_PARAM1 = "param1"
private const val ARG_NOTICEDETAIL_PARAM2 = "param2"

class NoticeDetailFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_NOTICEDETAIL_PARAM1)
            param2 = it.getString(ARG_NOTICEDETAIL_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notice_detail, container, false)

        val title = arguments?.getString(ARG_NOTICE_TITLE)
        val writer = arguments?.getString(ARG_NOTICE_WRITER)
        val content = arguments?.getString(ARG_NOTICE_CONTENT)

        // 가져온 데이터를 원하는 뷰에 설정하기
        val titleTextView = view.findViewById<TextView>(R.id.notice_detail_title)
        val writerTextView = view.findViewById<TextView>(R.id.notice_detail_writer)
        val contentTextView = view.findViewById<TextView>(R.id.notice_detail_content)

        titleTextView.text = title
        writerTextView.text = writer
        contentTextView.text = content

        return view
    }

    companion object {

        private const val ARG_NOTICE_TITLE = "title"
        private const val ARG_NOTICE_WRITER = "writer"
        private const val ARG_NOTICE_CONTENT = "content"
        @JvmStatic
        fun newInstance(title: String, writer: String, content: String) =
            NoticeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_NOTICE_TITLE, title)
                    putString(ARG_NOTICE_WRITER, writer)
                    putString(ARG_NOTICE_CONTENT, content)
                }
            }
    }
}
