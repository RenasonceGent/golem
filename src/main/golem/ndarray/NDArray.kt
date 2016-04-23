package golem.ndarray

import golem.matrix.*
import java.io.ObjectOutputStream
import java.io.Serializable
import java.io.StreamCorruptedException

interface NDArray<T> : Iterable<T>, Serializable {
    operator fun get(vararg indices: Int)
    operator fun set(vararg indices: Int, value: Double)
    operator fun mod(other: NDArray<T>): NDArray<T>
    operator fun div(other: Int): NDArray<T>
    operator fun div(other: T): NDArray<T>
    operator fun times(other: NDArray<T>): NDArray<T>
    operator fun times(other: T): NDArray<T>
    operator fun unaryMinus(): NDArray<T>
    operator fun minus(other: T): NDArray<T>
    operator fun minus(other: NDArray<T>): NDArray<T>
    operator fun plus(other: T): NDArray<T>
    operator fun plus(other: NDArray<T>): NDArray<T>
    infix fun pow(exponent: Int): NDArray<T>

    fun shape(): List<Int>
    fun copy(): NDArray<T>

    fun getBaseArray(): Any
    fun getFactory(): NDArrayFactory<NDArray<T>>

    fun serializeObject(out: ObjectOutputStream): Unit {
        out.writeObject(this.shape())
        this.forEach { out.writeObject(it) }
    }

    fun deserializeObjectNoData() {
        throw StreamCorruptedException("No Data for Matrix In Stream")
    }
}
