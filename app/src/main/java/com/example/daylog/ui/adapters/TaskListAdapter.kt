package com.example.daylog.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daylog.R
import com.example.daylog.data.modals.TaskItemData
//import kotlinx.android.synthetic.main.task_list_item.view.*

class TaskListAdapter (private val taskList: List<TaskItemData>) : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.tv_date)
        val day: TextView = itemView.findViewById(R.id.tv_day)
        val title: TextView = itemView.findViewById(R.id.tv_task_title)
        val description: TextView = itemView.findViewById(R.id.tv_task_description)
        val tag: TextView = itemView.findViewById(R.id.tv_task_tag)
        val emoji: ImageView = itemView.findViewById(R.id.emoji_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.date.text = task.date
        holder.day.text = task.day
        holder.title.text = task.title
        holder.description.text = task.description
        holder.tag.text = task.tag
        holder.emoji.setImageResource(task.emojiResId)
    }

    override fun getItemCount(): Int = taskList.size
}