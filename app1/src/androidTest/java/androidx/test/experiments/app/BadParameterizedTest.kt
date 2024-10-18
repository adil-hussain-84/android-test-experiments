package androidx.test.experiments.app

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * This parameterised test class runs successfully with Android Test Orchestrator as long as it is run with
 * version 3.5.1 (or later) of the [androidx.test.espresso:espresso-core](https://maven.google.com/web/index.html#androidx.test.espresso:espresso-core) library
 * and version 1.4.2 (or later) of the [androidx.test:orchestrator](https://maven.google.com/web/index.html#androidx.test:orchestrator) library.
 *
 * Earlier versions of the [androidx.test.espresso:espresso-core](https://maven.google.com/web/index.html#androidx.test.espresso:espresso-core)
 * and [androidx.test:orchestrator](https://maven.google.com/web/index.html#androidx.test:orchestrator) libraries
 * struggled to cope with a [Parameterized.Parameters] annotation
 * which received a [Parameterized.Parameters.name] value that referenced an enum value parameter.
 * As an example, consider this parameterised test class.
 * It receives an [Operation] enum value as its first parameter.
 * Because of this, in earlier versions of the [androidx.test.espresso:espresso-core](https://maven.google.com/web/index.html#androidx.test.espresso:espresso-core)
 * and [androidx.test:orchestrator](https://maven.google.com/web/index.html#androidx.test:orchestrator) libraries,
 * you wouldn't have been able to have `{0}` in the [Parameterized.Parameters.name] value.
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

        /**
         * Provides the parameters to be injected into instances of the [BadParameterizedTest] class.
         */
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
