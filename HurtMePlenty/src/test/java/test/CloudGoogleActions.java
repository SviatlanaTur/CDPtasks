package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.CloudGoogleHomePage;
import page.PricingCalculatorPage;
import page.SearchResultsPage;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.SearchResultsPage;
import org.testng.Assert;

public class CloudGoogleActions {
    private CloudGoogleHomePage homepage;
    private SearchResultsPage search_results_page;
    private PricingCalculatorPage calculator_page;

    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        homepage = new CloudGoogleHomePage(driver);
        search_results_page = new SearchResultsPage(driver);
        calculator_page = new PricingCalculatorPage(driver);
    }

    @Test(description = "to test Google Cloud Platform Pricing Calculator")
    public void PastbinAction() {

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
                .ClickOnComputeEngineTab ()
                .enterNumberOfInstances ("4")
                .openDropdownSelectSeries ()
                .waitForDropdownLoading()
                .selectN1SelectSeries ()
                .openDropdownMachineType ()
                .waitForDropdownLoading()
                .selectN1StandardOption ()
                .checkAddGPUs()
                .openDropdownNumberOfGPUs ()
                .waitForDropdownLoading()
                .select1NumberOfGPUs ()
                .openDropdownGPUType ()
                .waitForDropdownLoading()
                .selectTesla100GPUType ()
                .openDropdownLocalSSD ()
                .waitForDropdownLoading()
                .select2x375LocalSSD ()
                .openDropdownCommittedUsage ()
                .waitForDropdownLoading()
                .select1YearCommittedUsage ()
                .openDropdownDatacenterLocation ()
                .waitForDropdownLoading()
                .selectFrankfurtDatacenterLocation ()
                .clickButtonAddToEstimate ()
                ;

                Assert.assertTrue(calculator_page.checkEstimatedVMClassMatchesRegular().contains("regular"),"Failed: VM class doesn't match!");
                Assert.assertTrue(calculator_page.checkEstimatedInstanceTypeMatchesN1Standard().contains("n1-standard-8"),"Failed: Instance type doesn't match!");
                Assert.assertTrue(calculator_page.checkEstimatedRegionMatchesFrankfurt().contains("Frankfurt"),"Failed: Region doesn't match!");
                Assert.assertTrue(calculator_page.checkEstimatedLocalSSDMatches2x375().contains("2x375 GiB"),"Failed: Local SSD doesn't match!");
                Assert.assertTrue(calculator_page.checkEstimatedCommitmentTermMatches1Year().contains("1 Year"),"Failed: Commitment term doesn't match!");
                Assert.assertTrue(calculator_page.checkEstimatedCostManualResult().contains("1,082.77"),"Failed: Estimated Cost doesn't match!");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}
