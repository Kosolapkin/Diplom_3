import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.Browser;
import org.example.Resources;
import org.example.api.UserApiSteps;
import org.example.api.UserCreateAndEditRequest;
import org.example.api.UserLoginRequest;
import org.example.pageObject.LoginPage;
import org.example.pageObject.MainPage;
import org.example.pageObject.ProfilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProfileTest {

    private WebDriver driver;

    @Before
    public void createUser() {
        UserApiSteps userApiSteps = new UserApiSteps();
        UserCreateAndEditRequest userCreateAndEditRequest = new UserCreateAndEditRequest(Resources.email, Resources.valid_password, Resources.name);
        userApiSteps.userCreate(userCreateAndEditRequest);
    }

    @Before
    public void setUp() {
        Browser browser = new Browser();
        driver = browser.getWebDriver(Resources.browserName);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @After
    public void deleteUser() {
        UserApiSteps userApiSteps = new UserApiSteps();
        UserLoginRequest userLoginRequest= new UserLoginRequest(Resources.email, Resources.valid_password);
        userApiSteps.userDeleteAfterLogin(userLoginRequest);
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка возможности входа в личный кабинет после нажатия на кнопку Личный кабинет на главной странице")
    public void SwitchingToProfileFromMain() {
        driver.get(Resources.loginURL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Resources.email, Resources.valid_password);

        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue("После нажатия на кнопку не произошел редирект в личный кабинет", profilePage.exitButtonIsDisplayed());

    }

    @Test
    @DisplayName("Переход в конструктор через кнопку Конструктор")
    @Description("Проверка возможности перехода к конструктору после нажатия на кнопку Конструктор в профиле пользователя")
    public void SwitchingToConstructorAfterConstructorButtonClick() {
        driver.get(Resources.loginURL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Resources.email, Resources.valid_password);
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.constructorButtonClick();
        assertTrue("После нажатия на кнопку не произошел редирект на главную страницу", mainPage.profileButtonIsDisplayed());

    }

    @Test
    @DisplayName("Переход в конструктор через Логотип")
    @Description("Проверка возможности перехода к конструктору после нажатия на Логотип в профиле пользователя")
    public void SwitchingToConstructorAfterLogoClick() {
        driver.get(Resources.loginURL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Resources.email, Resources.valid_password);
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.logoClick();
        assertTrue("После нажатия на кнопку не произошел редирект на главную страницу", mainPage.profileButtonIsDisplayed());

    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка возможности выйти из аккаунта после нажатия на кнопку Выход в профиле пользователя")
    public void LogoutAfterExitButtonClick() {
        driver.get(Resources.loginURL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Resources.email, Resources.valid_password);
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.exitButtonClick();
        assertTrue("Выход из профиля не произошел", loginPage.loginButtonIsDisplayed());

    }

}
