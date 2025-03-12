package com.chinalwb.dsl

import com.chinalwb.ViewModelA
import com.chinalwb.c3.module

// Define Dependencies in Modules
val appModule = module {
    single { ViewModelA() } // Singleton ViewModelA
}