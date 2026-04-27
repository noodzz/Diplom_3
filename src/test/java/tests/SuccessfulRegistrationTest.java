package tests;

import io.qameta.allure.Description;
import org.junit.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.Urls;

import static org.junit.Assert.assertTrue;

public class SuccessfulRegistrationTest extends BaseTest{

    @Description("Успешная регистрация пользователя")
    @Test
    public void shouldRegisterSuccessfully() {
        driver.get(Urls.REGISTER);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillForm("Боб", "BobTheMinion" + System.currentTimeMillis() + "@yandex.ru", "qwerty");

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoginPageOpened());
    }
}
