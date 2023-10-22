package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import android.os.Bundle
import java.text.NumberFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    lateinit var biding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        biding.calculateButton.setOnClickListener{calculateTip()}
    }
    fun calculateTip(){
        val stringInTextField =biding.costOfService.text.toString()
        val cost=stringInTextField.toDouble()
        val selectedId=biding.tipOptions.checkedRadioButtonId
        val tipPercentage=when(selectedId){
            R.id.option_20_percent -> -0.2
            R.id.option_15_percent-> 0.15
            else ->0.18
        }
        val roundUp=biding.roundUpSwitch.isChecked
        var tip=tipPercentage*cost
        if(roundUp){
            tip=kotlin.math.ceil(tip)
        }
        val formattedTip=NumberFormat.getCurrencyInstance().format(tip)
        biding.tipResult.text=getString(R.string.tip_amount,formattedTip)
    }
}