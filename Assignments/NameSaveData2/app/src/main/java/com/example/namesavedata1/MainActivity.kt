package com.example.namesavedata1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import com.example.namesavedata1.databinding.ActivityMainBinding
import com.example.namesavedata1.BR.myViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.lifecycleOwner = this
        binding.setVariable(myViewModel, viewModel)

        setContentView(binding.root)
        
//        binding.textView.text = viewModel.displayNames()
//
//        binding.addNameButton.setOnClickListener{
//            viewModel.addedName = binding.textEdit.text.toString()
//            viewModel.setCurrentName()
//            binding.textView.text = viewModel.displayNames()
        }
    }
