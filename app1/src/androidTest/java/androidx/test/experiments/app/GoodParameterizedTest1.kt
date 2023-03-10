package androidx.test.experiments.app

import androidx.test.experiments.app.GoodParameterizedTest1.Companion.data
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * This test class runs successfully when run with and without Android Test Orchestrator.
 *
 * The only difference between this class and the [BadParameterizedTest] class is the [data] method
 * which is marked with the [Parameterized.Parameters] annotation.
 * The [data] method in this class does not specify a [Parameterized.Parameters.name] pattern
 * and therefore takes the default pattern of `"{index}"`.
 */
@RunWith(Parameterized::class)
class GoodParameterizedTest1(private val operation: Operation,
                             private val input1: Int,
                             private val input2: Int,
                             private val expectedAnswer: Int) {

    @Test
    fun addition() {
        // Given.
        val calculator = Calculator()

        // When.
        val actualAnswer = calculator.calculate(operation, input1, input2)

        // Then.
        assertEquals(expectedAnswer, actualAnswer)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters//(name = "{0}({1},{2}) = {3}")
        fun data(): Array<Array<*>> {
            return arrayOf(
                arrayOf(Operation.PLUS, 1, 1, 2),
                arrayOf(Operation.PLUS, 2, 2, 4),
            )
        }
    }
}