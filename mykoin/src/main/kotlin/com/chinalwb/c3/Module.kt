package com.chinalwb.c3

class Module {
    private val definitions = mutableMapOf<Class<*>, () -> Any>()

    fun <T : Any> single(definition: () -> T) {
        definitions[definition().javaClass] = definition
    }

    fun getDefinitions(): Map<Class<*>, () -> Any> = definitions
}

fun module(init: Module.() -> Unit): Module {
    return Module().apply(init)
}
