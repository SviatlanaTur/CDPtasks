package page;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;



public class ActionsBetweenWindows {

    private WebDriver driver;

    public ActionsBetweenWindows(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // public ActionsBetweenWindows switchBetweenTabs() {

  //      ((JavascriptExecutor)driver).executeScript("window.open()");
   //    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
   //     driver.switchTo().window(tabs.get(1));
   //     return this;

 //   }

   // public AdditionalActionsPage ReturnToBaseTab() {
   //     ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
  //      driver.switchTo().window(tabs.get(0));
   //     return this;
   // }

  //  public AdditionalActionsPage GoToNewTab() {
   //     ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
   //     driver.switchTo().window(tabs.get(1));
   //     return this;
  //  }

    public ActionsBetweenWindows openNewWindow() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public ActionsBetweenWindows goBackToPricingCalculatorTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    public ActionsBetweenWindows goBackToEmailGeneratedPage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

}
