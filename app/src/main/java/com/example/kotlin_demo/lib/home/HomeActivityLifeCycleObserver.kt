package com.example.kotlin_demo.lib.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class HomeActivityLifeCycleObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateHome() {
        //To do
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartHome() {
        //To do
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeHome() {
        //To do
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseHome() {
        //To do
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopHome() {
        //To do
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyHome() {
        //To do
    }
}