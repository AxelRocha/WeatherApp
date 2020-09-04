package com.example.weatherapp.ui.search;


import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import com.example.weatherapp.R;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchFlowTest {

    @Rule
    public ActivityScenarioRule<SearchActivity> activityRule = new ActivityScenarioRule<>(SearchActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void searchFlowTest() {

        onView(withId(R.id.searchEditText)).perform(typeText("Curitiba"));

        onView(withId(R.id.searchBtn)).perform(click());

        onView(isRoot()).perform(waitFor(2000));

        intended(allOf(
                hasComponent(hasShortClassName(".ui.details.DetailsActivity")),
                toPackage("com.example.weatherapp")
        ));

        onView(withId(R.id.currentCelsiusTV)).check(matches(isDisplayed()));

        onView(withId(R.id.minCurrentCelsiusTV)).check(matches(isDisplayed()));

        onView(withId(R.id.maxCurrentCelsiusTV)).check(matches(isDisplayed()));

        onView(withId(R.id.currentDescription)).check(matches(isDisplayed()));

        onView(withId(R.id.minForecastCelsiusTV)).check(matches(isDisplayed()));

        onView(withId(R.id.maxForecastCelsiusTV)).check(matches(isDisplayed()));

        onView(withId(R.id.forecastDescription)).check(matches(isDisplayed()));

        onView(withId(R.id.redoSearch)).perform(click());
    }

    public static ViewAction waitFor(final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Wait for " + millis + " milliseconds.";
            }

            @Override
            public void perform(UiController uiController, final View view) {
                uiController.loopMainThreadForAtLeast(millis);
            }
        };
    }
}
