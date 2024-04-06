package edu.wccnet.mmorgan8.coroutineproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.mmorgan8.coroutineproject.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        binding.button.setOnClickListener {
            coroutineScope.launch(Dispatchers.Main) {
                addName()
            }
        }




    }
    suspend fun addName() {
        var name = binding.enterName.text.toString()
        if(name.isEmpty()){
            Log.i("zzz", "enter a name")
        }
        else {
            binding.enterName.text.clear()
            binding.enterName.requestFocus()
            var num = ((0..9).random() * 1000)
            Log.i("zzz", "named entered, delay is $num")
            delay((num.toLong()))

            var output ="the name is " + name +  " and the delay was " + num + " milliseconds"


            viewModel.addOutput(output)
            adapter?.notifyDataSetChanged()
        }
    }



}