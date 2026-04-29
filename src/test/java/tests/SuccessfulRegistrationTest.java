package tests;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import models.User;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.Urls;

import static org.junit.Assert.assertTrue;

public class SuccessfulRegistrationTest extends BaseTest{

    @Description("Успешная регистрация пользователя")
    @Test
    public void shouldRegisterSuccessfully() {
        email = "BobTheMinion" + System.currentTimeMillis() + "@yandex.ru";
        password = "qwerty";

        driver.get(Urls.REGISTER);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillForm("Боб", email, password);

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoginPageOpened());
    }

    @After
    public void deleteUser() {
        if (email != null) {
            User user = new User(email, password, null);
            accessToken = loginApi.login(user)
                    .then()
                    .extract()
                    .path("accessToken");

            deleteUserApi.deleteUser(accessToken);
        }
    }
}
