package com.example.ch6_view

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle


class AppActivity :AppCompatActivity(){
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
                    supportFragmentManager.beginTransaction().replace(R.id.containers, homeFragment).commit()
                    true
                }
                R.id.setting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers, settingFragment).commit()
                    true
                }
                R.id.info -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers, infoFragment)
                        .commit()
                    true
                }
                R.id.community -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers, communityFragment)
                        .commit()
                    true
                }
                R.id.rank -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containers, rankFragment).commit()
                    true
                }
                else -> false
            }
        }

        // 디폴트로 표시할 프래그먼트 설정
        supportFragmentManager.beginTransaction().replace(R.id.containers, homeFragment).commit()
    }
}