package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends BasePage {
    private By resetButton = By.xpath(".//button[text() = 'Восстановить']");
    private By loginButton = By.className("Auth_link__1fOlj");

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем, что открыта страница восстановления пароля")
    public boolean isResetPasswordPageOpened() {
        try {
            waitForElement(resetButton);
            return driver.findElement(resetButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Переходим на страницу логина из восстановления пароля")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
