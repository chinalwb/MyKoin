package com.chinalwb

import kotlin.reflect.KProperty

class InjectDelegate<T : Any>(private val clazz: Class<T>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return DIContainer.resolve(clazz)
    }
}

// Generic extension function for convenience
inline fun <reified T : Any> inject(): InjectDelegate<T> {
    return InjectDelegate(T::class.java)
}
