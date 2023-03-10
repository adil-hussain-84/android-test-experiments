package androidx.test.experiments.app

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * This test class runs successfully when run without Android Test Orchestrator
 * but fails when run with Android Test Orchestrator.
 *
 * It appears that if any of the parameters returned by the [data] method
 * (which is marked with the [Parameterized.Parameters] annotation)
 * is an enum value, then `{0}`, `{1}` etc can't be used in the [Parameterized.Parameters.name] pattern.
 */
@RunWith(Parameterized::class)
class BadParameterizedTest(private val operation: Operation,
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
        @Parameterized.Parameters(name = "{0}({1},{2}) = {3}")
        fun data(): Array<Array<*>> {
            return arrayOf(
                arrayOf(Operation.PLUS, 1, 1, 2),
                arrayOf(Operation.PLUS, 2, 2, 4),
            )
        }
    }
}