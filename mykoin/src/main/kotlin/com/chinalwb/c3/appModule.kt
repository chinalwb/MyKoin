package com.chinalwb.c3

import com.chinalwb.ViewModelA

// DSL
val appModule = module {
    single { ViewModelA() } // Define ViewModelA as a singleton
}
