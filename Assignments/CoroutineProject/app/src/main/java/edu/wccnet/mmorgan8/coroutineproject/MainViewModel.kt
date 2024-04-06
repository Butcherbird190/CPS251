package edu.wccnet.mmorgan8.coroutineproject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope

class MainViewModel : ViewModel() {
    companion object {
        val nameList = mutableListOf<String>()
    }



    fun addOutput(output: String) {
        nameList.add(output)
        Log.i("zzz", "namelist added")
        Log.i("zzz", "the namelist is $nameList")


    }
}


