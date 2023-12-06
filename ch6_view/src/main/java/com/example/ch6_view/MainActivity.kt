package com.example.ch6_view

import StopwatchFragment
import TodoListFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val lockFragment = LockFragment()
    private val settingFragment = SettingFragment()
    private val todoListFragment = TodoListFragment()
    private val stopwatchFragment = StopwatchFragment()
    private val noticeFragment = NoticeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigationview)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.lock -> {
                    replaceFragment(lockFragment)
                    true
                }
                R.id.setting -> {
                    replaceFragment(settingFragment)
                    true
                }

                R.id.community -> {
                    replaceFragment(noticeFragment)
                    true
                }
                R.id.todo -> {
                    replaceFragment(todoListFragment)
                    true
                }
                R.id.watch -> {
                    replaceFragment(stopwatchFragment)
                    true
                }
                else -> false
            }
        }

        // 디폴트로 표시할 프래그먼트 설정
        replaceFragment(lockFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.containers, fragment).commit()
    }
}


















