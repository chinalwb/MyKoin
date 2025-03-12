package com.chinalwb

import com.chinalwb.c4.appModule
import com.chinalwb.c4.startKoin

class MyApplication {
    fun onCreate() {
        startKoin {
            modules(appModule)
        }

        // Create an instance of ActivityA and call its show() function
        val activity = ActivityA()
        activity.show()
    }
}























// TODO1:
// DIContainer.register(ViewModelA::class.java, ViewModelA())