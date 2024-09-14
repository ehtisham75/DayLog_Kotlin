package com.example.daylog.ui.passcode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.daylog.R
import com.example.daylog.data.utils.IntentKeys
import com.example.daylog.data.utils.PrefKeys

class ConfirmPasscodeActivity : AppCompatActivity() {

    private lateinit var backButton: ImageButton
    private lateinit var inputPin1: EditText
    private lateinit var inputPin2: EditText
    private lateinit var inputPin3: EditText
    private lateinit var inputPin4: EditText
    private lateinit var deleteButton: ImageButton
    private lateinit var numberPadButtons: List<Button>

    private var originalPin: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm_passcode)

        backButton = findViewById(R.id.btn_back)
        inputPin1 = findViewById(R.id.input_pin_1)
        inputPin2 = findViewById(R.id.input_pin_2)
        inputPin3 = findViewById(R.id.input_pin_3)
        inputPin4 = findViewById(R.id.input_pin_4)
        deleteButton = findViewById(R.id.btn_delete)

        numberPadButtons = listOf(
            findViewById(R.id.btn_0),
            findViewById(R.id.btn_1),
            findViewById(R.id.btn_2),
            findViewById(R.id.btn_3),
            findViewById(R.id.btn_4),
            findViewById(R.id.btn_5),
            findViewById(R.id.btn_6),
            findViewById(R.id.btn_7),
            findViewById(R.id.btn_8),
            findViewById(R.id.btn_9)
        )

        originalPin = intent.getStringExtra(IntentKeys.SET_PIN_KEY)

        setupBackButton()
        setupPinInput()
        setupNumberPad()
    }

    private fun setupBackButton() {
        backButton.setOnClickListener {
            showConfirmationDialog()
        }
    }
    private fun showConfirmationDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Are you sure you want to go back? Your changes might not be saved.")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Go Back")
        alert.show()
    }

    private fun setupPinInput() {
        inputPin1.showSoftInputOnFocus = false
        inputPin2.showSoftInputOnFocus = false
        inputPin3.showSoftInputOnFocus = false
        inputPin4.showSoftInputOnFocus = false

        inputPin1.addTextChangedListener(PinTextWatcher(inputPin1, inputPin2))
        inputPin2.addTextChangedListener(PinTextWatcher(inputPin2, inputPin3))
        inputPin3.addTextChangedListener(PinTextWatcher(inputPin3, inputPin4))
        inputPin4.addTextChangedListener(PinTextWatcher(inputPin4, null))
        // Set focus to the first input field when the activity starts
        inputPin1.requestFocus()
    }

    private fun setupNumberPad() {
        for (button in numberPadButtons) {
            button.setOnClickListener { appendNumberToPinInput((it as Button).text.toString()) }
        }
        deleteButton.setOnClickListener { deleteLastDigit() }
    }
    private fun appendNumberToPinInput(number: String) {
        when {
            inputPin1.text.isEmpty() -> inputPin1.setText(number)
            inputPin2.text.isEmpty() -> inputPin2.setText(number)
            inputPin3.text.isEmpty() -> inputPin3.setText(number)
            inputPin4.text.isEmpty() -> inputPin4.setText(number)
        }
    }
    private fun deleteLastDigit() {
        when {
            inputPin4.text.isNotEmpty() -> inputPin4.text.clear()
            inputPin3.text.isNotEmpty() -> inputPin3.text.clear()
            inputPin2.text.isNotEmpty() -> inputPin2.text.clear()
            inputPin1.text.isNotEmpty() -> inputPin1.text.clear()
        }
    }

    private fun verifyPin() {
        val enteredPin = "${inputPin1.text}${inputPin2.text}${inputPin3.text}${inputPin4.text}"
        val storedPin = originalPin

        if (enteredPin == storedPin) {
            storePinInSharedPreferences(enteredPin)
            moveToNextActivity()
        } else {
            Toast.makeText(this, "Confirmed Pin not matched", Toast.LENGTH_SHORT).show()
        }
    }

    private fun storePinInSharedPreferences(pin: String) {
        val sharedPref = getSharedPreferences(PrefKeys.PASSCODE_MAIN_KEY, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString(PrefKeys.SET_PASSCODE_KEY, pin)
            apply()
        }
    }
    private fun moveToNextActivity() {
        val intent = Intent(this, PasscodeQuestionActivity::class.java)
        startActivity(intent)
        finish()
    }

    private inner class PinTextWatcher(
        private val currentEditText: EditText,
        private val nextEditText: EditText?
    ) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s?.length == 1) {
                nextEditText?.requestFocus()
            }
        }

        override fun afterTextChanged(s: Editable?) {
            if (inputPin1.text.isNotEmpty() && inputPin2.text.isNotEmpty() && inputPin3.text.isNotEmpty() && inputPin4.text.isNotEmpty()) {
                verifyPin()
            }
        }
    }
}