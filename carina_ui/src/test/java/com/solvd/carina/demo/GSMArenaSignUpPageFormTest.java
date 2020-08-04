package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.locators.HomePageLocators;
import com.solvd.carina.demo.locators.SignUpWindowLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import static com.solvd.carina.demo.TestDataset.*;
import static com.solvd.carina.demo.locators.SignUpWindowLocators.SignUpForm.*;
import static com.solvd.carina.demo.locators.SignUpPageLocators.LoginFaultScreen.SIGNUP_FAULT_DESCRIPTION;
import static com.solvd.carina.demo.locators.SignUpPageLocators.LoginFaultScreen.SIGNUP_FAULT_MESSAGE;
import static com.solvd.carina.demo.locators.SignUpPageLocators.LoginPassScreen.SIGNUP_PASS_DESCRIPTION;
import static com.solvd.carina.demo.locators.SignUpPageLocators.LoginPassScreen.SIGNUP_PASS_MESSAGE;

public class GSMArenaSignUpPageFormTest extends AbstractTest {
    private final WebDriver driver = getDriver();
    private static DriverHelper driverHelper;

    private static final Logger LOGGER = Logger.getLogger(GSMArenaHomePageTest.class);

    private static final String REGISTER_PAGE_URL = "https://www.gsmarena.com/register.php3";

    @BeforeTest
    public void initializeDriverHelper() {
        LOGGER.info("Will initialize driver helper.");
        driverHelper = new DriverHelper(driver);
        LOGGER.info("Driver helper was initialized.");
    }

