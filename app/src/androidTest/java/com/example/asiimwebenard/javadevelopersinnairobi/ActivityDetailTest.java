package com.example.asiimwebenard.javadevelopersinnairobi;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ActivityDetailTest {
    @Rule
    public ActivityTestRule<DetailActivity> activityActivityTestRule = new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void profileImageShouldBeDisplayed(){
        onView(withId(R.id.profile_photo)).check(matches(isDisplayed()));
    }

    @Test
    public void usernameShouldBeDisplayed(){
        onView(withId(R.id.username)).check(matches(isDisplayed()));
    }

    @Test
    public void repositoryNumberShoudBeDisplayed(){
        onView(withId(R.id.repo_number)).check(matches(isDisplayed()));
    }

    @Test
    public void repoTextViewShouldBeDisplayed(){
        onView(withId(R.id.repo_text)).check(matches(isDisplayed()));
    }

    @Test
    public void githubTextViewShouldBeDisplayed(){
        onView(withId(R.id.github_text)).check(matches(isDisplayed()));
    }

    @Test
    public void shareButtonShouldBeDisplayed(){
        onView(withId(R.id.imageButton)).check(matches(isDisplayed()));
    }

    @Test
    public void shareButtonIsClickable(){
        onView(withId(R.id.imageButton)).check(matches(isClickable()));
    }

    @Test
    public void backgroundImageShouldBeDisplayed(){
        onView(withId(R.id.background_image_detailView)).check(matches(isDisplayed()));
    }
}
