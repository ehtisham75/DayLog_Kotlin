package com.example.daylog.ui.bottom_tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.daylog.R
import com.example.daylog.data.modals.TaskItemData
import com.example.daylog.ui.adapters.TaskListAdapter

class ListFragment : Fragment() {

    private lateinit var taskAdapter: TaskListAdapter
    private lateinit var taskList: List<TaskItemData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val searchIcon = view.findViewById<ImageView>(R.id.icon_search)
        searchIcon.setOnClickListener { }

        val moreIcon = view.findViewById<ImageView>(R.id.icon_more)
        moreIcon.setOnClickListener {}

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskList = listOf(
            TaskItemData(
                "19",
                "Thursday, Feb 2024",
                "Happy Birthday",
                "Lorem ipsum dolor sit amet",
                "# Need Cake",
                R.drawable.love_emoji
            ),
            TaskItemData(
                "02",
                "Saturday, Mar 2024",
                "Interview",
                "Lorem ipsum dolor sit amet",
                "# Need project",
                R.drawable.love_emoji
            ),
            TaskItemData(
                "31",
                "Thursday, Feb 2024",
                "Happy Birthday",
                "Lorem ipsum dolor sit amet...",
                "# Need Cake",
                R.drawable.love_emoji
            ),
            TaskItemData(
                "31",
                "Thursday, Feb 2024",
                "Happy Birthday",
                "Lorem ipsum dolor sit amet...",
                "# Need Cake",
                R.drawable.love_emoji
            ),
            TaskItemData(
                "15",
                "Wednesday, Aug 2024",
                "Tech Interview",
                "Lorem ipsum dolor sit amet",
                "# show expertise",
                R.drawable.love_emoji
            ),
        )

        // Set up the RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view_tasks)
        taskAdapter = TaskListAdapter(taskList)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}