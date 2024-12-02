package org.example.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    // PageObject для главной страницы
    private WebDriver driver;

    //Кнопка Войти в аккаунт
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // Кнопка Личный кабинет
    private By profileButton = By.xpath(".//a[@href='/account']");
    // Кнопка Оформить заказ
    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    // раздел Булки
    private By sectionBun = By.xpath(".//span[text()='Булки']");
    // раздел Соусы
    private By sectionSauce = By.xpath(".//span[text()='Соусы']");
    // раздел Начинки
    private By sectionTopping = By.xpath(".//span[text()='Начинки']");
    // заголовок Булки
    private By headerBun = By.xpath(".//h2[text()='Булки']");
    // заголовок Соусы
    private By headerSauce = By.xpath(".//h2[text()='Соусы']");
    // заголовок Начинки
    private By headerTopping = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    // Нажатие на кнопку Войти в аккаунт
    @Step
    public void loginButtonClick () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    // Нажатие на кнопку Личный кабинет
    @Step
    public void profileButtonClick () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        driver.findElement(profileButton).click();
    }

    // Нажатие на раздел Булки
    @Step
    public void sectionBunClick () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(sectionBun));
        driver.findElement(sectionBun).click();
    }

    // Нажатие на раздел Соусы
    @Step
    public void sectionSauceClick () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(sectionSauce));
        driver.findElement(sectionSauce).click();
    }

    // Нажатие на раздел Начинки
    @Step
    public void sectionToppingClick () {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(sectionTopping));
        driver.findElement(sectionTopping).click();
    }

    // Проверка отображения кнопки перехода в Личный кабинет
    @Step
    public boolean profileButtonIsDisplayed() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        try {
            return driver.findElement(profileButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Проверка отображения кнопки Оформить заказ
    @Step
    public boolean createOrderButtonIsDisplayed() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        try {
            return driver.findElement(createOrderButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Проверка отображения заголовка Булки
    @Step
    public boolean headerBunIsDisplayed() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerBun));
        try {
            return driver.findElement(headerBun).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Проверка отображения заголовка Соусы
    @Step
    public boolean headerSauceIsDisplayed() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerSauce));
        try {
            return driver.findElement(headerSauce).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Проверка отображения заголовка Начинки
    @Step
    public boolean headerToppingIsDisplayed() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerTopping));
        try {
            return driver.findElement(headerTopping).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Скролл до появления заголовка Начинки
    public void constructorScrollDown() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(headerTopping));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(headerTopping));
    }
}
