package com.sample.testScript;

import com.sample.pageObject.chromeWebView.ChromeWebViewAction;
import com.sample.pageObject.homePage.HomePageAction;
import com.sample.pageObject.registration.RegistrationAction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.DriverSetup;

public class Scripts extends DriverSetup {

    @BeforeClass
    public void handleWarning(){
        HomePageAction homePageAction = new HomePageAction(driver);
        homePageAction.handlePermissionAndWarning();
    }

    @Test(priority = 1, enabled = true)
    public void verifyAllElementsOnHomePage(){
        HomePageAction homePageAction = new HomePageAction(driver);
        homePageAction.verifyHomeScreenElements();
    }

    @Test(priority = 2, enabled = true)
    public void validateAllActionsOnHomePage(){
        HomePageAction homePageAction = new HomePageAction(driver);
        homePageAction.validateHomeScreenActions();
    }

    @Test(priority = 3, enabled = true)
    public void verifyAndFillWebViewPage(){
        ChromeWebViewAction chromeWebViewAction = new ChromeWebViewAction(driver);
        chromeWebViewAction.fillWebViewForm();
    }

    @Test(priority = 4, enabled = true)
    public void registerForNewUser(){
        RegistrationAction registrationAction = new RegistrationAction(driver);
        registrationAction.fillRegistrationForm();
    }
}
