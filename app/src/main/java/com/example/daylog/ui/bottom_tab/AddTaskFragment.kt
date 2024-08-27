package com.example.daylog.ui.bottom_tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.daylog.R

class AddTaskFragment : Fragment() {
//    private lateinit var binding: AddTaskFragment
//    private lateinit var searchButton: ImageView
//    private lateinit var moreButton: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_task, container, false)

//        val searchIcon = view.findViewById<ImageView>(R.id.icon_search)
//        searchIcon.setOnClickListener {        }

//        val moreIcon = view.findViewById<ImageView>(R.id.icon_more)
//        moreIcon.setOnClickListener {        }

//        return view
    }
}