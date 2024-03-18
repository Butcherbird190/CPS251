package com.example.lifecycleawareness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycleawareness.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}