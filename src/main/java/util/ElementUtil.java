package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ElementUtil {

    private AppiumDriver driver;
    private int defaultTimeout;
    private static Logger LOGGER;

    public ElementUtil(AppiumDriver driver) {
        this.driver = driver;
        defaultTimeout = 5;    // Equal to default implicit wait given in DriverSetup class
        LOGGER = LogManager.getLogger(ElementUtil.class);
    }

    /* Adding this method to change default implicit wait for any particular case */
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void setDefaultImplicitWait() {
        setImplicitWait(defaultTimeout);
    }

    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException ignored) {
        }
    }

    public boolean isElementDisplay(MobileElement element, String elementName) {
        return isElementDisplay(element, elementName, defaultTimeout);
    }

    public boolean isElementDisplay(MobileElement element, String elementName, final int timeout) {
        boolean status = false;
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, timeout);
            driverWait.until(ExpectedConditions.visibilityOf(element));
            status = true;
            LOGGER.info("Element [" + elementName + "] is displayed in Screen");
        } catch (Exception e) {
            LOGGER.error("Element [" + elementName + "] is NOT displayed in Current Screen");
        }
        setDefaultImplicitWait();
        return status;
    }

    public void click(MobileElement element, String elementName) {
        try {
            element.click();
            LOGGER.info("Clicked On Element.. " + elementName);
        } catch (NoSuchElementException e) {
            LOGGER.error("Unable To Click on Element... " + elementName, e.getLocalizedMessage());
            throw e;
        }
    }

    public void sendkeys(MobileElement element, String elementName, String value) {
        try {
            element.sendKeys(value);
            LOGGER.info("Entered Value [" + value + "] in " + elementName);
        } catch (Exception e) {
            LOGGER.error("Unable to Type Value [" + value + "] in " + elementName, e.getLocalizedMessage());
            throw e;
        }
    }

    /**
     * @description Method to clear and type text in TextBox
     */
    public void clearAndType(MobileElement element, String name, String value) {
        try {
            element.clear();
            element.sendKeys(value);
            LOGGER.info("Cleared And Entered Value [" + value + "] in " + name);
        } catch (Exception e) {
            LOGGER.error("Unable to Clear and Type Value [" + value + "] in " + name, e.getLocalizedMessage());
            throw e;
        }
    }

    public String getText(MobileElement element) {
        String text;
        text = element.getText().trim();
        return text;
    }
}
