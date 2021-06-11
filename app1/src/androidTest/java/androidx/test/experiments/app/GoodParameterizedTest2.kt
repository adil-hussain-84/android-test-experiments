package androidx.test.experiments.app

import androidx.test.experiments.app.GoodParameterizedTest.Companion.data
import androidx.test.experiments.app.GoodParameterizedTest2.Companion.data
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * This test class runs successfully when run with Android Test Orchestrator
 * despite the [data] method in this class specifying a [Parameterized.Parameters.name] pattern
 * which contains `{0}`, `{1}` etc.
 *
 * The difference between this class and the [BadParameterizedTest] class
 * is that all of the parameters in this class are primitives.
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