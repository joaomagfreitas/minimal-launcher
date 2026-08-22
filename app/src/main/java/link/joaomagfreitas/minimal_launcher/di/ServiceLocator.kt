package link.joaomagfreitas.minimal_launcher.di

import java.lang.reflect.Type

class ServiceLocator<T> {
  val container = mutableMapOf<Type, T>()

  inline fun <reified S : T> store(value: S) {
    container[S::class.java] = value
  }

  inline fun <reified S : T> lookup(): S? = container[S::class.java] as S?

  inline fun <reified S : T> get() = lookup<S>()!!
}

val locator = ServiceLocator<Any>()
