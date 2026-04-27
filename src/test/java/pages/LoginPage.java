package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By email = By.xpath("//label[text()='Email']/parent::div//input");
    private By password = By.xpath(".//input[@name = 'Пароль']");
    private By loginButton = By.xpath(".//button[text() = 'Войти']");
    private By resetPasswordButton = By.xpath(".//a[@href = '/forgot-password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что открыта страница логина")
    public boolean isLoginPageOpened() {
        try {
            waitForElement(loginButton);
            return driver.findElement(loginButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Вводим email: {email}")
    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    @Step("Вводим пароль")
    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Заполняем форму логина и нажимаем 'Войти'")
    public void fillLoginForm(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    @Step("Переходим в восстановление пароля")
    public void clickResetPasswordButton() {
        driver.findElement(resetPasswordButton).click();
    }
}
