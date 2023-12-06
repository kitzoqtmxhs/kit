import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch6_view.R

class TodoListFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var todoListAdapter: TodoListAdapter
    private val dataList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("TodoList", Context.MODE_PRIVATE)
        loadData()

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewTodoList)
        todoListAdapter = TodoListAdapter(dataList)
        recyclerView.adapter = todoListAdapter
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        // EditText 및 Button 찾기
        val editTextTodo = view.findViewById<EditText>(R.id.editTextTodo)
        val addButton = view.findViewById<Button>(R.id.buttonAddTodo)

        addButton.setOnClickListener {
            // EditText에서 텍스트 가져오기
            val newTask = editTextTodo.text.toString()

            // 빈 문자열이 아닌 경우에만 추가
            if (newTask.isNotEmpty()) {
                dataList.add(newTask)

                // 어댑터에 데이터 변경 알림
                todoListAdapter.notifyDataSetChanged()

                // SharedPreferences에 데이터 저장
                saveData()

                // EditText 초기화
                editTextTodo.text.clear()
            }
        }
    }

    private fun saveData() {
        val editor = sharedPreferences.edit()
        editor.putStringSet("tasks", dataList.toSet())
        editor.apply()
    }

    private fun loadData() {
        dataList.clear()
        dataList.addAll(sharedPreferences.getStringSet("tasks", emptySet()) ?: emptySet())
    }
}
