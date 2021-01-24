package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleHomePage {

    private WebDriver driver;
    private String CloudGoogle_HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement inputSearch;


    public CloudGoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleHomePage maximizeWindow() {
        driver.manage().window().maximize();
        return this;
    }

    public CloudGoogleHomePage openPage() {
        driver.get(CloudGoogle_HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
        return this;
    }

    public CloudGoogleHomePage SearchCalculator(String text) {
        inputSearch.sendKeys(text);
        return this;
    }

    public CloudGoogleHomePage clickOnSearchField() {
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

}
