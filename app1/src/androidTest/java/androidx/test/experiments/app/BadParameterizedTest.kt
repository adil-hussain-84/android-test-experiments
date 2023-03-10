package androidx.test.experiments.app

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * This test class runs successfully with Android Test Orchestrator
 * as long as version 3.5.1 (or later) of the 'androidx.test.espresso:espresso-core' library
 * and version 1.4.2 (or later) of the 'androidx.test:orchestrator' library is used.
 *
 * Earlier versions of the 'androidx.test.espresso:espresso-core' and 'androidx.test:orchestrator' libraries
 * struggled to cope with a [Parameterized.Parameters] annotation
 * which received `{0}`, `{1}` etc in the [Parameterized.Parameters.name] pattern
 * where any of the parameters corresponded to an enum value.
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