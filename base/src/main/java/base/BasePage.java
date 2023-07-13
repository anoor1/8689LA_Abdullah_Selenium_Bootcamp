package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import config.BaseConfig;
import listeners.DriverEventListener;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.Database;
import utils.ExcelData;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.*;

public class BasePage {

    public static ExcelData excel;
    public static Database db;
    public static WebDriver driver;
    Map<Object, String> dbConfig = BaseConfig.databaseConfig();
    public static final String DATA_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
            + "test" + File.separator + "resources" + File.separator + "test_data.xlsx";
    public static WebDriverWait webDriverWait;
    public static Wait<WebDriver> fluentWait;
    public static ExtentReports extent;
    public static JavascriptExecutor jsDriver;

    public BasePage() {
        dataInit();
        databaseInit();
    }

    @BeforeClass
    public void databaseInit() {
        String host = dbConfig.get(BaseConfig.DBProperties.HOST);
        String user = dbConfig.get(BaseConfig.DBProperties.USER);
        String password = dbConfig.get(BaseConfig.DBProperties.PASSWORD);
        String className = dbConfig.get(BaseConfig.DBProperties.DRIVER_CLASS);

        db = new Database(host, user, password, className);
    }

    @BeforeClass
    public void dataInit() {
        excel = new ExcelData(DATA_PATH);
    }

    // region Hooks
    @BeforeSuite(alwaysRun = true)
    public void reportSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void reportInit(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();

        ExtentTestManager.startTest(methodName);
        ExtentTestManager.getTest().assignCategory(className);
    }

    @Parameters({"driverConfigEnabled", "browser", "url"})
    @BeforeMethod

    public void driverSetup(@Optional("true") String driverConfigEnabled, @Optional("chrome") String browser, @Optional("https://booking.com") String url) {

        if (Boolean.parseBoolean(driverConfigEnabled)) {
            driverInit(browser);
            driver.get(url);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }

    @Parameters({"driverConfigEnabled"})
    @AfterMethod
    public void cleanUp(@Optional("true") String driverConfigEnabled) {
        if (Boolean.parseBoolean(driverConfigEnabled)) {
            driver.close();
            driver.quit();
        }
    }

    @Parameters({"driverConfigEnabled"})
    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult testResult, @Optional("true") String driverConfigEnabled) {
        ExtentTest test = ExtentTestManager.getTest();
        String testName = testResult.getName();
        int testStatus = testResult.getStatus();

        test.getTest().setStartedTime(getTime(testResult.getStartMillis()));
        test.getTest().setEndedTime(getTime(testResult.getEndMillis()));

        for (String group : testResult.getMethod().getGroups()) {
            test.assignCategory(group);
        }
        if (testStatus == ITestResult.FAILURE) {
            if (Boolean.parseBoolean(driverConfigEnabled)) {
                captureScreenshot(driver, testName);
            }
            test.log(LogStatus.FAIL, "TEST CASE FAILED: " + testName);
            test.log(LogStatus.FAIL, testResult.getThrowable());

        } else if (testStatus == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "TEST CASE SKIPPED: " + testName);
        } else if (testStatus == ITestResult.SUCCESS) {
            test.log(LogStatus.PASS, "TEST CASE PASSED: " + testName);
        }

