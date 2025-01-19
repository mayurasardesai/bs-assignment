package org.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public WebDriver initChromeDriver() {
        return new ChromeDriver();
    }

}
