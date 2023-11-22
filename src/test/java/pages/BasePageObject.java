package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;
import java.util.List;


public class BasePageObject {

    protected WebDriver driver;
    protected static Logger log = LogManager.getLogger();

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }


    protected void openUrl(String url) {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }

    /**
     * Find element using given locator
     */
    protected WebElement find(By locator) {
        return this.driver.findElement(locator);
    }


    protected List<WebElement> findAll(By locator) {
        return this.driver.findElements(locator);
    }

    /**
     * Click on element with given locator when its visible
     */
    protected void click(By locator) {
        this.waitForVisibilityOf(locator, Duration.ofSeconds(5));
        this.find(locator).click();
    }


    /**
     * Type given text into element with given locator
     */
    protected void type(String text, By locator) {
        this.waitForVisibilityOf(locator, Duration.ofSeconds(5));
        this.find(locator).sendKeys(new CharSequence[]{text});
    }


    /**
     * Get URL of current page from browser
     */
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }


    /**
     * Get title of current page
     */
    public String getCurrentPageTitle() {
        return this.driver.getTitle();
    }

    /**
     * Get source of current page
     */
    public String getCurrentPageSource() {
        return this.driver.getPageSource();
    }

    /**
     * Wait for specific ExpectedConditon for the given Duration
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
        timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(this.driver, timeOut);
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Duration... timeOut) {
        int attempts = 0;

        while (attempts < 2) {
            try {
                this.waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOut.length > 0 ? timeOut[0] : null);
                break;
            } catch (StaleElementReferenceException var5) {
                ++attempts;
            }
        }

    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException var4) {
            var4.printStackTrace();

        }
    }

    //Clicks the element - been used when Selenium does not work correctly - like ticks, etc.
    static public void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }


}
//
//    static public void jsClick(WebDriver driver, WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()", element);
//    }
    /** This method select given option from dropdown */

//    public void SelectOption(int i) {
//          log.info("Selecting option " + i + " from dropdown");
//          Select dropdown = new Select(dropdownElement);
//           dropdown.selectByValue("" + i);
//           //dropdown.selectByVisibleText("Option " + i);
//           //dropdown.selectByIndex(i);

//
//    protected Alert switchToAlert() {
//        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
//        wait.until(ExpectedConditions.alertIsPresent());
//        return this.driver.switchTo().alert();
//    }
//
//    public void switchToWindowWithTitle(String expectedTitle) {
//        String firstWindow = this.driver.getWindowHandle();
//        Set<String> allWindows = this.driver.getWindowHandles();
//        Iterator<String> windowsIterator = allWindows.iterator();
//
//        while(windowsIterator.hasNext()) {
//            String windowHandle = ((String)windowsIterator.next()).toString();
//            if (!windowHandle.equals(firstWindow)) {
//                this.driver.switchTo().window(windowHandle);
//                if (this.getCurrentPageTitle().equals(expectedTitle)) {
//                    break;
//                }
//            }
//        }
//
//    }
//
//    protected void switchToFrame(By frameLocator) {
//        this.driver.switchTo().frame(this.find(frameLocator));
//    }
//
//    protected void pressKey(By locator, Keys key) {
//        this.find(locator).sendKeys(new CharSequence[]{key});
//    }
//
//    public void pressKeyWithActions(Keys key) {
//        this.log.info("Pressing " + key.name() + " using Actions class");
//        Actions action = new Actions(this.driver);
//        action.sendKeys(new CharSequence[]{key}).build().perform();
//    }
//
//    public void scrollToBottom() {
//        this.log.info("Scrolling to the bottom of the page");
//        JavascriptExecutor jsExecutor = (JavascriptExecutor)this.driver;
//        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)", new Object[0]);
//    }
//
//    protected void performDragAndDrop(By from, By to) {
//        JavascriptExecutor jsExecutor = (JavascriptExecutor)this.driver;
//        jsExecutor.executeScript("function createEvent(typeOfEvent) {\nvar event =document.createEvent(\"CustomEvent\");\nevent.initCustomEvent(typeOfEvent,true, true, null);\nevent.dataTransfer = {\ndata: {},\nsetData: function (key, value) {\nthis.data[key] = value;\n},\ngetData: function (key) {\nreturn this.data[key];\n}\n};\nreturn event;\n}\n\nfunction dispatchEvent(element, event,transferData) {\nif (transferData !== undefined) {\nevent.dataTransfer = transferData;\n}\nif (element.dispatchEvent) {\nelement.dispatchEvent(event);\n} else if (element.fireEvent) {\nelement.fireEvent(\"on\" + event.type, event);\n}\n}\n\nfunction simulateHTML5DragAndDrop(element, destination) {\nvar dragStartEvent =createEvent('dragstart');\ndispatchEvent(element, dragStartEvent);\nvar dropEvent = createEvent('drop');\ndispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\nvar dragEndEvent = createEvent('dragend');\ndispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n}\n\nvar source = arguments[0];\nvar destination = arguments[1];\nsimulateHTML5DragAndDrop(source,destination);", new Object[]{this.find(from), this.find(to)});
//    }
//}

