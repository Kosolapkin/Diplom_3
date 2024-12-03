import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.Browser;
import org.example.Resources;
import org.example.api.UserApiSteps;
import org.example.api.UserLoginRequest;
import org.example.pageObject.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private WebDriver driver;
    private boolean skipUserDelete = false;

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
        if (!skipUserDelete) {
            UserApiSteps userApiSteps = new UserApiSteps();
            UserLoginRequest userLoginRequest = new UserLoginRequest(Resources.email, Resources.valid_password);
            userApiSteps.userDeleteAfterLogin(userLoginRequest);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка возможности регистрации пользователя с валидными данными")
    public void SuccessfulRegistrationWithValidData() {
        driver.get(Resources.registerURL);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registration(Resources.name, Resources.email, Resources.valid_password);

        UserLoginRequest userLoginRequest = new UserLoginRequest(Resources.email, Resources.valid_password);
        UserApiSteps userSteps = new UserApiSteps();
        userSteps.userLogin(userLoginRequest)
                .assertThat().body("success", equalTo(true))
                .and()
                .statusCode(200);

    }

    @Test
    @DisplayName("Ошибка регистрации")
    @Description("Проверка ошибки при попытке регистрации пользователя с паролем менее 6 символов")
    public void FailedRegistrationWithPasswordLessThen6Symbols() {
        skipUserDelete = true;
        driver.get(Resources.registerURL);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registration(Resources.name, Resources.email, Resources.wrong_password);

        assertTrue("Не появилось сообщение о некорректном пароле", registerPage.wrongPasswordTextIsDisplayed());

    }

}
