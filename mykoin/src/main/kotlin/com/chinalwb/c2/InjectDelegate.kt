package com.chinalwb.c2

import com.chinalwb.DIContainer
import com.chinalwb.c3.MyKoin
import kotlin.reflect.KProperty

class InjectDelegate<T : Any>(private val clazz: Class<T>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return MyKoin.resolve(clazz)
    }
}

// Generic extension function for convenience
inline fun <reified T : Any> inject(): InjectDelegate<T> {
    return InjectDelegate(T::class.java)
}
