package com.sample.pageObject.homePage;

import com.sample.pageObject.registration.RegistrationActivity;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import util.ElementUtil;

public class HomePageAction {

    AppiumDriver driver;
    HomePageActivity homePageActivity;
    RegistrationActivity registrationActivity;
    ElementUtil elementUtil;
    private static Logger LOGGER;

    private final String TEXT_APP_TITLE = "selendroid-test-app";
    private final String TEXT_EN_BUTTON = "EN Button";
    private final String TEXT_PROGRESS_BAR = "Show Progress Bar for a while";
    private final String TEXT_DISPLAY_TEXT = "Display text view";
    private final String TEXT_DISPLAY_TOAST = "Displays a Toast";
    private final String TEXT_DISPLAY_POPUP = "Display Popup Window";
    private final String TEXT_PRESS_TO_THROW_EXCEPTION = "Press to throw unhandled exception";
    private final String TEXT_DISPLAY_FOCUS_LAYOUT = "Display and focus on layout";
    private final String TEXT_TOUCH_ACTION = "Touch Actions";

    public HomePageAction(AppiumDriver driver){
        this.driver = driver;
        homePageActivity = new HomePageActivity(driver);
        registrationActivity = new RegistrationActivity(driver);
        elementUtil = new ElementUtil(driver);
        LOGGER = LogManager.getLogger(HomePageAction.class);
    }

    public void handlePermissionAndWarning(){
        if (elementUtil.isElementDisplay(homePageActivity.text_permissionMessage, "Permission Message")){
            elementUtil.click(homePageActivity.btn_continue, "Continue Button");
            elementUtil.click(homePageActivity.alertBtn_ok, "Accept Warning");
            LOGGER.info("Permission accepted for selendroid-test-app");
        } else if (elementUtil.isElementDisplay(homePageActivity.alertTxt_dialogueHeading, "Launch Warning")){
            elementUtil.click(homePageActivity.alertBtn_ok, "Accept Warning");
            LOGGER.info("Warning accepted for selendroid-test-app");
        }
    }

    public void navigateToWebView(){
        elementUtil.click(homePageActivity.btn_startWebView, "Web View Tab");
        LOGGER.info("Navigating to Web View Page");
    }

    public void navigateToUserRegistration(){
        elementUtil.click(homePageActivity.btn_startUserRegistration, "User Registration Tab");
        LOGGER.info("Navigating to User Registration Page");
    }

