package tests;

import io.qameta.allure.Description;
import org.junit.Test;
import pages.MainPage;
import utils.Urls;

import static org.junit.Assert.assertTrue;

public class TabsTests extends BaseTest {

    @Description("Проверка, что по умолчанию открыта вкладка 'Булки'")
    @Test
    public void shouldBeDefaultBuns() {
        driver.get(Urls.BASE);
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.isBunsActive());
    }

    @Description("Проверка переключения на вкладку 'Соусы'")
    @Test
    public void shouldSwitchToSauces() {
        driver.get(Urls.BASE);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauces();
        assertTrue(mainPage.isSaucesActive());
    }

    @Description("Проверка переключения на вкладку 'Начинки'")
    @Test
    public void shouldSwitchToFillings() {
        driver.get(Urls.BASE);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillings();
        assertTrue(mainPage.isFillingsActive());
    }

    @Description("Проверка возврата на вкладку 'Булки'")
    @Test
    public void shouldSwitchToBuns() {
        driver.get(Urls.BASE);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauces();
        mainPage.clickBuns();
        assertTrue(mainPage.isBunsActive());
    }
}
