package com.chinalwb.c4

import com.chinalwb.ViewModelA
import com.chinalwb.ViewModelB

// Define Dependencies in Modules
val appModule = module {
    single { ViewModelA() } // Singleton ViewModelA
    factory { ViewModelB() } // Factory ViewModelB
}