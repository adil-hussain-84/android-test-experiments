package androidx.test.experiments.app

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * This parameterised test class runs successfully when run with and without Android Test Orchestrator.
 *
 * The difference between this class and the [BadParameterizedTest] class
 * is that none of the parameters in this class is an enum value.
 * The two classes are otherwise identical.
 */
@RunWith(Parameterized::class)
class GoodParameterizedTest2(private val input1: Int,
                             private val input2: Int,
                             private val expectedAnswer: Int) {

    @Test
    fun addition() {
        // When.
        val actualAnswer = input1 + input2

        // Then.
        assertEquals(expectedAnswer, actualAnswer)
    }

    companion object {

        /**
         * Provides the parameters to be injected into instances of the [GoodParameterizedTest2] class.
         */
        @JvmStatic
        @Parameterized.Parameters(name = "{0} + {1}) = {2}")
        fun data(): Array<Array<*>> {
            return arrayOf(
                arrayOf(1, 1, 2),
                arrayOf(2, 2, 4),
            )
        }
    }
}
