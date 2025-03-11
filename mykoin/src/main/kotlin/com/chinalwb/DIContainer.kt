package com.chinalwb

object DIContainer {
    private val instances = mutableMapOf<Class<*>, Any>()

    // Register dependencies
    fun <T : Any> register(clazz: Class<T>, instance: T) {
        instances[clazz] = instance
    }

    // Resolve dependencies
    fun <T : Any> resolve(clazz: Class<T>): T {
        // Ctrl + 3
        throw IllegalStateException("No instance found for ${clazz.simpleName}")
     }
}














// todo3
// return instances[clazz] as? T ?: throw IllegalStateException("No instance found for ${clazz.simpleName}")
