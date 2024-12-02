import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.Browser;
import org.example.Resources;
import org.example.pageObject.MainPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MainPageTest {

    private WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Проверка возможности перехода к разделу Начинки на главной странице")
    public void SwitchingToSectionTopping() {
        Browser browser = new Browser();
        driver = browser.getWebDriver(Resources.browserName);
        driver.get(Resources.mainURL);

        MainPage mainPage = new MainPage(driver);
        mainPage.sectionToppingClick();
        assertTrue("Не произошел переход к разделу Начинки", mainPage.headerToppingIsDisplayed());

    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Проверка возможности перехода к разделу Соусы на главной странице")
    public void SwitchingToSectionSauce() {
        Browser browser = new Browser();
        driver = browser.getWebDriver(Resources.browserName);
        driver.get(Resources.mainURL);

        MainPage mainPage = new MainPage(driver);
        mainPage.sectionSauceClick();
        assertTrue("Не произошел переход к разделу Соусы", mainPage.headerSauceIsDisplayed());

    }

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Проверка возможности перехода к разделу Булки на главной странице")
    public void SwitchingToSectionBun() {
        Browser browser = new Browser();
        driver = browser.getWebDriver(Resources.browserName);
        driver.get(Resources.mainURL);

        MainPage mainPage = new MainPage(driver);
        mainPage.constructorScrollDown();
        mainPage.sectionBunClick();
        assertTrue("Не произошел переход к разделу Булки", mainPage.headerBunIsDisplayed());

    }

}
