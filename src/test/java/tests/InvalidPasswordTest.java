package tests;

import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.RegistrationPage;
import utils.Urls;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class InvalidPasswordTest extends BaseTest{
    private final String name;
    private final String email;
    private final String password;

    public InvalidPasswordTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}, {2}")
    public static Object[][] data() {
        return new Object[][]{
                {"Боб", "BobTheMinion" + System.currentTimeMillis() + "@yandex.ru", "123"},
                {"Кевин", "KevinTheMinion" + System.currentTimeMillis() + "@yandex.ru", "12345"},
                {"Стюарт", "StuartTheMinion" + System.currentTimeMillis() + "@yandex.ru", "1"},
        };
    }

    @Description("Проверка ошибки при регистрации с паролем меньше 6 символов")
    @Test
    public void shouldShowErrorForShortPassword() {
        driver.get(Urls.REGISTER);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillForm(name, email, password);
        assertTrue(registrationPage.isInvalidPasswordErrorDisplayed());
    }
}
