package golem.ndarray

import golem.matrix.*

/**
 * A set of constructors that must be implemented by a golem backend. Generates various types of matrices.
 * Generic parameter is a type of matrix, i.e. T=NDArray<Double> or T=NDArray<Int>, etc.
 */
interface NDArrayFactory<T>: MatrixFactory<T> {
    /**
     * Generate a zero initialized matrix of the requested shape.
     */
    fun zeros(vararg lengths: Int): T

    /**
     * Creates a matrix of uniform 0-1 random samples
     */
    fun rand(vararg lengths: Int): T

    /**
     * Creates a matrix of unit-normal random samples
     */
    fun randn(vararg lengths: Int): T
}
