package com.example.ch6_view

import android.app.ActivityManager
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var lock: Button? = null
    private var disable: Button? = null
    private var enable: Button? = null
    private var devicePolicyManager: DevicePolicyManager? = null
    private var activityManager: ActivityManager? = null
    private var compName: ComponentName? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        devicePolicyManager = getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
        activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        compName = ComponentName(this, MyAdmin::class.java)
        lock = findViewById<View>(R.id.lock) as Button
        enable = findViewById<View>(R.id.enableBtn) as Button
        disable = findViewById<View>(R.id.disableBtn) as Button
        lock!!.setOnClickListener(this)
        enable!!.setOnClickListener(this)
        disable!!.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        val isActive = devicePolicyManager!!.isAdminActive(compName!!)
        disable!!.visibility = if (isActive) View.VISIBLE else View.GONE
        enable!!.visibility = if (isActive) View.GONE else View.VISIBLE
    }

    override fun onClick(view: View) {
        if (view === lock) {
            val active = devicePolicyManager!!.isAdminActive(compName!!)
            if (active) {
                devicePolicyManager!!.lockNow()
            } else {
                Toast.makeText(
                    this,
                    "관리자 권한이 필요한 기능입니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else if (view === enable) {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName)
            intent.putExtra(
                DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "왜 이 기능이 필요한지에 대한 설명입니다."
            )
            startActivityForResult(intent, RESULT_ENABLE)
        } else if (view === disable) {
            devicePolicyManager!!.removeActiveAdmin(compName!!)
            disable!!.visibility = View.GONE
            enable!!.visibility = View.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            RESULT_ENABLE -> if (resultCode == RESULT_OK) {
                Toast.makeText(this@MainActivity, "관리자 권한 실행", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "관리자 권한 실행에 문제가 발생", Toast.LENGTH_SHORT).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        const val RESULT_ENABLE = 11
    }
}