    public void verifyHomeScreenElements(){
        Assert.assertEquals(elementUtil.getText(homePageActivity.hdg_appTitle), TEXT_APP_TITLE, "App title NOT validated");
        Assert.assertTrue(elementUtil.isElementDisplay(homePageActivity.txt_localizationLocator, "Localization Locator"), "Localization Locator NOT found");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_ENButton), TEXT_EN_BUTTON, "EN Button text NOT validated");
        Assert.assertTrue(elementUtil.isElementDisplay(homePageActivity.btn_startWebView, "Web View Tab"), "web view tab NOT found");
        Assert.assertTrue(elementUtil.isElementDisplay(homePageActivity.btn_startUserRegistration, "User registration tab"), "User registration tab NOT found");
        Assert.assertTrue(elementUtil.isElementDisplay(homePageActivity.edtxt_my_textField, "text Field"), "Text Field NOT found");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_showProgressBar), TEXT_PROGRESS_BAR, "Progress bar text NOT validated");
        Assert.assertTrue(elementUtil.isElementDisplay(homePageActivity.chbx_acceptAdds, "Accept Adds Checkbox"), "Checkbox accept adds NOT found");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_displayText), TEXT_DISPLAY_TEXT, "Display Text NOT validated");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_displayToast), TEXT_DISPLAY_TOAST, "Display Toast text NOT validated");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_displayPopup), TEXT_DISPLAY_POPUP, "Display Popup text NOT validated");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_throwException), TEXT_PRESS_TO_THROW_EXCEPTION, "Press to throw exception text NOT validated");
        Assert.assertTrue(elementUtil.isElementDisplay(homePageActivity.edtxt_exceptionTextField, "Exception text field"), "Exception text field NOT found");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_displayLayout), TEXT_DISPLAY_FOCUS_LAYOUT, "Display focus layout text NOT validated");
        Assert.assertEquals(elementUtil.getText(homePageActivity.btn_touchActions), TEXT_TOUCH_ACTION, "Touch Action text NOT validated");
    }

    public void validateHomeScreenActions(){
        validateENButton();
        enterText("Hi, How are you?");
        showProgressBarForAWhile();
        displayTextView();
        displayToast();
//        displayPopupWindow();
        pressToThrowUnhandledException();
        typeToThrowUnhandledException();
    }

    public void validateENButton(){
        elementUtil.click(homePageActivity.btn_ENButton, "EN Button");
        Assert.assertEquals(elementUtil.getText(homePageActivity.alertTxt_dialogueMessage), "This will end the activity", "Dialogue box text NOT validated");
        elementUtil.click(homePageActivity.alertBtn_IAgree, "I Agree");          // Sending app in background
        LOGGER.info("App sent in background");
        elementUtil.staticWait(1000);
        driver.activateApp("io.selendroid.testapp");                //  re-launch the app
        elementUtil.staticWait(1000);
        LOGGER.info("App is in foreground");
    }

    public void enterText(String text){
        elementUtil.sendkeys(homePageActivity.edtxt_my_textField, "TextField", text);
        LOGGER.info(text+" - text entered successfully");
    }

    public void showProgressBarForAWhile(){
        elementUtil.click(homePageActivity.btn_showProgressBar, "Progress Bar Button");
        Assert.assertEquals(elementUtil.getText(homePageActivity.alertTxt_dialogueMessage), "Waiting Dialog", "Dialogue box text NOT validated");
        Assert.assertTrue(elementUtil.isElementDisplay(registrationActivity.txt_welcomeToRegister, "Registration Page", 12), "Registration Page NOT found");
        LOGGER.info("User Registration Page found after progress bar");
        driver.navigate().back();
        driver.navigate().back();
        LOGGER.info("Navigating back to Home Page");
    }

    public void displayTextView(){
        elementUtil.click(homePageActivity.btn_displayText, "DisplayTextView");
        Assert.assertTrue(elementUtil.isElementDisplay(homePageActivity.txt_visibleTextDisplayed, "Displayed Text"), "Display text NOT found");
        LOGGER.info("Text displayed successfully");
    }

    public void displayToast(){
        elementUtil.click(homePageActivity.btn_displayToast, "Display Toast");
        String toastMessage = homePageActivity.txt_toastMsg().getAttribute("name");
        LOGGER.info("Toast Message displayed - "+toastMessage);
    }

    // Element details NOT provide for "Popup window" element, so can dismiss that.
    public void displayPopupWindow(){
        elementUtil.click(homePageActivity.btn_displayPopup, "Display Popup");
    }

    public void pressToThrowUnhandledException(){
        elementUtil.click(homePageActivity.btn_throwException, "Press to Throw Exception");
        reactivateTheApp();
    }

    public void typeToThrowUnhandledException(){
        try{
            elementUtil.sendkeys(homePageActivity.edtxt_exceptionTextField, "Type to throw exception", "Hey");
        } catch (StaleElementReferenceException e) {
            reactivateTheApp();
        }
    }

    private void reactivateTheApp(){
        if (elementUtil.isElementDisplay(homePageActivity.alertTxt_dialogueHeading, "Exception Alert")) {
            Assert.assertEquals(elementUtil.getText(homePageActivity.alertTxt_dialogueHeading), "selendroid-test-app keeps stopping", "Dialogue box text NOT validated");
            elementUtil.click(homePageActivity.alertBtn_closeApp, "CloseApp");
        }
        LOGGER.info("App closed due to exception");
        elementUtil.staticWait(1000);
        driver.activateApp("io.selendroid.testapp");                  //  re-activate the app
        elementUtil.staticWait(1000);
        LOGGER.info("App is in foreground");
    }
}
