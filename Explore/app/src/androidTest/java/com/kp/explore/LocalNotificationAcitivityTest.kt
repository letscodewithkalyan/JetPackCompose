package com.kp.explore

import android.app.NotificationManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class LocalNotificationAcitivityTest{

    @get:Rule
    val activityScenarioRule = activityScenarioRule<LocalNotificationAcitivity>()
    @get:Rule
    var permissionRule = GrantPermissionRule.grant(android.Manifest.permission.POST_NOTIFICATIONS)

    @Test
    fun notificationClick_OpenNotification()
    {
        //Arrange
        onView(withId(R.id.title_text)).perform(typeText("Title"))
        onView(withId(R.id.description_text)).perform(typeText("Description"))

        //Act
        onView(withId(R.id.sendButton)).perform(click())

    }
}