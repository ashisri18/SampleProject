package com.sample.pageObject.registration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationActivity {

    AppiumDriver driver;

    public RegistrationActivity(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome to register a new User']")
    public AndroidElement txt_welcomeToRegister;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Username']")
    AndroidElement txt_username;

    @AndroidFindBy(id = "inputUsername")
    AndroidElement edtxt_username;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='E-Mail']")
    AndroidElement txt_email;

    @AndroidFindBy(accessibility = "email of the customer")
    AndroidElement edtxt_email;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Password']")
    AndroidElement txt_password;

    @AndroidFindBy(id = "inputPassword")
    AndroidElement edtxt_password;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Name']")
    AndroidElement txt_name;

    @AndroidFindBy(id = "inputName")
    AndroidElement edtxt_name;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Programming Languge']")
    AndroidElement txt_programmingLanguage;

    @AndroidFindBy(id = "input_preferedProgrammingLanguage")
    AndroidElement spnr_programmingLanguage;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[contains(@resource-id,'text1')]")
    List<AndroidElement> txt_programmingLanguageOptions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TandC']")
    AndroidElement txt_tAndC;

    @AndroidFindBy(id = "input_adds")
    AndroidElement chbx_acceptAdds;

    @AndroidFindBy(id = "btnRegisterUser")
    AndroidElement btn_registerUser;

    @AndroidFindBy(id = "buttonRegisterUser")
    AndroidElement btn_verifyRegisterUser;
}
