package com.test.fetch.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverHelper;

import java.time.Duration;
import java.util.List;

public class FetchMainPage {
    public FetchMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    WebDriver driver = DriverHelper.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//div[@class='result']//button[@id='reset']")
    WebElement result;

    @FindBy(css = "#weigh")
    WebElement weighButton;

    @FindBy(xpath = "//button[.='Reset']")
    WebElement resetButton;

    @FindBy(xpath = "//div[@class='game-board'][1]//div[2]//input")
    List<WebElement> leftBowlFirstRow;

    @FindBy(xpath = "//div[@class='game-board'][2]//div[2]//input")
    List<WebElement> rightBowlFirstRow;

    @FindBy(xpath = "//ol//li")
    WebElement weighing1;

    @FindBy(xpath = "//ol/li[2]")
    WebElement weighing2;

    @FindBy(xpath = "//div[@class='coins']//button")
    List<WebElement> coins;


    public void clickWeighButton1() throws InterruptedException {
        Thread.sleep(500);
        weighButton.click();
        wait.until(ExpectedConditions.visibilityOf(weighing1));
    }

    public void clickResetButton(){
        resetButton.click();
    }

    public void clickWeighButton2() throws InterruptedException {
        Thread.sleep(500);
        weighButton.click();
        wait.until(ExpectedConditions.visibilityOf(weighing2));
    }

    public void putFirstThreeNumbersLeftBowl(){
        leftBowlFirstRow.get(0).sendKeys("0");
        leftBowlFirstRow.get(1).sendKeys("1");
        leftBowlFirstRow.get(2).sendKeys("2");
    }

    public void putSecondThreeNumbersRightBowl() throws InterruptedException {
        rightBowlFirstRow.get(0).sendKeys("3");
        rightBowlFirstRow.get(1).sendKeys("4");
        rightBowlFirstRow.get(2).sendKeys("5");
        clickWeighButton1();
    }


    public void checkByResult() throws InterruptedException {
        if (result.getText().equals("<")){
            findFakeCoin(0);
        } else if (result.getText().equals(">")) {
            findFakeCoin(3);
        } else {
            findFakeCoin(6);
        }
    }

    public void findFakeCoin(int i) throws InterruptedException {
        clickResetButton();
        leftBowlFirstRow.get(0).sendKeys(coins.get(i).getText());
        rightBowlFirstRow.get(0).sendKeys(coins.get(i+1).getText());
        clickWeighButton2();
        if(result.getText().equalsIgnoreCase("<")){
            coins.get(i).click();
        } else if (result.getText().equalsIgnoreCase(">")) {
            coins.get(i+1).click();
        } else {
            coins.get(i+2).click();
        }
    }

    public void messageValidation(){
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText().trim();
        Assert.assertEquals(actualMessage,"Yay! You find it!");
    }

}
