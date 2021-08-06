import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By termsAndConditions = By.xpath("//*[@id=\"__next\"]/div[5]/div");
    private By agreeButtonOnTermsAndConditions = By.xpath("//*[contains(@class,'_1UaVm')]");
    private By buttonsOnHomePageHeader = By.xpath("//*[contains(@class,'css-17w4tfg')]");
    private By newsParentDiv = By.xpath("//*[contains(@class,'css-snbr68')]");



    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.navigate().to("https://ikk.hu/");
    }

    public void clickAgreeTermsAndConditions(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(agreeButtonOnTermsAndConditions));
        driver.findElement(agreeButtonOnTermsAndConditions).click();
    }
    public void clickOnHomeButton(){
        List<WebElement> buttonsOnHomePage = driver.findElements(buttonsOnHomePageHeader);
        if(buttonsOnHomePage.size()>0){
            buttonsOnHomePage.get(0).click();
        }
    }
    public boolean clickOnNewsArticle(String nameArticle){
        boolean isContains = false;
        List<WebElement> parentDiv = driver.findElements(newsParentDiv);
        for(WebElement div : parentDiv){
            WebElement currentDiv = div.findElement(By.xpath(".//a"));
            if(currentDiv.getText().equals(nameArticle)){
                isContains = true;
                break;
            }
        }
        return isContains;
    }
}
