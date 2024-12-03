package org.example.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    // PageObject для страницы входа
    private WebDriver driver;

    // Email
    private By emailField = By.xpath(".//input[@type='text']");
    // Пароль
    private By passwordField = By.xpath(".//input[@type='password']");
    //Кнопка Войти
    private By loginButton = By.xpath(".//button[text()='Войти']");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Вход в аккаунт
    @Step
    public void login(String email, String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Проверка отображения кнопки Войти
    @Step
    public boolean loginButtonIsDisplayed() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
