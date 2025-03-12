package com.chinalwb.c4

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