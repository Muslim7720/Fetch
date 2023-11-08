package com.test.fetch.tests;

import com.test.fetch.pages.FetchMainPage;

import org.testng.annotations.Test;

public class FakeAlert extends FetchTestBaseClass {



    @Test
    public void fakeBarAlert() throws InterruptedException {
        FetchMainPage fetchMainPage = new FetchMainPage(driver);
        fetchMainPage.putFirstThreeNumbersLeftBowl();
        fetchMainPage.putSecondThreeNumbersRightBowl();
        fetchMainPage.clickWeighButton1();
        fetchMainPage.checkByResult();
        fetchMainPage.messageValidation();

    }
}
