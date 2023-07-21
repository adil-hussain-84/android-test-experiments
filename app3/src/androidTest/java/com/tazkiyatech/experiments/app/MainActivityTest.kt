package com.tazkiyatech.experiments.app

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ActivityScenario.launchActivityForResult
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private var activityScenario: ActivityScenario<MainActivity>? = null

    private val applicationContext: Context
        get() = ApplicationProvider.getApplicationContext()

    @After
    fun tearDown() {
        activityScenario?.close()
    }

    @Test
    fun launch_with_activity_class() {
        // When.
        activityScenario = launch(MainActivity::class.java)

        onView(withId(R.id.textView)).check(matches(withText(R.string.hello_world)))
    }

    @Test
    fun launch_with_intent() {
        // Given.
        val intent = Intent(applicationContext, MainActivity::class.java)

        // When.
        activityScenario = launch(intent)

        onView(withId(R.id.textView)).check(matches(withText(R.string.hello_world)))
    }

    @Test
    fun launchActivityForResult_with_activity_class() {
        // When.
        activityScenario = launchActivityForResult(MainActivity::class.java)

        // Then.
        onView(withId(R.id.textView)).check(matches(withText(R.string.hello_world)))
    }

    @Test
    fun launchActivityForResult_with_intent() {
        // Given.
        val intent = Intent(applicationContext, MainActivity::class.java)

        // When.
        activityScenario = launchActivityForResult(intent)

        // Then.
        onView(withId(R.id.textView)).check(matches(withText(R.string.hello_world)))
    }
}