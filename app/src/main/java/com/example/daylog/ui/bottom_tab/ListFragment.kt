package com.example.daylog.ui.bottom_tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daylog.R
import com.example.daylog.data.modals.TaskItemData
import com.example.daylog.ui.adapters.TaskListAdapter

class ListFragment : Fragment() {

    private lateinit var taskAdapter: TaskListAdapter
    private lateinit var taskList: MutableList<TaskItemData>
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Initialize views
        recyclerView = view.findViewById(R.id.recycler_view_tasks)
        emptyView = view.findViewById(R.id.empty_view)

        val searchIcon = view.findViewById<ImageView>(R.id.icon_search)
        searchIcon.setOnClickListener { }

        val moreIcon = view.findViewById<ImageView>(R.id.icon_more)
        moreIcon.setOnClickListener {}

        // Initialize the task list as a mutable list
        taskList = mutableListOf()

        // Set up the RecyclerView
        taskAdapter = TaskListAdapter(taskList)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Check if the list is empty
        updateEmptyView()



 //       // Assuming you have a button in your activity to add a task
//        val addTaskButton: Button = findViewById(R.id.add_task_button)
//
//        // Get the fragment
//        val listFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as? ListFragment
//
//        addTaskButton.setOnClickListener {
//            val newTask = Task(
//                date = "31",
//                day = "Thursday, Feb 2024",
//                title = "New Task Title",
//                description = "This is a new task",
//                tag = "# New Task"
//            )
//            listFragment?.addTask(newTask)
//        }


        return view
    }

    private fun updateEmptyView() {
        if (taskList.isEmpty()) {
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
            animateEmptyView()
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
        }
    }

    private fun animateEmptyView() {
        // Example animation: fade in
        emptyView.alpha = 0f
        emptyView.animate()
            .alpha(1f)
            .setDuration(1000)
            .start()
    }

    fun addTask(task: TaskItemData) {
        taskList.add(task)
        taskAdapter.notifyItemInserted(taskList.size - 1)
        updateEmptyView()
    }
}

//TaskItemData(
//"19",
//"Thursday, Feb 2024",
//"Happy Birthday",
//"Lorem ipsum dolor sit amet",
//"# Need Cake",
//R.drawable.love_emoji
//),
//TaskItemData(
//"02",
//"Saturday, Mar 2024",
//"Interview",
//"Lorem ipsum dolor sit amet",
//"# Need project",
//R.drawable.love_emoji
//),
//TaskItemData(
//"15",
//"Wednesday, Aug 2024",
//"Tech Interview",
//"Lorem ipsum dolor sit amet",
//"# show expertise",
//R.drawable.love_emoji
//),