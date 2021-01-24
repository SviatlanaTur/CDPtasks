package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinHomePage {

    private WebDriver driver;
    private String PasteBin_HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement newPaste;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement dropdownPasteExpiration;

    @FindBy(xpath = "//li[@class='select2-results__option'][text()='10 Minutes']")
    private WebElement option10Minutes;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;

    @FindBy(xpath = "//*[@class='top-footer']")
    private WebElement footer;

    @FindBy(xpath = "//button[@class='btn -big'][text()='Create New Paste']")
    private WebElement submitButton;


    public PasteBinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage maximizeWindow() {
        driver.manage().window().maximize();
        return this;
    }

    public PasteBinHomePage openPage() {
        driver.get(PasteBin_HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id = 'postform-text']")));
        return this;
    }

    public PasteBinHomePage inputNewPast(String text) {
        newPaste.sendKeys(text);
        return this;
    }

    public PasteBinHomePage openDropdownPasteExpiration() {
        dropdownPasteExpiration.click();
        return this;
    }

    public PasteBinHomePage select10MinutesFromPasteExpiration() {
        option10Minutes.click();
        return this;
    }

    public PasteBinHomePage inputPastName(String text) {
        pasteName.sendKeys(text);
        return this;
    }

    public PasteBinHomePage scrollDown() {
        Actions actions = new Actions(driver);
        actions.moveToElement(footer);
        actions.perform();
        return this;
    }

    public PasteBinHomePage submit() {
        submitButton.click();
        return this;
    }


}
