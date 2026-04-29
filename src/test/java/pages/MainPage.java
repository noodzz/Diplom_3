package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private By bunsTab = By.xpath(".//div[span[text()='Булки']]");
    private By saucesTab = By.xpath(".//div[span[text()='Соусы']]");
    private By fillingsTab = By.xpath(".//div[span[text()='Начинки']]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажимаем кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Проверяем, что открыта главная страница")
    public boolean isMainPageOpened() {
        try {
            waitForElement(bunsTab);
            return driver.findElement(bunsTab).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Переходим в 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Выбираем вкладку 'Соусы'")
    public void clickSauces() {
        driver.findElement(saucesTab).click();
    }

    @Step("Выбираем вкладку 'Начинки'")
    public void clickFillings() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Выбираем вкладку 'Булки'")
    public void clickBuns() {
        driver.findElement(bunsTab).click();
    }

    public boolean isSaucesActive() {
        waitForElement(saucesTab);
        return driver.findElement(saucesTab)
                .getAttribute("class")
                .contains("tab_tab_type_current");
    }

    public boolean isFillingsActive() {
        waitForElement(fillingsTab);
        return driver.findElement(fillingsTab)
                .getAttribute("class")
                .contains("tab_tab_type_current");
    }

    public boolean isBunsActive() {
        waitForElement(bunsTab);
        return driver.findElement(bunsTab)
                .getAttribute("class")
                .contains("tab_tab_type_current");
    }
}
