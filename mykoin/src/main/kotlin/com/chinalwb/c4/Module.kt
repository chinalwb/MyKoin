package com.chinalwb.c4

// Module class to define dependencies
class Module {
    // (Class, Provider, IsFactory)
    private val definitions = mutableListOf<Triple<Class<*>, () -> Any, Boolean>>()

    fun <T : Any> single(definition: () -> T) {
        definitions.add(Triple(definition().javaClass, definition, false))
    }

    fun <T : Any> factory(definition: () -> T) {
        definitions.add(Triple(definition().javaClass, definition, true))
    }

    fun getDefinitions(): List<Triple<Class<*>, () -> Any, Boolean>> = definitions
}

fun module(init: Module.() -> Unit): Module {
    return Module().apply(init)
}