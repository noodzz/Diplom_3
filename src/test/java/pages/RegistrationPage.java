package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private By name = By.xpath("//label[text()='Имя']/parent::div//input");
    private By email = By.xpath("//label[text()='Email']/parent::div//input");
    private By password = By.xpath(".//input[@name = 'Пароль']");
    private By registerButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private By invalidPasswordError = By.xpath(".//p[text() = 'Некорректный пароль']");
    private By loginButton = By.className("Auth_link__1fOlj");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Вводим имя: {name}")
    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    @Step("Вводим email: {email}")
    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    @Step("Вводим пароль")
    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(this.registerButton).click();
    }

    @Step("Заполняем форму регистрации и отправляем")
    public void fillForm(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    public boolean isInvalidPasswordErrorDisplayed() {
        try {
            waitForElement(invalidPasswordError);
            return driver.findElement(invalidPasswordError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Переходим на страницу логина из формы регистрации")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
