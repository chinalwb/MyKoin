package com.chinalwb.c4

// Koin-like Dependency Container
object MyKoin {
    val singleInstances = mutableMapOf<Class<*>, Any>()
    val factories = mutableMapOf<Class<*>, () -> Any>()

    // Load Modules
    fun loadModules(modules: List<Module>) {
        modules.forEach { module ->
            module.getDefinitions().forEach { (clazz, provider, isFactory) ->
                if (isFactory) {
                    factories[clazz] = provider // Factory: Creates new instances
                } else {
                    singleInstances[clazz] = provider() // Singleton: One-time initialization
                }
            }
        }
    }

    // Resolve Singleton or Factory Instances
    inline fun <reified T : Any> resolve(): T {
        val clazz = T::class.java
        return singleInstances[clazz] as? T
            ?: factories[clazz]?.invoke() as? T
            ?: throw IllegalArgumentException("No instance found for ${clazz.name}")
    }

    // Property Delegate for `by inject()`
//    inline fun <reified T : Any> inject(): ReadOnlyProperty<Any?, T> =
//        ReadOnlyProperty<Any?, T> { thisRef, property -> resolve() }

    inline fun <reified T : Any> inject(): Lazy<T> = lazy { resolve() }

}


