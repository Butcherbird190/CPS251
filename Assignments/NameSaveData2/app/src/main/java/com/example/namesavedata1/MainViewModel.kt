package com.example.namesavedata1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData



class MainViewModel : ViewModel() {
     var addedName: MutableLiveData<String> = MutableLiveData()
     var currentNames: MutableLiveData<String> = MutableLiveData()



    fun setCurrentName() {
        addedName.let {
            if (!it.value.equals( "")) {
                this.currentNames.value = currentNames.value + addedName.value + "\n"
            } else {
                currentNames.value = "Please type a name."
            }
        }
    }
//    fun displayNames() : String {
//        return currentNames.value.toString()
//    }



}
