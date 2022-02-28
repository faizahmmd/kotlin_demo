package com.example.kotlin_demo.lib.auth

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class AuthActivityLifeCycleObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun observeCreate() {
        Log.d("OBSERVER", "MyObserver - observeCreate called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun observeStart() {
        Log.d("OBSERVER", "MyObserver - observeStart called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun observeResume() {
        Log.d("OBSERVER", "MyObserver - observeResume called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun observePause() {
        Log.d("OBSERVER", "MyObserver - observePause called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun observeStop() {
        Log.d("OBSERVER", "MyObserver - observeStop called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun observeDestroy() {
        Log.d("OBSERVER", "MyObserver - observeDestroy called")
    }
}