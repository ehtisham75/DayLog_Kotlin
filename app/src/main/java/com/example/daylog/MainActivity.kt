package com.example.daylog

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.daylog.databinding.ActivityMainBinding
import com.example.daylog.ui.bottom_tab.AddTaskFragment
import com.example.daylog.ui.bottom_tab.CalendarFragment
import com.example.daylog.ui.bottom_tab.GalleryFrag
import com.example.daylog.ui.bottom_tab.ListFragment
import com.example.daylog.ui.bottom_tab.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_showTask -> {
                    changeFragment(ListFragment())
                    true
                }
                R.id.nav_calendar -> {
                    changeFragment(CalendarFragment())
                    true
                }
                R.id.nav_add -> {
                    changeFragment(AddTaskFragment())
                    true
                }
                R.id.nav_gallery -> {
                    changeFragment(GalleryFrag())
                    true
                }
                R.id.nav_settings -> {
                    changeFragment(SettingFragment())
                    true
                }
                else -> false
            }
        }
        changeFragment(ListFragment())


//        navView.setupWithNavController(navController)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        )
//            )
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            setOf(
//        val appBarConfiguration = AppBarConfiguration(
//        // menu should be considered as top level destinations.
//        // Passing each menu ID as a set of Ids because each
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//
//        val navView: BottomNavigationView = binding.navView
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.main_frame_container, fragment).commit()
    }

}