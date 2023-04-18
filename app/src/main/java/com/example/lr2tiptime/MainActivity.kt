package com.example.lr2tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: Button = findViewById(R.id.calculate_button)
        calculateButton.setOnClickListener{
            Calculate()
        }
    }
    private fun Calculate(){
        val editText = findViewById<EditText>(R.id.cost_of_service)
        val textView = findViewById<TextView>(R.id.result_count)
        val radioGroup = findViewById<RadioGroup>(R.id.tip_options)
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId

            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)

            val switch = findViewById<Switch>(R.id.round_up_switch)

            if ( selectedRadioButtonId != -1 && switch.isChecked) {

                val input = editText.text.toString().toDoubleOrNull() ?: 0.0
                val result = when (selectedRadioButton) {
                    findViewById<RadioButton>(R.id.option_twenty_percent) -> 0.2
                    findViewById<RadioButton>(R.id.option_eighteen_percent) -> 0.18
                    findViewById<RadioButton>(R.id.option_fifteen_percent) -> 0.15
                    else -> 0.0
                }
                val output = input * result
                val roundedOutput = String.format("%.2f", output)
                textView.text = roundedOutput
            } else  {
                textView.text = "Please enable rounding"
            }
        }
    }