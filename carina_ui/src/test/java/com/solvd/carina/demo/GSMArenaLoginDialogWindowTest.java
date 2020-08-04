package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.locators.HomePageLocators;
import com.solvd.carina.demo.locators.LoginPageLocators;
import org.apache.commons.math3.geometry.Space;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import static com.solvd.carina.demo.TestDataset.*;
import static com.solvd.carina.demo.locators.HomePageLocators.LoginForm.EMAIL_INPUT;
import static com.solvd.carina.demo.locators.HomePageLocators.LoginForm.PASSWORD_INPUT;

public class GSMArenaLoginDialogWindowTest extends AbstractTest {
    private final WebDriver driver = getDriver();
    private static DriverHelper driverHelper;

    private static final Logger LOGGER = Logger.getLogger(GSMArenaHomePageTest.class);

    @BeforeTest
    public void initializeDriverHelper() {
        LOGGER.info("Will initialize driver helper.");
        driverHelper = new DriverHelper(driver);
        LOGGER.info("Driver helper was initialized.");
    }

    @BeforeMethod
    public void openHomePage() {
        getDriver().get(Configuration.get(Configuration.Parameter.URL));
        ExtendedWebElement logo = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGO);
        Assert.assertTrue(logo.isElementPresent(), "Home page was not opened!");
    }

    @Test
    public void testLoginFormIsOpened() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        SoftAssert softAssert = new SoftAssert();
        LOGIN_FORM_ELEMENTS.forEach(locator ->
                softAssert.assertNotNull(
                        driverHelper.findExtendedWebElement(locator),
                        String.format("It is not found on the login form.", locator.toString()
                        )
                )
        );
        softAssert.assertAll();
    }

    @Test(description = "login - valid, password - valid")
    public void testUserLoginPass() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT), "Login form was not opened!");

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.EMAIL_INPUT).type(VALID_LOGIN);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(VALID_PASSWORD);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        String actualPassMessage =
                driverHelper.findExtendedWebElement(LoginPageLocators.LoginPassScreen.LOGIN_PASS_MESSAGE).getText(); // [ERROR] FAIL: element 'By.xpath: //h3[text()='Login successful.']' is not found!
        Assert.assertEquals(actualPassMessage, LOGIN_PASS_MESSAGE_EXPECTED,
                "Login success message is not as expected!");
        String actualPassDescription =
                driverHelper.findExtendedWebElement(LoginPageLocators.LoginPassScreen.LOGIN_PASS_DESCRIPTION).getText();
        Assert.assertEquals(actualPassDescription, LOGIN_PASS_DESCRIPTION_EXPECTED,
                "Login fault description is not as expected!");
    }

    @Test(description = "login - invalid e-mail format, password - valid")
    public void testInvalidLogin() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(INVALID_LOGIN);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(VALID_PASSWORD);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        ExtendedWebElement warningMessage = driverHelper.findExtendedWebElement(EMAIL_INPUT);
        Assert.assertEquals(warningMessage.getAttribute("validationMessage"), TestDataset.invalidLoginMessage(INVALID_LOGIN.toString()),
                "Warning message is not as expected!");
    }

    @Test(description = "login - incomplete e-mail format, password - valid")
    public void testIncompleteLogin() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.EMAIL_INPUT).type(INCOMPLETE_LOGIN);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(VALID_PASSWORD);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        ExtendedWebElement warningMessage = driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.EMAIL_INPUT);
        Assert.assertEquals(warningMessage.getAttribute("validationMessage"), TestDataset.incompleteLoginMessage(INCOMPLETE_LOGIN.toString()),
                "Warning message is not as expected!");
    }

    @Test(description = "login - empty, password - valid")
    public void testEmptyLogin() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(EMPTY_STRING);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(VALID_PASSWORD);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        ExtendedWebElement warningMessage = driverHelper.findExtendedWebElement(EMAIL_INPUT);
        Assert.assertEquals(warningMessage.getAttribute("validationMessage"), TestDataset.EMPTY_LOGIN_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - space, password - valid")
    public void testSpaceLogin() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(SPACE_STRING);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(VALID_PASSWORD);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        ExtendedWebElement warningMessage = driverHelper.findExtendedWebElement(EMAIL_INPUT);
        Assert.assertEquals(warningMessage.getAttribute("validationMessage"), SPACE_LOGIN_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - valid, password - invalid")
    public void testInvalidPassword() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.EMAIL_INPUT).type(VALID_LOGIN);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(INVALID_PASSWORD);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        ExtendedWebElement warningMessage = driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT);
        Assert.assertEquals(warningMessage.getAttribute("validationMessage"), TestDataset.INVALID_PASSWORD_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - valid, password - empty")
    public void testEmptyPassword() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(VALID_LOGIN);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(EMPTY_STRING);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        ExtendedWebElement warningMessage = driverHelper.findExtendedWebElement(PASSWORD_INPUT);
        Assert.assertEquals(warningMessage.getAttribute("validationMessage"), EMPTY_PASSWORD_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - valid, password - space")
    public void testSpacePassword() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT),
                "Login form was not opened!");

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(VALID_LOGIN);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(SPACE_STRING);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        ExtendedWebElement warningMessage = driverHelper.findExtendedWebElement(PASSWORD_INPUT);
        Assert.assertEquals(warningMessage.getAttribute("validationMessage"), SPACE_PASSWORD_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "wrong login and password")
    public void testWrongPasswordLogin() {
        ExtendedWebElement loginButton = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGIN_ICON);
        loginButton.click();
        Assert.assertNotNull(driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.LOGIN_FORM_PARENT), "Login form was not opened!");

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.EMAIL_INPUT).type(WRONG_LOGIN);
        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.PASSWORD_INPUT).type(WRONG_PASSWORD);

        driverHelper.findExtendedWebElement(HomePageLocators.LoginForm.SUBMIT_BUTTON).click();

        String actualFaultMessage =
                driverHelper.findExtendedWebElement(LoginPageLocators.LoginFaultScreen.LOGIN_FAULT_MESSAGE).getText();
        Assert.assertEquals(actualFaultMessage, TestDataset.LOGIN_FAILED_MESSAGE_EXPECTED,
                "Login fault message is not as expected!");

        String actualFaultDescription =
                driverHelper.findExtendedWebElement(LoginPageLocators.LoginFaultScreen.LOGIN_FAULT_DESCRIPTION).getText();
        Assert.assertEquals(actualFaultDescription, TestDataset.LOGIN_FAILED_DESCRIPTION_EXPECTED,
                "Login fault description is not as expected!");
    }
}
