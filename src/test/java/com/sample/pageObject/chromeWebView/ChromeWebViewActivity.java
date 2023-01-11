package com.sample.pageObject.chromeWebView;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ChromeWebViewActivity {

    AppiumDriver driver;

    public ChromeWebViewActivity(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "tableHeader")
    AndroidElement txt_webViewInteraction;

    @AndroidFindBy(id = "webviewLocation")
    AndroidElement txt_webViewLocation;

    @AndroidFindBy(id = "spinner_webdriver_test_data")
    AndroidElement spnr_webDriverTestData;

    @AndroidFindBy(id = "text1")
    AndroidElement txt_spnrText;

    @AndroidFindBy(id = "goBack")
    AndroidElement btn_goToHomeScreen;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.widget.TextView")
    AndroidElement hdg_webViewHeading;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='name_input']")
    AndroidElement edtxt_enterYourName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Prefered Car:']")
    AndroidElement txt_preferredCar;

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View/android.view.View/android.view.View")
    AndroidElement view_dropDown;

    @AndroidFindBy(id = "android:id/text1")
    List<AndroidElement> lst_carOptions;

    @AndroidFindBy(className = "android.widget.Button")
    AndroidElement btn_SendYourName;
}
