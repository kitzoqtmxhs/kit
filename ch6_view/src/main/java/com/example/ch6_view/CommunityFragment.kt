package com.example.ch6_view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch6_view.RecycleViewAdapter

private const val ARG_COMMUNITY_PARAM1 = "param1"
private const val ARG_COMMUNITY_PARAM2 = "param2"

class CommunityFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_COMMUNITY_PARAM1)
            param2 = it.getString(ARG_COMMUNITY_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_community, container, false)
        //        val communityAddButton = view.findViewById<Button>(R.id.community_add_button)
//        var itemList = ArrayList<RecycleViewItem>()
//        var info : RecycleViewItem = RecycleViewItem("","","")

        // addpost창에서 입력후 올리기 버튼을 누르면 실시간으로 적용하는 코드
        // addpost창에서 intent로 연결후 추가한 title, contents, writer정보 가져오기
//        info.title = requireActivity().intent.getStringExtra("title").toString()
//        info.contents = requireActivity().intent.getStringExtra("contents").toString()
//        info.writer = requireActivity().intent.getStringExtra("writer").toString()

        // 정보를 가져오게 되면 실행하여 itemList에 데이터 넣기
//        if(info.title != "" && info.contents != "" && info.writer != ""){

            // 데이터베이스로 정보보내기


        // 데이터베이스에서 정보들을 가져와서 보여주는 코드
        // adapter하나 만들기
        // 데이터베이스에서 정보를 가져와서 itemlist에 넣기

        //
//        val recycleViewAdapter = RecycleViewAdapter(itemList)
//        recycleViewAdapter.notifyDataSetChanged()

        // adapter, layoutManager 설정하기
//        recycleView.adapter = recycleViewAdapter
//        recycleView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        // 커뮤니티 add_button onclick 이벤트 처리
//        communityAddButton.setOnClickListener{
//            val intent = Intent(requireContext(), CommunityAddPostFragment::class.java)
//            startActivity(intent)
//        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CommunityFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_COMMUNITY_PARAM1, param1)
                    putString(ARG_COMMUNITY_PARAM2, param2)
                }
            }
    }
}
