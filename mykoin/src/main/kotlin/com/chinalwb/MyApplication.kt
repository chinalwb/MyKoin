package com.chinalwb

import com.chinalwb.c3.MyKoin.startMyKoin
import com.chinalwb.c3.appModule

class MyApplication {
    fun onCreate() {
        startMyKoin(modules = listOf(appModule))

        // Create an instance of ActivityA and call its show() function
        val activity = ActivityA()
        activity.show()
    }
}























// TODO1:
// DIContainer.register(ViewModelA::class.java, ViewModelA())