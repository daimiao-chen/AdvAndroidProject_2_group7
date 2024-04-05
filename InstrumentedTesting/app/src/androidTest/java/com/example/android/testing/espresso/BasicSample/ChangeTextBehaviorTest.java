/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.espresso.BasicSample;

import android.app.Activity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {

    public static final String STRING_TO_BE_TYPED = "Espresso";

    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkTextToBeChanged() {
        onView(withId(R.id.textToBeChanged)).check(matches(withText("Hello Espresso!")));
    }
    @Test
    public void enterString_changeTextButton_checkTextToBeChanged() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("123")));
    }

    @Test
    public void enterString_openActivityAndChangeButton_checkShowTextView() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"));
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("123")));
    }

    @Test
    public void changeTextButton_checkTextToBeChanged() {
        onView(withId(R.id.changeTextBt)).perform(click());

        onView(withId(R.id.textToBeChanged)).check(matches(withText("")));
    }

    @Test
    public void openActivityAndChangeButton_checkShowTextView() {
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("")));
    }

    @Test
    public void enterString_changeTextButton_checkTextToBeChanged_abcdef() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")));
    }

    @Test
    public void enterString_openActivityAndChangeButton_checkShowTextView_abcdef() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"));
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")));
    }

}