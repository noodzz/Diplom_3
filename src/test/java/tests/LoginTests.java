package tests;

import io.qameta.allure.Description;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import pages.ResetPasswordPage;
import utils.Urls;

import java.util.UUID;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Before
    public void setUpUser() {
        email = "BobTheMinion" + UUID.randomUUID().toString().split("-")[0] + "@ya.ru";
        password = "qwerty123";

        User user = new User(email, password, "Bob");

        accessToken = createUserApi.createUser(user)
                .then()
                .statusCode(SC_OK)
                .extract()
                .path("accessToken");
    }

    private void login(LoginPage loginPage) {
        loginPage.fillLoginForm(email, password);
    }

    @Description("Логин через кнопку 'Войти в аккаунт' на главной странице")
    @Test
    public void shouldLoginFromMainPage() {
        driver.get(Urls.BASE);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoginPageOpened());

        login(loginPage);

        MainPage mainPageAfterLogin = new MainPage(driver);
        assertTrue(mainPageAfterLogin.isMainPageOpened());
    }

    @Description("Логин через кнопку 'Личный кабинет'")
    @Test
    public void shouldLoginFromPersonalAccount() {
        driver.get(Urls.BASE);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoginPageOpened());

        login(loginPage);

        MainPage mainPageAfterLogin = new MainPage(driver);
        assertTrue(mainPageAfterLogin.isMainPageOpened());
    }

    @Description("Логин через форму регистрации")
    @Test
    public void shouldLoginFromRegistrationPage() {
        driver.get(Urls.REGISTER);

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isLoginPageOpened());

        login(loginPage);

        MainPage mainPageAfterLogin = new MainPage(driver);
        assertTrue(mainPageAfterLogin.isMainPageOpened());
    }

    @Description("Логин через форму восстановления пароля")
    @Test
    public void shouldLoginFromResetPassword() {
        driver.get(Urls.LOGIN);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickResetPasswordButton();

        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        assertTrue(resetPasswordPage.isResetPasswordPageOpened());
        resetPasswordPage.clickLoginButton();

        LoginPage loginPageAfterReset = new LoginPage(driver);
        assertTrue(loginPageAfterReset.isLoginPageOpened());
        login(loginPageAfterReset);

        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isMainPageOpened());
    }


    @After
    public void deleteUser() {
        if (accessToken != null) {
            deleteUserApi.deleteUser(accessToken);
        }
    }
}
