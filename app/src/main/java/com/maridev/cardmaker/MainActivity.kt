package com.maridev.cardmaker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.signature_done).setOnClickListener {
            displayText(it, R.id.signature_edit, R.id.signature_text)
        }

        findViewById<TextView>(R.id.signature_text).setOnClickListener {
            updateText(it, R.id.signature_edit, R.id.signature_done)
        }

        findViewById<Button>(R.id.receiver_name_done).setOnClickListener {
            displayText(it,
                    R.id.receiver_name_edit,
                    R.id.receiver_name_text)
        }
        findViewById<Button>(R.id.message_done).setOnClickListener {
            displayText(it,
                    R.id.message_edit,
                    R.id.message_text)
        }

        findViewById<TextView>(R.id.receiver_name_text).setOnClickListener {
            updateText(it,
                        R.id.receiver_name_edit,
                        R.id.receiver_name_done)
        }

        findViewById<TextView>(R.id.message_text).setOnClickListener {
            updateText(it,
                        R.id.message_edit,
                        R.id.message_done)
        }
    }

    private fun updateText(view: View,
                    editTextId: Int,
                    doneButtonId: Int) {
        val editText = findViewById<EditText>(editTextId)

        editText.visibility = View.VISIBLE

        editText.requestFocus()

        val doneButton = findViewById<Button>(doneButtonId)
        doneButton.visibility = View.VISIBLE

        view.visibility = View.GONE

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        inputMethodManager.showSoftInput(editText, 0)
    }

    private  fun displayText(
        view:       View,
                    editTextId: Int,
                    textViewId: Int) {
        val editText = findViewById<EditText>(editTextId)

        editText.visibility = View.GONE

        val textView = findViewById<TextView>(textViewId)

        textView.text = editText.text
        textView.visibility = View.VISIBLE

        view.visibility = View.GONE

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
}