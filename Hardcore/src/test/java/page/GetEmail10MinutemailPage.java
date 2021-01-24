package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetEmail10MinutemailPage {

    private WebDriver driver;
    private String emailGenerate_HOMEPAGE_URL = "https://10minutemail.com/";

    @FindBy(xpath = "//input[@id = 'mail_address']")
    private WebElement emailGenerated;

    @FindBy(xpath = "//div[@id = 'copy_address']")
    private WebElement copyEmailButton;

    @FindBy(xpath = "//div[@class='small_subject']")
    private WebElement emailReceived;

    @FindBy(xpath = "//div[@class= 'mail_message mail_message_expanded']//h2")
    private WebElement textFromEmail;

    public GetEmail10MinutemailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public GetEmail10MinutemailPage maximizeWindow() {
        driver.manage().window().maximize();
        return this;
    }

    public GetEmail10MinutemailPage openEmailGeneratePage() {
        driver.get(emailGenerate_HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = 'mail_address']")));
        return this;
    }

    public GetEmail10MinutemailPage copyEmail() {
        copyEmailButton.click();
        return this;
    }


    public GetEmail10MinutemailPage checkEmailReceived() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message_top']")));
        emailReceived.click();
        return this;
    }

    public GetEmail10MinutemailPage waitEmailExpands() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class= 'mail_message mail_message_expanded']//h2")));
        return this;
    }

    public String checkEstimatedCosts () {
        String textFromEmail = driver.findElement(By.xpath("//div[@class= 'mail_message mail_message_expanded']//h2[contains(., 'Estimated Monthly Cost: USD 1,082.77')]")).getText();
        return textFromEmail;
    }

}
