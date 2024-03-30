package edu.wccnet.mmorgan8.carddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import edu.wccnet.mmorgan8.carddemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return



        val pos = intent.getIntExtra("position", -1)

        val title = DataManager.titles[pos]
        val image = DataManager.images[pos]
        val details = DataManager.details[pos]

        binding.textView1.text = title
        binding.textView2.text = details
        binding.imageView.setImageResource(image)



    }
}