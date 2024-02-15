package com.example.namesavedata1

import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {
    public var addedName = ""
    private var currentNames = ""



    fun setCurrentName()  {
        if (addedName.isNotEmpty()){
            this.currentNames = currentNames + addedName + "\n"
        }
        else {
            currentNames = "Please type a name."
        }
    }
    fun displayNames() : String {
        return currentNames
    }



}
