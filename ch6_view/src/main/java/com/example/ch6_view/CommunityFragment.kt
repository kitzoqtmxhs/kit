package com.example.ch6_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

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

        // 버튼 클릭 리스너 설정
        val addButton = view.findViewById<ImageButton>(R.id.community_add_button)

        addButton?.setOnClickListener {
            val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()

            val addFragment = CommunityAddFragment()
            fragmentTransaction.replace(R.id.containers, addFragment)
            fragmentTransaction.commit()
        }
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

