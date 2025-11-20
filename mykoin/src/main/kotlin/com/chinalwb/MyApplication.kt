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

// Some updates in bug/main_navigation





















// TODO1:
// DIContainer.register(ViewModelA::class.java, ViewModelA())