        ExtentTestManager.endTest();
        extent.flush();
    }

    // endregion

    // region Selenium API
    public WebElement getVisibleElement(By by) {

        WebElement element;

        element = driver.findElement(by);

        try {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e2) {
            element = driver.findElement(by);
        }
        return element;
    }

    public WebElement getVisibleElement(WebElement element) {


        try {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e2) {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
        }
        return element;
    }
    public WebElement getClickableElement(By by) {
        WebElement element;

        element = driver.findElement(by);

        try {
            fluentWait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        } catch (StaleElementReferenceException e2) {
            element = driver.findElement(by);
        }
        return element;
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).perform();
    }

    public void clickAndHitEnter(WebElement element,String data) {
        Actions actions = new Actions(driver);

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).click(element).sendKeys(data).sendKeys(Keys.ENTER).build().perform();
    }

    public String getTrimmedElementText(WebElement element) {
        String text = "";
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        text = element.getText().trim();

        if (text.equals("")) {
            text = element.getAttribute("innerHTML").trim();
        }

        return text;
    }

    public void clickOnElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void clearSendKeysToElement(WebElement element, String keys) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(keys);
    }

    public void selectFromDropdownByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectFromDropdownByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectFromDropdownByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            fluentWait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void switchToParentFrame() {
        driver.switchTo().defaultContent();
    }

    public void switchToFrameByElement(WebElement frame) {

        webDriverWait.until(ExpectedConditions.visibilityOf(frame));
        driver.switchTo().frame(frame);
    }

    public void switchToTab() {
        String parentHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
            }
        }
    }

    // region JavaScriptExecutor Methods
    // TODO - Unit test and refactor as needed
    public String jsGetTrimmedElementText(WebElement element) {
        jsDriver = (JavascriptExecutor) (driver);
        String query = "arguments[0].getPropertyValue('innerHTML');";

        return jsDriver.executeScript(query, element).toString();
    }

    // TODO - Unit test and refactor as needed
    public WebElement findElementByXPathJS(String xPath) {
        jsDriver = (JavascriptExecutor) (driver);
        String query = String.format("document.getElement(By.xpath(\"%s\")", xPath);
        return (WebElement) (jsDriver.executeScript(query));
    }

    public void jsClickOnElement(WebElement element) {
        jsDriver = (JavascriptExecutor) (driver);
        jsDriver.executeScript("arguments[0].click();", element);
    }

    public void safeClickOnElement(WebElement element) {
        try {
            clickOnElement(element);
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            System.out.println("Unable to click element - trying again with javascript click");
            jsClickOnElement(element);
        } catch (TimeoutException e) {
            System.out.println("Unable to locate element - trying again with javascript click");
            jsClickOnElement(element);
        }
    }

    public WebElement setElementAttributeValue(String attribute, String value, By by) {
        jsDriver = (JavascriptExecutor) (driver);
        jsDriver.executeScript("arguments[0].setAttribute('" + attribute + "', '" + value + "')", driver.findElement(by));

        return driver.findElement(by);
    }

    // endregion

    // endregion

    // region Helper Methods
    private static void driverInit(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        // Register Event Listener
        DriverEventListener listener = new DriverEventListener();
        EventFiringDecorator<WebDriver> eventDecorator = new EventFiringDecorator<>(listener);
        driver = eventDecorator.decorate(driver);

    }

    private static void captureScreenshot(WebDriver driver, String testName) {
        String absPath = System.getProperty("user.dir");
        String screenshotFileName = "screenshot_" + testName + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File(absPath + File.separator + "src" + File.separator + "test"
                + File.separator + "reports" + File.separator + screenshotFileName);

        try {
            FileHandler.copy(screenshot, screenshotFile);
            System.out.println("SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING SCREENSHOT: " + e.getMessage());
        }
    }

    private static void captureFullScreenshot(WebDriver driver, String testName) {
        String absPath = System.getProperty("user.dir");
        String fullScreenshotFileName = "full_screenshot_" + testName + ".png";

        File fullScreenshot = ((ChromeDriver) driver).getScreenshotAs(OutputType.FILE);
        File fullScreenshotFile = new File(absPath + File.separator + "src" + File.separator + "test"
                + File.separator + "reports" + File.separator + fullScreenshotFileName);

        try {
            FileHandler.copy(fullScreenshot, fullScreenshotFile);
            System.out.println("FULL SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING FULL SCREENSHOT: " + e.getMessage());
        }
    }

    private static Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }


    protected static boolean checkElementPresent(WebElement element)
    {

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        boolean flag=element.isDisplayed();
        return flag;

    }

    // endregion

    public void clickOnByTabKey()
    {
        Actions action=new Actions(driver);
        action.sendKeys(Keys.ESCAPE).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();;

    }

    public void enterAndHitEnterKeyword(WebElement element,String data) {
        Actions action=new Actions(driver);
        action.click(element).sendKeys(data).sendKeys(Keys.ENTER).build().perform();
    }


    protected static boolean checkElementSelected(WebElement element)
    {

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        boolean flag=element.isSelected();
        return flag;

    }
}