package com.example.lifecycleawareness

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner

//DEPRECATED USE DEFAULTLIFECYCLEOBSERVER
//class CustomObserver: LifecycleObserver  {

class DemoObserver: DefaultLifecycleObserver {

    private val LOG_TAG = "DemoObserver"

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i(LOG_TAG, "Demo Observer onResume")

    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i(LOG_TAG, "Demo Observer onPause")
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i(LOG_TAG, "Demo Observer onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.i(LOG_TAG, "Demo Observer onStart")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.i(LOG_TAG, "Demo Observer onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i(LOG_TAG, "Demo Observer onDestroy")
    }
}