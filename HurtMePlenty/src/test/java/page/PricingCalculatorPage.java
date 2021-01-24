package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage {

    private WebDriver driver;

    @FindBy(xpath = "//devsite-iframe/iframe")
    private WebElement iFrame1;

    @FindBy(id = "myFrame")
    private WebElement iFrame2;

    @FindBy(xpath = "//*[@class='md-tab ng-scope ng-isolate-scope md-ink-ripple md-active']")
    private WebElement ComputeEngineTab;

    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement NumberOfInstances;

    @FindBy(xpath = "//*[@name='series']")
    private WebElement dropdownSeries;

    @FindBy(xpath = "//div[1][@class='md-text ng-binding'][contains(.,'N1')]")
    private WebElement optionN1SelectSeries;

    @FindBy(css = "md-select[placeholder='Instance type']")
    private WebElement dropdownMachineType;

    @FindBy(xpath = "//*[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div")
    private WebElement optionN1Standard;

    @FindBy(css = "md-checkbox[aria-label='Add GPUs']>div")
    private WebElement checkboxAddGPUs;

    @FindBy(css = "md-select[placeholder='Number of GPUs']")
    private WebElement dropdownNumberOfGPUs;

    @FindBy(xpath = "//*[@id=\"select_option_399\"]/div[1]")
    private WebElement optionNumberOfGPUs1;

    @FindBy(css = "md-select[placeholder='GPU type']")
    private WebElement dropdownGPUType;

    @FindBy(xpath = "//*[@value='NVIDIA_TESLA_P100']/div[1]")
    private WebElement optionGPUType;

    @FindBy(css = "md-select[placeholder='Local SSD']")
    private WebElement dropdownLocalSSD;

    @FindBy(xpath = "//md-option[div[contains(., '2x375')]]")
    private WebElement optionLocalSSD;

    @FindBy(css = "md-select[placeholder='Committed usage']")
    private WebElement dropdownCommittedUsage;

    @FindBy(id = "select_option_97")
    private WebElement optionCommittedUsage;

    @FindBy(css = "md-select[placeholder='Datacenter location']")
    private WebElement dropdownDatacenterLocation;

    @FindBy(xpath = "//md-option[@id='select_option_205']")
    private WebElement optionDatacenterLocation;

   // xpath //md-option[div[contains(., 'Frankfurt (europe-west3)')]]

    @FindBy(css = "button[aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;




    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage waitLoadingIframe1() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//devsite-iframe/iframe")));
        return this;
    }

    public PricingCalculatorPage switchToiFrame1() {
        driver.switchTo().frame(iFrame1);
        return this;
    }

    public PricingCalculatorPage waitLoadingIframe2() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("myFrame")));
        return this;
    }


    public String getiFrame2url() {
       String iframe2url = driver.findElement(By.id("myFrame")).getAttribute("src");
        return iframe2url;
    }

    public PricingCalculatorPage switchToiFrame2() {
        driver.get(getiFrame2url());
        return this;
    }

    public PricingCalculatorPage waitForDropdownLoading() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='md-select-menu-container md-active md-clickable']")));
        return this;
    }

    public PricingCalculatorPage ClickOnComputeEngineTab () {
        ComputeEngineTab.click();
        return this;
    }

    public PricingCalculatorPage enterNumberOfInstances (String text) {
        NumberOfInstances.sendKeys(text);
        return this;
    }

    public PricingCalculatorPage openDropdownSelectSeries () {
        dropdownSeries.click();
        return this;
    }

    public PricingCalculatorPage selectN1SelectSeries () {
        optionN1SelectSeries.click();
        return this;
    }

    public PricingCalculatorPage openDropdownMachineType () {
        dropdownMachineType.click();
        return this;
    }

    public PricingCalculatorPage selectN1StandardOption () {
        optionN1Standard.click();
        return this;
    }

    public PricingCalculatorPage checkAddGPUs() {
        checkboxAddGPUs.click();
        return this;
    }

    public PricingCalculatorPage openDropdownNumberOfGPUs () {
        dropdownNumberOfGPUs.click();
        return this;
    }

    public PricingCalculatorPage select1NumberOfGPUs () {
        optionNumberOfGPUs1.click();
        return this;
    }

    public PricingCalculatorPage openDropdownGPUType () {
        dropdownGPUType.click();
        return this;
    }

    public PricingCalculatorPage selectTesla100GPUType () {
        optionGPUType.click();
        return this;
    }

    public PricingCalculatorPage openDropdownLocalSSD () {
        dropdownLocalSSD.click();
        return this;
    }

    public PricingCalculatorPage select2x375LocalSSD () {
        optionLocalSSD.click();
        return this;
    }


    public PricingCalculatorPage openDropdownCommittedUsage () {
        dropdownCommittedUsage.click();
        return this;
    }


    public PricingCalculatorPage select1YearCommittedUsage () {
        optionCommittedUsage.click();
        return this;
    }

    public PricingCalculatorPage openDropdownDatacenterLocation () {
        dropdownDatacenterLocation.click();
        return this;
    }

    public PricingCalculatorPage selectFrankfurtDatacenterLocation () {
        optionDatacenterLocation.click();
        return this;
    }

    public PricingCalculatorPage clickButtonAddToEstimate () {
        buttonAddToEstimate.click();
        return this;
    }

    public String checkEstimatedVMClassMatchesRegular () {
        String VMClassMatch = driver.findElement(By.xpath("//*[@id=\"compute\"]/md-list/md-list-item[2]")).getText();
        return VMClassMatch;
    }

    public String checkEstimatedInstanceTypeMatchesN1Standard () {
        String N1StandardInstanceTypeMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., '\n" +
                "            Instance type: n1-standard-8\n" +
                "          ')]")).getText();
        System.out.println(N1StandardInstanceTypeMatch);
        return N1StandardInstanceTypeMatch;

    }

    public String checkEstimatedRegionMatchesFrankfurt () {
        String FrankfurtRegionTypeMatch = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., 'Region: Frankfurt')]")).getText();
        return FrankfurtRegionTypeMatch;
    }

    public String checkEstimatedLocalSSDMatches2x375 () {
        String LocalSSDMatches2x375 = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., 'Total available local SSD space 2x375 GiB')]")).getText();
        return LocalSSDMatches2x375;
    }

    public String checkEstimatedCommitmentTermMatches1Year () {
        String CommitmentTermMatches1Year = driver.findElement(By.xpath("//div[@class='md-list-item-text ng-binding'][contains(., 'Commitment term: 1 Year')]")).getText();
        return CommitmentTermMatches1Year;
    }

    public String checkEstimatedCostManualResult () {
        String EstimatedCostMatch = driver.findElement(By.xpath("//*[@id='resultBlock']")).getText();
        return EstimatedCostMatch;
    }

}
