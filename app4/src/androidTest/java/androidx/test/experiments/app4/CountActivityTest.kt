package androidx.test.experiments.app4

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CountActivityTest {

    @get:Rule val activityScenarioRule = ActivityScenarioRule(CountActivity::class.java)

    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun count_text_before_the_increment_count_button_is_tapped() {
        composeTestRule.onNodeWithTag("currentCountText").assertTextEquals("Count is 0")
    }

    @Test
    fun tapping_the_increment_count_button_bumps_up_the_count_value_in_the_count_text() {
        // When.
        composeTestRule.onNodeWithTag("incrementCountButton").performClick()

        // Then.
        composeTestRule.onNodeWithTag("currentCountText").assertTextEquals("Count is 1")
    }

    @Test
    fun count_text_is_restored_on_activity_recreation() {
        // Given.
        composeTestRule.onNodeWithTag("incrementCountButton").performClick()

        // When.
        activityScenarioRule.scenario.recreate()

        // Then.
        composeTestRule.onNodeWithTag("currentCountText").assertTextEquals("Count is 1")
    }
}
