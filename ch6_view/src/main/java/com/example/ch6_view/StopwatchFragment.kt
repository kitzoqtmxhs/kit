import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ch6_view.R

class StopwatchFragment : Fragment() {

    private lateinit var chronometer: Chronometer
    private lateinit var startButton: Button
    private lateinit var saveButton: Button
    private lateinit var resetButton: Button

    private var isChronometerRunning = false
    private var savedTime: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stopwatch, container, false)

        chronometer = view.findViewById(R.id.chronometer)
        startButton = view.findViewById(R.id.btnStart)
        saveButton = view.findViewById(R.id.btnSave)
        resetButton = view.findViewById(R.id.btnReset)

        startButton.setOnClickListener {
            if (isChronometerRunning) {
                // 일시정지
                chronometer.stop()
                isChronometerRunning = false
            } else {
                // 시작 또는 이어가기
                if (savedTime > 0) {
                    // 저장된 시간이 있으면 기존 시간을 기준으로 이어가기
                    chronometer.base = SystemClock.elapsedRealtime() - savedTime
                } else {
                    // 저장된 시간이 없으면 처음부터 시작
                    chronometer.base = SystemClock.elapsedRealtime()
                }
                chronometer.start()
                isChronometerRunning = true
            }
        }

        saveButton.setOnClickListener {
            // 일시정지
            chronometer.stop()
            isChronometerRunning = false

            // 현재 시간 저장
            savedTime = SystemClock.elapsedRealtime() - chronometer.base
            Toast.makeText(requireContext(), "시간이 저장되었습니다.", Toast.LENGTH_SHORT).show()
        }

        resetButton.setOnClickListener {
            // 초기화
            chronometer.stop()
            isChronometerRunning = false
            chronometer.base = SystemClock.elapsedRealtime()
            savedTime = 0
        }

        return view
    }
}
