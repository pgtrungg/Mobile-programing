package com.example.diceroller
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
            rollDice()
        }

    }

    private fun rollDice() {
            val dice = Dice(6)
            val resultTextView1: TextView = findViewById(R.id.textView1)
            resultTextView1.text = dice.roll().toString()
            val resultTextView2: TextView = findViewById(R.id.textView2)
            resultTextView2.text = dice.roll().toString()
    }
}
class Dice(private val numSides:Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}