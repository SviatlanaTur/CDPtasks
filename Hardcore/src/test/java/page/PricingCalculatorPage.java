package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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


    @FindBy(css = "button[aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//button[@id = 'email_quote']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@id ='input_476']")
    private WebElement enterEmail;

    @FindBy(xpath = "//button[@aria-label = 'Send Email']")
    private WebElement buttonSendEmail;

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

    public PricingCalculatorPage scrollDownToN1StandardOption() {
        Actions actions = new Actions(driver);
        actions.moveToElement(optionN1Standard);
        actions.perform();
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

    public PricingCalculatorPage scrollDownToButtonAddToEstimate() {
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonAddToEstimate);
        actions.perform();
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

    public PricingCalculatorPage clickButtonEmailEstimateButton() {
        buttonEmailEstimate.click();
        return this;
    }

    public PricingCalculatorPage waitLoadingEmailForm() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("input_476")));
        return this;
    }

    public PricingCalculatorPage pasteEmailGenerated() throws IOException, UnsupportedFlavorException {
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        driver.findElement(By.xpath("//input[@id ='input_476']")).sendKeys(myText);
        return this;
    }

    public PricingCalculatorPage clickButtonSendEmail() {
        buttonSendEmail.click();
        return this;
    }

}


