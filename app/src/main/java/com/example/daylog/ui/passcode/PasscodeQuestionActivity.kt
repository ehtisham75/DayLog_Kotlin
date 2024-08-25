package com.example.daylog.ui.passcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.daylog.R

class PasscodeQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passcode_question)

        // Find the Spinner in the layout
        val spinner: Spinner = findViewById(R.id.spinner_security_question)

        // Create an ArrayAdapter using the string array and a custom spinner item layout
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.security_questions_array, // Array of security questions
            R.layout.passcode_question_spinner_item // Custom layout for the spinner item
        )

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        spinner.adapter = adapter

    }
}