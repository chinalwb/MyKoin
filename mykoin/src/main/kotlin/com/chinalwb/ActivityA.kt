package com.chinalwb

import com.chinalwb.c2.inject


class ActivityA {

    private val viewModel: ViewModelA by inject()

    fun show() {
        println(viewModel.fetchData())
    }
}




















// TODO
// private val viewModel: ViewModelA = DIContainer.resolve(ViewModelA::class.java)