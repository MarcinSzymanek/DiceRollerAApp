package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.rollBut)
        val dice = Dice(6)

        rollButton.setOnClickListener {
            rollDice(dice)

            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            // Alternatively:
            // val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            // toast.show()
        }

    }

    private fun rollDice(d: Dice) {
        val rollRes = d.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = rollRes.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}