package com.example.ch6_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val settingFragment = SettingFragment()
    private val infoFragment = InfoFragment()
    private val rankFragment = RankFragment()
    private val communityFragment = CommunityFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigationview)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(homeFragment)
                    true
                }
                R.id.setting -> {
                    replaceFragment(settingFragment)
                    true
                }
                R.id.info -> {
                    replaceFragment(infoFragment)
                    true
                }
                R.id.community -> {
                    replaceFragment(communityFragment)
                    true
                }
                R.id.rank -> {
                    replaceFragment(rankFragment)
                    true
                }
                else -> false
            }
        }

        // 디폴트로 표시할 프래그먼트 설정
        replaceFragment(homeFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.containers, fragment).commit()
    }
}
