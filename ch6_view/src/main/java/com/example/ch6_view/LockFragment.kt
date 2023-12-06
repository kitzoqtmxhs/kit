package com.example.ch6_view

import android.app.Activity.RESULT_OK
import android.app.ActivityManager
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class LockFragment : Fragment(), View.OnClickListener {
    private var lock: Button? = null
    private var disable: Button? = null
    private var enable: Button? = null
    private var devicePolicyManager: DevicePolicyManager? = null
    private var activityManager: ActivityManager? = null
    private var compName: ComponentName? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lock, container, false)

        devicePolicyManager = activity?.getSystemService(DevicePolicyManager::class.java)
        activityManager = activity?.getSystemService(ActivityManager::class.java)
        compName = ComponentName(requireContext(), MyAdmin::class.java)

        lock = view.findViewById(R.id.lock)
        enable = view.findViewById(R.id.enableBtn)
        disable = view.findViewById(R.id.disableBtn)

        lock!!.setOnClickListener(this)
        enable!!.setOnClickListener(this)
        disable!!.setOnClickListener(this)

        return view
    }

    override fun onResume() {
        super.onResume()
        val isActive = devicePolicyManager!!.isAdminActive(compName!!)
        disable!!.visibility = if (isActive) View.VISIBLE else View.GONE
        enable!!.visibility = if (isActive) View.GONE else View.VISIBLE
    }

    override fun onClick(view: View) {
        if (view === lock) {
            val statusText: TextView = view.findViewById(R.id.status_text)
            val statusCircle: ImageView = view.findViewById(R.id.imageView4)
            val statusLock: ImageView = view.findViewById(R.id.imageView)

            val active = devicePolicyManager!!.isAdminActive(compName!!)

            statusCircle.setImageResource(R.drawable.blue_circle2)
            statusLock.setImageResource(R.drawable.baseline_lock_24)
            statusLock.bringToFront();

            if (active) {
                devicePolicyManager!!.lockNow()
                statusText.text = "앱 잠금 실행 중"
            } else {
                Toast.makeText(
                    requireContext(),
                    "관리자 권한이 필요한 기능입니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else if (view === enable) {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName)
            intent.putExtra(
                DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "-"
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
                Toast.makeText(requireContext(), "관리자 권한 실행", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "관리자 권한 실행에 문제가 발생",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        const val RESULT_ENABLE = 11
    }
}
