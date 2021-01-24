package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PasteCreatedPage {

    private WebDriver driver;

    @FindBy(css = ".bash")
    private List<WebElement> textHighlighted;

    @FindBy(css = ".highlighted-code")
    private WebElement code;

    public PasteCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteCreatedPage waitLoading() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='info-top']/h1")));
        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public int textHighlightedSize() {
        return textHighlighted.size();
    }

    public boolean codeContains(String text) {
        return code.getText().contains(text);
    }
}
