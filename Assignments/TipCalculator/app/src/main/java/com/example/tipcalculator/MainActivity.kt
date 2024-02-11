package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calcCurrency (view:View) {
        if(binding.dollarText.text.isNotEmpty()) {
            val dollarValue = binding.dollarText.text.toString().toFloat()
            val tipValueTenPercent = dollarValue * 1.1
            val tipValueFifteenPercent = dollarValue * 1.15
            val tipValueTwentyPercent = dollarValue * 1.20

            binding.textDesc.text = getString(R.string.values_are_as_follows)
            binding.TextView10.text = tipValueTenPercent.toString()
            binding.textView15.text = tipValueFifteenPercent.toString()
            binding.textView20.text = tipValueTwentyPercent.toString()
        }
        else {
            binding.textDesc.text = getString(R.string.you_must_enter_a_bill_amount)
        }
    }
}