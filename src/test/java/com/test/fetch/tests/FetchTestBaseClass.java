package com.test.fetch.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class FetchTestBaseClass {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get("http://sdetchallenge.fetch.com/");
    }

    @AfterMethod
    public void teardown(){
        //driver.quit();
    }
}
