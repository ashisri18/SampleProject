package com.sample.pageObject.registration;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.sample.pageObject.homePage.HomePageAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import util.ElementUtil;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class RegistrationAction {

    AppiumDriver driver;
    HomePageAction homePageAction;
    RegistrationActivity registrationActivity;
    ElementUtil elementUtil;
    Random random;
    private static Logger LOGGER;
    private CSVReader csvReader;
    String[] csvCell;

    String CSVPath;
    String username;
    String email;
    String password;
    String name;

    public RegistrationAction(AppiumDriver driver){
        this.driver = driver;
        homePageAction = new HomePageAction(driver);
        registrationActivity = new RegistrationActivity(driver);
        elementUtil = new ElementUtil(driver);
        LOGGER = LogManager.getLogger(RegistrationAction.class);
        random = new Random();
        CSVPath = "src/test/resources/TestData.csv";
    }

    public void fillRegistrationForm(){
        try {
            csvReader = new CSVReader(new FileReader(CSVPath));
            while((csvCell = csvReader.readNext()) != null) {
                username = csvCell[0];
                email = csvCell[1];
                password = csvCell[2];
                name = csvCell[3];
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        homePageAction.navigateToUserRegistration();
        Assert.assertTrue(elementUtil.isElementDisplay(registrationActivity.txt_welcomeToRegister, "RegistrationPage"), "Registration Page NOT validated");
        elementUtil.sendkeys(registrationActivity.edtxt_username, "Enter Username", username);
        elementUtil.sendkeys(registrationActivity.edtxt_email, "Enter Email", email);
        elementUtil.sendkeys(registrationActivity.edtxt_password,"Enter Password", password);
        elementUtil.clearAndType(registrationActivity.edtxt_name, "Enter Name", name);
        driver.hideKeyboard();
        elementUtil.click(registrationActivity.spnr_programmingLanguage, "Programming Language DropDown");
        List<AndroidElement> lst_languageOptions = registrationActivity.txt_programmingLanguageOptions;
        AndroidElement language = lst_languageOptions.get(random.nextInt(lst_languageOptions.size()));
        elementUtil.click(language, language.getText());
        elementUtil.click(registrationActivity.chbx_acceptAdds, "Accept Adds");
        elementUtil.click(registrationActivity.btn_registerUser, "Register User Btn");
        elementUtil.click(registrationActivity.btn_verifyRegisterUser, "Verify Register User");
    }
}
