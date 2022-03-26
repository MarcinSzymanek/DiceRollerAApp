package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This app lets the user roll a dice with click on the roll button
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollBut)
        val dice = Dice(6)

        rollButton.setOnClickListener {
            rollDice(dice)
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }

        // Displays a random dice roll when the app starts
        rollDice(dice)
    }

    /**
     * Rolls a dice with the supplied Dice. The dice should be created somewhere else
     * Display the result with the appropriate image
     */
    private fun rollDice(d: Dice) {

        val rollRes = d.roll()
        val diceImg: ImageView = findViewById(R.id.imageView)

        // Choose the appropriate image
        val drawableResource = when(rollRes){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // What does setImageDrawable do?
        diceImg.setImageResource(drawableResource)
        diceImg.contentDescription = rollRes.toString()
    }

    /**
     * Create a dice with numSides sides
     */
    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}