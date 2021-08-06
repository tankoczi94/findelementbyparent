import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HasArticleTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void hasArticle(){
        homePage = new HomePage(driver);
        homePage.clickAgreeTermsAndConditions();
        homePage.clickOnHomeButton();
        boolean isContains = homePage.clickOnNewsArticle("Robotolimpia");
        Assertions.assertTrue(isContains);
    }

}
