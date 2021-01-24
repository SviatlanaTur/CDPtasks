package text;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CloudGoogleActions {

    private CloudGoogleHomePage homepage;
    private SearchResultsPage search_results_page;
    private PricingCalculatorPage calculator_page;
    private GetEmail10MinutemailPage email_page;
    private ActionsBetweenWindows actions_between_windows;

    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        homepage = new CloudGoogleHomePage(driver);
        search_results_page = new SearchResultsPage(driver);
        calculator_page = new PricingCalculatorPage(driver);
        email_page = new GetEmail10MinutemailPage(driver);
        actions_between_windows = new ActionsBetweenWindows(driver);
    }

    @Test(description = "to test Google Cloud Platform Pricing Calculator")
    public void PastbinAction() throws IOException, UnsupportedFlavorException {

        homepage
                .maximizeWindow()
                .openPage()
                .SearchCalculator("Google Cloud Platform Pricing Calculator")
                .clickOnSearchField()
        ;
        search_results_page
                .waitLoading()
                .openCalculatorPageFromResults()
        ;
        calculator_page
                .waitLoadingIframe1()
                .switchToiFrame1()
                .waitLoadingIframe2()
                .switchToiFrame2()
                .ClickOnComputeEngineTab()
                .enterNumberOfInstances("4")
                .openDropdownSelectSeries()
                .waitForDropdownLoading()
                .selectN1SelectSeries()
                .openDropdownMachineType()
                .waitForDropdownLoading()
                .scrollDownToN1StandardOption()
                .selectN1StandardOption()
                .checkAddGPUs()
                .openDropdownNumberOfGPUs()
                .waitForDropdownLoading()
                .select1NumberOfGPUs()
                .scrollDownToButtonAddToEstimate()
                .openDropdownGPUType()
                .waitForDropdownLoading()
                .selectTesla100GPUType()
                .openDropdownLocalSSD()
                .waitForDropdownLoading()
                .select2x375LocalSSD()
                .openDropdownCommittedUsage()
                .waitForDropdownLoading()
                .select1YearCommittedUsage()
                .openDropdownDatacenterLocation()
                .waitForDropdownLoading()
                .selectFrankfurtDatacenterLocation()
                .clickButtonAddToEstimate()
        ;
        actions_between_windows
                .openNewWindow()
                ;
        email_page
                .maximizeWindow()
                .openEmailGeneratePage()
                .copyEmail()
                ;
        actions_between_windows
                .goBackToPricingCalculatorTab()
                ;
        calculator_page
                .clickButtonEmailEstimateButton()
                .waitLoadingEmailForm()
                .pasteEmailGenerated()
                .clickButtonSendEmail()
                ;
        actions_between_windows
                .goBackToEmailGeneratedPage()
                ;
        email_page
                .checkEmailReceived()
                .waitEmailExpands()
                ;

        Assert.assertTrue(email_page.checkEstimatedCosts ().contains("1,082.77"),"Failed: Estimated Cost doesn't match!");

            }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}
