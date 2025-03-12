package com.chinalwb

import com.chinalwb.c4.MyKoin
import com.chinalwb.c4.MyKoin.inject


// Example Activity (Non-Android, Just a Concept)
class ActivityA {
    private val viewModel: ViewModelA by MyKoin.inject()

    fun show() {
        println(viewModel.fetchData())
    }
}
