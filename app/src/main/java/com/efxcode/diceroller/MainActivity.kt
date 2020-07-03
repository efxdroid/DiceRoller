package com.efxcode.diceroller

import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity(){

    lateinit var diceImageView: ImageView
    lateinit var seekBar: SeekBar
    lateinit var userSelectedValue:TextView
    lateinit var totalPointsView:TextView
    var points:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImageView = findViewById(R.id.dice_image)
        seekBar = findViewById(R.id.player_input)
        userSelectedValue = findViewById(R.id.user_selected_value)
        totalPointsView  = findViewById(R.id.total_points)

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            var progressVal = 1
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressVal = progress
                userSelectedValue.text = "You Selected: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                rollDice(progressVal)
            }
        })

    }

    private fun rollDice(userInput:Int) {
        val result = Random().nextInt(6) + 1
        val drawableResource = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageView.setImageResource(drawableResource)

        if (userInput == result) {
            Toast.makeText(this, "You Won!!", Toast.LENGTH_SHORT).show()
            points += 7
        } else {
            Toast.makeText(this, "You Lost, Try Again!!", Toast.LENGTH_SHORT).show()
            points -= 1
        }

        totalPointsView.text = "$points Points"
    }


}