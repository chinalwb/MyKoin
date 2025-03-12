package com.chinalwb.c4

import com.chinalwb.c3.Module
import kotlin.properties.ReadOnlyProperty

// Koin-like Dependency Container
object MyKoin {
    val singleInstances = mutableMapOf<Class<*>, Any>()
    val factories = mutableMapOf<Class<*>, () -> Any>()
    private val scopes = mutableMapOf<String, MutableMap<Class<*>, Any>>() // Scoped Instances

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
    inline fun <reified T : Any> MyKoin.inject(): ReadOnlyProperty<Any?, T> =
        ReadOnlyProperty<Any?, T> { thisRef, property -> resolve() }


    // Scoped Dependencies
    fun createScope(scopeId: String) {
        scopes[scopeId] = mutableMapOf()
    }

    fun closeScope(scopeId: String) {
        scopes.remove(scopeId)
    }

    fun <T : Any> resolveInScope(scopeId: String, clazz: Class<T>, provider: () -> T): T {
        val scope = scopes[scopeId] ?: throw IllegalArgumentException("Scope $scopeId not found")
        return scope.getOrPut(clazz) { provider() } as T
    }
}


