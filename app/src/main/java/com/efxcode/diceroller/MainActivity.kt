package com.efxcode.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImageView: ImageView
    lateinit var playerGuessText: EditText
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImageView = findViewById(R.id.dice_image)
        playerGuessText = findViewById(R.id.player_guess_input)
        with(playerGuessText) {
            hint = 1.toString()
            setText(1.toString())
        }
        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
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

        if (playerGuessText.text.toString().toInt() == result) {
            Toast.makeText(this, "You Won!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "You Lost, Try Again!!", Toast.LENGTH_SHORT).show()
        }
    }
}