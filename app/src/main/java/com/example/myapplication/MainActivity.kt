package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val seekBarAgeView = findViewById<SeekBar>(R.id.seekBarAge)
        val textViewAgeView = findViewById<TextView>(R.id.textViewAge)
        val editTextOwnerView = findViewById<EditText>(R.id.editTextOwner)
        val radioButtonDogView = findViewById<RadioButton>(R.id.radioButtonDog)
        val radioButtonCatView = findViewById<RadioButton>(R.id.radioButtonCat)
        val radioButtonGuineaPigView = findViewById<RadioButton>(R.id.radioButtonGuineaPig)
        val editTextPurposeView = findViewById<EditText>(R.id.editTextPurpose)
        val editTextTimeView = findViewById<EditText>(R.id.editTextTime)
        val button = findViewById<Button>(R.id.button)
        val textViewResultView = findViewById<TextView>(R.id.textViewResult)

        var animalType = radioButtonDogView.text.toString()

        radioButtonDogView.setOnClickListener {
            seekBarAgeView.updateSeekBarAgeView(18)
            textViewAgeView.text = seekBarAgeView.progress.toString()
            animalType = radioButtonDogView.text.toString()
        }

        radioButtonCatView.setOnClickListener {
            seekBarAgeView.updateSeekBarAgeView(20)
            textViewAgeView.text = seekBarAgeView.progress.toString()
            animalType = radioButtonCatView.text.toString()
        }

        radioButtonGuineaPigView.setOnClickListener {
            seekBarAgeView.updateSeekBarAgeView(9)
            textViewAgeView.text = seekBarAgeView.progress.toString()
            animalType = radioButtonGuineaPigView.text.toString()
        }

        seekBarAgeView.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                textViewAgeView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do nothing
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do nothing
            }
        })

        button.setOnClickListener {
            val text = "${editTextOwnerView.text}, ${animalType}, ${textViewAgeView.text}, " +
                    "${editTextPurposeView.text}, ${editTextTimeView.text}"
            textViewResultView.text = text
        }
    }
}

private fun SeekBar.updateSeekBarAgeView(newMax: Int) {
    max = newMax
    if(progress > newMax) {
        progress = newMax
    }
}
