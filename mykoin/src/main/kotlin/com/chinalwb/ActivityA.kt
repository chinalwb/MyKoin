package com.chinalwb

class ActivityA {

    private lateinit var viewModel: ViewModelA // To be DI
    // Ctrl + 2

    fun show() {
        println(viewModel.fetchData())
    }
}




















// TODO
// private val viewModel: ViewModelA = DIContainer.resolve(ViewModelA::class.java)