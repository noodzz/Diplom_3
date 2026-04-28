package tests;

import api.CreateUserApi;
import api.DeleteUserApi;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    protected String email;
    protected String password;
    protected String accessToken;

    CreateUserApi createUserApi = new CreateUserApi();
    DeleteUserApi deleteUserApi = new DeleteUserApi();

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();

        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equals("yandex")) {
            WebDriverManager.chromedriver().browserVersion("144").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
