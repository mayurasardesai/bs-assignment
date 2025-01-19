package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MainPage {
   public WebDriver driver;

    @FindBy(id = "edition_head")
    private WebElement txt;

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement btn_accept;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("didomi-notice")));
        btn_accept.click();

    }

    public void verifyLanguage(String language){
        Assert.assertEquals(txt.getText(), language);
    }

    public ArticlePage navigateOption(String option){
        String menuElement = "//a[contains(text(),'" +option+ "')]";
        WebElement menuOption =driver.findElement(By.xpath(menuElement));
        menuOption.click();
        return new ArticlePage(driver);
    }
}