    @BeforeMethod
    public void openRegisterPage() {
        getDriver().get(Configuration.get(Configuration.Parameter.URL));
        getDriver().navigate().to(REGISTER_PAGE_URL);
        ExtendedWebElement logo = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGO);
        Assert.assertTrue(logo.isElementPresent(), "Register page was not opened!");
    }

    @Test
    public void testSignUpPageFormIsOpened() {
        SoftAssert softAssert = new SoftAssert();
        SIGNUP_FORM_ELEMENTS.forEach(locator ->
                softAssert.assertNotNull(
                        driverHelper.findExtendedWebElement(locator),
                        String.format("It is not found on the sign up form.", locator.toString()
                        )
                )
        );
        softAssert.assertAll(); //FAIL: element 'By.xpath: //p[text()='Create account']' is not found!
    }

    @Test(description = "nickname - valid (free), login - valid, password - valid")
    public void testCreateAccount() {

        driverHelper.findExtendedWebElement(NICKNAME_INPUT).type(NEW_VALID_NICKNAME);
        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(NEW_VALID_LOGIN);
        driverHelper.findExtendedWebElement(PASSWORD_INPUT).type(NEW_VALID_PASSWORD);
        driverHelper.findExtendedWebElement(AGREE_DATASTORAGE_BUTTON).click();
        driverHelper.findExtendedWebElement(AGREE_AGE_LIMIT_BUTTON).click();
        driverHelper.findExtendedWebElement(SUBMIT_BUTTON).click();

        String actualPassMessage =
                driverHelper.findExtendedWebElement(SIGNUP_PASS_MESSAGE).getText();
        Assert.assertEquals(actualPassMessage, SIGNUP_PASS_MESSAGE_EXPECTED,
                "Login success message is not as expected!");
        String actualPassDescription =
                driverHelper.findExtendedWebElement(SIGNUP_PASS_DESCRIPTION).getText();
        Assert.assertEquals(actualPassDescription, SIGNUP_PASS_DESCRIPTION_EXPECTED,
                "Login fault description is not as expected!");
    }

    @Test(description = "nickname - space, login - space, password - space")
    public void testSpaceNickname() {
        SoftAssert softAssert = new SoftAssert();

        driverHelper.findExtendedWebElement(NICKNAME_INPUT).type(SPACE_STRING);
        softAssert.assertEquals(driverHelper.findExtendedWebElement(SignUpWindowLocators.SignUpForm.NICKNAME_MESSAGE).getText(),
                SPACE_NICKNAME_MESSAGE, "Empty nickname message is not as expected."
        );

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(SPACE_STRING);
        driverHelper.findExtendedWebElement(PASSWORD_INPUT).type(SPACE_STRING);
        driverHelper.findExtendedWebElement(AGREE_DATASTORAGE_BUTTON).click();
        driverHelper.findExtendedWebElement(AGREE_AGE_LIMIT_BUTTON).click();

        Assert.assertFalse(driverHelper.findExtendedWebElement(SUBMIT_BUTTON).isClickable());
        softAssert.assertAll();
    }

    @Test(description = "nickname - valid (reserved), login - valid, password - valid")
    public void testReservedNickname() {
        SoftAssert softAssert = new SoftAssert();

        driverHelper.findExtendedWebElement(NICKNAME_INPUT).type(VALID_NICKNAME);
        softAssert.assertEquals(driverHelper.findExtendedWebElement(SignUpWindowLocators.SignUpForm.NICKNAME_MESSAGE).getText(),
                RESERVED_NICKNAME_MESSAGE, "Empty nickname message is not as expected."
        );

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(VALID_LOGIN);
        driverHelper.findExtendedWebElement(PASSWORD_INPUT).type(VALID_PASSWORD);
        driverHelper.findExtendedWebElement(AGREE_DATASTORAGE_BUTTON).click();
        driverHelper.findExtendedWebElement(AGREE_AGE_LIMIT_BUTTON).click();

        Assert.assertFalse(driverHelper.findExtendedWebElement(SUBMIT_BUTTON).isClickable());
        softAssert.assertAll();
    }

    @Test(description = "nickname - valid (reserved), login - valid, password - valid")
    public void testCanceledNickname() {
        SoftAssert softAssert = new SoftAssert();

        driverHelper.findExtendedWebElement(NICKNAME_INPUT).type(VALID_NICKNAME);
        driverHelper.findExtendedWebElement(NICKNAME_INPUT).type(EMPTY_STRING);
        softAssert.assertEquals(driverHelper.findExtendedWebElement(SignUpWindowLocators.SignUpForm.NICKNAME_MESSAGE).getText(),
                CANCELED_NICKNAME_MESSAGE, "Empty nickname message is not as expected."
        );

        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(VALID_LOGIN);
        driverHelper.findExtendedWebElement(PASSWORD_INPUT).type(VALID_PASSWORD);
        driverHelper.findExtendedWebElement(AGREE_DATASTORAGE_BUTTON).click();
        driverHelper.findExtendedWebElement(AGREE_AGE_LIMIT_BUTTON).click();

        Assert.assertFalse(driverHelper.findExtendedWebElement(SUBMIT_BUTTON).isClickable());
        softAssert.assertAll();
    }

    @Test(description = "nickname - valid (free), login - valid (reserved), password - valid")
    public void testReservedLogin() {

        driverHelper.findExtendedWebElement(NICKNAME_INPUT).type(NEW_VALID_NICKNAME_2);
        driverHelper.findExtendedWebElement(EMAIL_INPUT).type(VALID_LOGIN);
        driverHelper.findExtendedWebElement(PASSWORD_INPUT).type(VALID_PASSWORD);
        driverHelper.findExtendedWebElement(AGREE_DATASTORAGE_BUTTON).click();
        driverHelper.findExtendedWebElement(AGREE_AGE_LIMIT_BUTTON).click();
        driverHelper.findExtendedWebElement(SUBMIT_BUTTON).click();

        String actualPassMessage =
                driverHelper.findExtendedWebElement(SIGNUP_FAULT_MESSAGE).getText();
        Assert.assertEquals(actualPassMessage, SIGNUP_FAILED_MESSAGE_EXPECTED,
                "Login success message is not as expected!");
        String actualPassDescription =
                driverHelper.findExtendedWebElement(SIGNUP_FAULT_DESCRIPTION).getText();
        Assert.assertEquals(actualPassDescription, SIGNUP_FAILED_DESCRIPTION_EXPECTED,
                "Login fault description is not as expected!");
    }
}
