package com.sample.pageObject.homePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class HomePageActivity {

    AppiumDriver driver;
    public HomePageActivity(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'permissions_message')]")
    AndroidElement text_permissionMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'continue_button')]")
    AndroidElement btn_continue;

    @AndroidFindBy(id = "android:id/alertTitle")
    AndroidElement alertTxt_dialogueHeading;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    AndroidElement alertBtn_ok;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Close app']")
    AndroidElement alertBtn_closeApp;

    @AndroidFindBy(id = "android:id/title")
    AndroidElement hdg_appTitle;

    @AndroidFindBy(accessibility = "l10nCD")
    AndroidElement txt_localizationLocator;

    @AndroidFindBy(accessibility = "buttonTestCD")
    AndroidElement btn_ENButton;

    @AndroidFindBy(id = "android:id/message")
    AndroidElement alertTxt_dialogueMessage;

    @AndroidFindBy(id = "android:id/button1")
    AndroidElement alertBtn_IAgree;

    @AndroidFindBy(id = "android:id/button2")
    AndroidElement btn_no;

    @AndroidFindBy(id = "buttonStartWebview")
    AndroidElement btn_startWebView;

    @AndroidFindBy(id = "startUserRegistration")
    AndroidElement btn_startUserRegistration;

    @AndroidFindBy(accessibility = "my_text_fieldCD")
    AndroidElement edtxt_my_textField;

    @AndroidFindBy(id = "waitingButtonTest")
    AndroidElement btn_showProgressBar;

    @AndroidFindBy(id = "input_adds_check_box")
    AndroidElement chbx_acceptAdds;

    @AndroidFindBy(id = "visibleButtonTest")
    AndroidElement btn_displayText;

    @AndroidFindBy(id = "visibleTextView")
    AndroidElement txt_visibleTextDisplayed;

    @AndroidFindBy(id = "showToastButton")
    AndroidElement btn_displayToast;

    WebElement txt_toastMsg(){
        return driver.findElement(By.xpath("//android.widget.Toast[1]"));
    }

    @AndroidFindBy(id = "showPopupWindowButton")
    AndroidElement btn_displayPopup;

    @AndroidFindBy(id = "exceptionTestButton")
    AndroidElement btn_throwException;

    @AndroidFindBy(id = "exceptionTestField")
    AndroidElement edtxt_exceptionTextField;

    @AndroidFindBy(id = "topLevelElementTest")
    AndroidElement btn_displayLayout;

    @AndroidFindBy(id = "touchTest")
    AndroidElement btn_touchActions;
}
