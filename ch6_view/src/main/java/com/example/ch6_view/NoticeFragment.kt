package com.example.ch6_view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.R

private const val ARG_NOTICE_PARAM1 = "param1"
private const val ARG_NOTICE_PARAM2 = "param2"

class NoticeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_NOTICE_PARAM1)
            param2 = it.getString(ARG_NOTICE_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(com.example.ch6_view.R.layout.fragment_notice, container, false)

        var noticeItems: List<NoticeItem> = listOf(
            NoticeItem(title="[오류]서버접속 오류 안내", content="안녕하세요, 스터디 플래너 사용자 여러분.\n\n현재 서버에 문제가 있어\n 일부 사용자들이 접속에 어려움을 겪고 있습니다.\n\n빠른 시일 내에 문제를 해결하여 \n더 나은 서비스를 제공할 수 있도록 최선을 다하겠습니다.\n\n불편을 드려 죄송합니다."),
            NoticeItem(title="[업데이트]업데이트 사항 안내", content="안녕하세요, 스터디 플래너 사용자 여러분. \n\n이전 버전에서의 사용자 불편사항을 개선하여 \n새로운 업데이트 버전이 나왔습니다\n\n많은 이용 부탁드립니다 감사합니다.")
        )

        for (i in 1..2) {
            // notice창
            val idNoticeTitle = resources.getIdentifier("notice_item${i}_title", "id", "com.example.ch6_view")
            val idNoticeWriter = resources.getIdentifier("notice_item${i}_writer","id","com.example.ch6_view")

            val noticeTitle= view.findViewById<TextView>(idNoticeTitle)
            val noticeWriter= view.findViewById<TextView>(idNoticeWriter)

            noticeTitle?.setText(noticeItems[i-1].title)
            noticeWriter?.setText(noticeItems[i-1].writer)
        }

        // onclick 이벤트
        val noticeTitle1 = view.findViewById<TextView>(com.example.ch6_view.R.id.notice_item1_title)
        val noticeTitle2 = view.findViewById<TextView>(com.example.ch6_view.R.id.notice_item2_title)

        // 첫번째 글 onclick
        noticeTitle1.setOnClickListener{

            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(com.example.ch6_view.R.id.containers,
                NoticeDetailFragment.newInstance(
                    noticeItems[0].title,
                    noticeItems[0].writer,
                    noticeItems[0].content
                    ))
            fragmentTransaction.commit()

        }

        // 두번째 글 onclick
        noticeTitle2.setOnClickListener{

            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(com.example.ch6_view.R.id.containers,
                NoticeDetailFragment.newInstance(
                    noticeItems[1].title,
                    noticeItems[1].writer,
                    noticeItems[1].content
                ))
            fragmentTransaction.commit()

        }



        return view
    }

    companion object {
        fun newInstance(title: String, writer: String, content: String): NoticeDetailFragment {
            val fragment = NoticeDetailFragment()
            val args = Bundle()
            args.putString("title", title)
            args.putString("writer", writer)
            args.putString("content", content)
            fragment.arguments = args
            return fragment
        }
    }
}
