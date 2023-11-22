// RankingsFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.ch6_view.R
import org.json.JSONArray
import org.json.JSONObject

class RankingsFragment : Fragment() {

    private lateinit var requestQueue: RequestQueue
    private lateinit var rankingsList: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rankings, container, false)

        requestQueue = Volley.newRequestQueue(requireContext())
        rankingsList = view.findViewById(R.id.rankingsList)

        fetchRankings()

        return view
    }

    private fun fetchRankings() {
        val serverIpAddress = "1270.0." // 서버의 IP 주소 입력
        val url = "http://$serverIpAddress:3000/getRankings" // 서버 주소로 변경

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val rankings = parseRankings(response)
                displayRankings(rankings)
            },
            Response.ErrorListener { error ->
                // Handle error
            }
        )

        requestQueue.add(jsonArrayRequest)
    }

    private fun parseRankings(response: JSONArray): List<String> {
        val rankings = mutableListOf<String>()

        for (i in 0 until response.length()) {
            val rankObject: JSONObject = response.getJSONObject(i)
            val username: String = rankObject.getString("username")
            val timeSeconds: Int = rankObject.getInt("time_seconds")

            rankings.add("$username - $timeSeconds seconds")
        }

        return rankings
    }

    private fun displayRankings(rankings: List<String>) {
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, rankings)
        rankingsList.adapter = adapter
    }
}
