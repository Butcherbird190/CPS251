package com.example.namesavedata1

import com.example.namesavedata1.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.textView.text = viewModel.displayNames()

        binding.addNameButton.setOnClickListener{
            viewModel.addedName = binding.textEdit.text.toString()
            viewModel.setCurrentName()
            binding.textView.text = viewModel.displayNames()
        }
    }
}