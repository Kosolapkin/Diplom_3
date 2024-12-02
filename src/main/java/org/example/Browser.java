package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    public WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\Михаил\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Не поддерживаемый браузер: " + browserName);
        }
    }
}
