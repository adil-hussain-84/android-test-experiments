package androidx.test.experiments.app4

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CountViewTest {

    @get:Rule val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent { CountView() }
    }

    @Test
    fun count_text_before_the_increment_count_button_is_tapped() {
        composeTestRule.onNodeWithTag("currentCountText").assertTextEquals("Count is 0")
    }

    @Test
    fun tapping_the_increment_count_button_bumps_up_the_value_in_the_count_text() {
        // When.
        composeTestRule.onNodeWithTag("incrementCountButton").performClick()

        // Then.
        composeTestRule.onNodeWithTag("currentCountText").assertTextEquals("Count is 1")
    }
}
