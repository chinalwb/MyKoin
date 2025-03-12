package com.chinalwb.c4

import com.chinalwb.c3.Module

class KoinApp {
    val modules = mutableListOf<Module>()

    fun modules(vararg moduleList: Module) {
        modules.addAll(moduleList)
    }
}

// Koin-like DSL
fun startKoin(init: KoinApp.() -> Unit) {
    val koinApp = KoinApp()
    koinApp.init()
    MyKoin.loadModules(koinApp.modules)
}