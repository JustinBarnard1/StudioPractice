package com.example.studiopractice

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_isActivityVisible() {
        onView(withId(R.id.main))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_nextButton() {
        onView(withId(R.id.activity_main_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.button_next_activity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_isTitleTextDisplayed() {
        onView(withId(R.id.activity_main_title))
            .check(matches(withText(R.string.text_mainactivity)))
    }

    @Test
    fun test_navSecondaryActivity() {
        onView(withId(R.id.button_next_activity))
            .perform(click())
        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_backPress_toMainActivity() {
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}