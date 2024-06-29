package com.kp.explore

import android.content.ComponentName
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.internal.inject.TargetContext
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Before
    fun init(){
        Intents.init()
    }

    @After
    fun clean(){
        Intents.release()
    }
    @Test
    fun testParcelableButton_ExpectedFirstActivity(){
        //Act
        onView(withId(R.id.parcebleButton)).perform(click())
        //Assert
        intended(hasComponent(FirstActivity::class.java.name))
    }

    @Test
    fun testContactsButton_ExpectedContactsActivity()
    {
        //Act
        onView(withId(R.id.contanctsButton)).perform(click())
        //Assert
        intended(hasComponent(ContactsActivity::class.java.name))
    }

    @Test
    fun testNotificatioButton_ExpectedNotificationActivity()
    {
        //Act
        onView(withId(R.id.notificationsButton)).perform(click())
        //Assert
        intended(hasComponent(LocalNotificationAcitivity::class.java.name))
    }

}