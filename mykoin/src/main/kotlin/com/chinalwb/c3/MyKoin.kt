package com.chinalwb.c3

import com.chinalwb.c2.InjectDelegate

object MyKoin {
    private val container = mutableMapOf<Class<*>, Any>()

    fun startMyKoin(modules: List<Module>) {
        modules.forEach { module ->
            module.getDefinitions().forEach { (clazz, provider) ->
                container[clazz] = provider()
            }
        }
    }

    fun <T : Any> resolve(clazz: Class<T>): T {
        return container[clazz] as? T ?: throw IllegalArgumentException("No instance found for ${clazz.name}")
    }
}

