package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PasteBinHomePage;

public class ICanWinTest {
    private PasteBinHomePage homepage;
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        homepage = new PasteBinHomePage(driver);
    }

    @Test(description = "to make some actions automated")
    public void PastbinAction() {

        homepage
                .maximizeWindow()
                .openPage()
                .inputNewPast("Hello from WebDrive")
                .openDropdownPasteExpiration()
                .select10MinutesFromPasteExpiration()
                .inputPastName("helloweb")
                .scrollDown()
                .submit()
        ;
    }
}
