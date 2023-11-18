package com.example.ch6_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RankFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 이 프래그먼트의 레이아웃을 인플레이트합니다.
        return inflater.inflate(R.layout.fragment_rank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 스톱워치 시간을 서버로 전송
        submitTime("user123", 120)

        // 랭킹을 서버로부터 받아오기
        getRankings()
    }

    private fun submitTime(username: String, timeSeconds: Int) {
        // 서버로 시간 전송 코드
        // 여기에 위에서 작성한 submitTime 함수를 추가하세요.
    }

    private fun getRankings() {
        // 서버에서 랭킹을 받아오는 코드
        // 여기에 위에서 작성한 getRankings 함수를 추가하세요.
    }



    companion object {
        /**
         * 이 factory 메서드를 사용하여
         * 이 프래그먼트의 새 인스턴스를 만듭니다.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return RankFragment의 새 인스턴스.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
