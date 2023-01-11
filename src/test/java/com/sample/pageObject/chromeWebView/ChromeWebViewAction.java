package com.sample.pageObject.chromeWebView;

import com.sample.pageObject.homePage.HomePageAction;
import com.sample.pageObject.registration.RegistrationAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import util.ElementUtil;

import java.util.List;
import java.util.Random;

public class ChromeWebViewAction {

    AppiumDriver driver;
    HomePageAction homePageAction;
    ChromeWebViewActivity chromeWebViewActivity;
    ElementUtil elementUtil;
    Random random;
    private static Logger LOGGER;

    public ChromeWebViewAction(AppiumDriver driver) {
        this.driver = driver;
        homePageAction = new HomePageAction(driver);
        chromeWebViewActivity = new ChromeWebViewActivity(driver);
        elementUtil = new ElementUtil(driver);
        LOGGER = LogManager.getLogger(RegistrationAction.class);
        random = new Random();
    }

    public void fillWebViewForm(){
        homePageAction.navigateToWebView();
        Assert.assertTrue(elementUtil.isElementDisplay(chromeWebViewActivity.txt_webViewInteraction, "WebView Page"), "WebView Page NOT validated");
        Assert.assertTrue(elementUtil.isElementDisplay(chromeWebViewActivity.txt_webViewLocation, "WebView Location text"), "WebView Location text NOT validated");
        Assert.assertEquals(elementUtil.getText(chromeWebViewActivity.hdg_webViewHeading), "Hello, can you please tell me your name?", "WebView Heading NOT validated");
        elementUtil.clearAndType(chromeWebViewActivity.edtxt_enterYourName, "Enter Name", "Ashish Srivastava");
        elementUtil.click(chromeWebViewActivity.view_dropDown, "Drop Down");
        List<AndroidElement> lst_carOptions = chromeWebViewActivity.lst_carOptions;
        AndroidElement selectedCar = lst_carOptions.get(random.nextInt(lst_carOptions.size()));
        elementUtil.click(selectedCar, selectedCar.getText());
        elementUtil.click(chromeWebViewActivity.btn_SendYourName, "Send you name");
    }
}
