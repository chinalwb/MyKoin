package com.chinalwb

import com.chinalwb.c4.MyKoin.inject
import com.chinalwb.c4.MyKoin.resolve


// Example Activity (Non-Android, Just a Concept)
class ActivityA {
    private val viewModelA: ViewModelA by inject() // Singleton
    private val viewModelB1: ViewModelB by inject() // Factory (New instance each time)
    private val viewModelB2: ViewModelB by inject() // Factory (New instance each time)

    fun show() {
        println(viewModelA.fetchData())
        println(viewModelB1.fetchData())
        println(viewModelB2.fetchData())

        // Testing singleton vs. factory behavior
        println("Is ViewModelA singleton? ${viewModelA === resolve<ViewModelA>()}") // ✅ true
        println("Are ViewModelB instances different? ${viewModelB1 !== viewModelB2}") // ✅ true
    }
}