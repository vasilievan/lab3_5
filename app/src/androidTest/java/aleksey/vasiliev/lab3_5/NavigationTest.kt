package aleksey.vasiliev.lab3_5

import android.content.pm.ActivityInfo
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get: Rule
    val mainActivityRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)

    @get: Rule
    val aboutActivityRule: ActivityTestRule<AboutActivity> =
        ActivityTestRule(AboutActivity::class.java)

    @Test
    fun about() {
        launchActivity<AboutActivity>()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        mainActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
    }

    @Test
    fun firstFragment() {
        launchActivity<MainActivity>()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        mainActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
    }

    @Test
    fun secondFragment() {
        launchActivity<MainActivity>()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        mainActivityRule.activity.supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, SecondFragment()).commit()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        mainActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
    }

    @Test
    fun thirdFragment() {
        launchActivity<MainActivity>()
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        mainActivityRule.activity.supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, SecondFragment()).commit()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        mainActivityRule.activity.supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, ThirdFragment()).commit()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment2)).check(doesNotExist())
        mainActivityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        Thread.sleep(1000)
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment2)).check(doesNotExist())
    }
}