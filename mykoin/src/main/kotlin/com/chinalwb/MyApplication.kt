package com.chinalwb

class MyApplication {
    fun onCreate() {
        // Manually register dependencies (like Koin's module system)
        // Ctrl+1

        // Create an instance of ActivityA and call its show() function
        val activity = ActivityA()
        activity.show()
    }
}























// TODO1:
// DIContainer.register(ViewModelA::class.java, ViewModelA())