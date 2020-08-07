package com.solvd.carina.demo.pageobject;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.TestDataset;
import com.solvd.carina.demo.gui.pages.gsmarena.GSMArenaMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.solvd.carina.demo.TestDataset.*;

public class GSMArenaLoginDialogWindowTest extends AbstractTest {

    GSMArenaMainPage gsmArenaMainPage = new GSMArenaMainPage(getDriver());

    @BeforeTest
    public void openMainPage() {
        gsmArenaMainPage.open();
    }

    @Test
    public void loginFormElementsArePresent() {
        gsmArenaMainPage.clickLogInButton();
        Assert.assertTrue(gsmArenaMainPage.loginFormElementsArePresent(),
                "Login form elements are not found.");
    }

    @Test(description = "login - valid, password - valid")
    public void testValidLogin() {
        gsmArenaMainPage.logIn(TestDataset.VALID_LOGIN, TestDataset.VALID_PASSWORD);
        Assert.assertTrue(gsmArenaMainPage.isPassLoginPageOpened(),
                "LogIn page is not opened!");
    }

    @Test(description = "login - invalid e-mail format, password - valid")
    public void testInvalidLogin() {
        gsmArenaMainPage.logIn(TestDataset.INVALID_LOGIN, TestDataset.VALID_PASSWORD);
        Assert.assertEquals(gsmArenaMainPage.getLoginWarning(), TestDataset.invalidLoginMessage(INVALID_LOGIN),
                "Warning message is not as expected!");
    }

    @Test(description = "login - incomplete e-mail format, password - valid")
    public void testIncompleteLogin() {
        gsmArenaMainPage.logIn(TestDataset.INCOMPLETE_LOGIN, TestDataset.VALID_PASSWORD);
        Assert.assertEquals(gsmArenaMainPage.getLoginWarning(), TestDataset.incompleteLoginMessage(INCOMPLETE_LOGIN),
                "Warning message is not as expected!");
    }

    @Test(description = "login - empty, password - valid")
    public void testEmptyLogin() {
        gsmArenaMainPage.logIn(EMPTY_STRING, TestDataset.VALID_PASSWORD);
        Assert.assertEquals(gsmArenaMainPage.getLoginWarning(), TestDataset.EMPTY_LOGIN_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - space, password - valid")
    public void testSpaceLogin() {
        gsmArenaMainPage.logIn(SPACE_STRING, TestDataset.VALID_PASSWORD);
        Assert.assertEquals(gsmArenaMainPage.getLoginWarning(), SPACE_LOGIN_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - valid, password - invalid")
    public void testInvalidPassword() {
        gsmArenaMainPage.logIn(VALID_LOGIN, INVALID_PASSWORD);
        Assert.assertEquals(gsmArenaMainPage.getPasswordWarning(), INVALID_PASSWORD_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - valid, password - empty")
    public void testEmptyPassword() {
        gsmArenaMainPage.logIn(VALID_LOGIN, EMPTY_STRING);
        Assert.assertEquals(gsmArenaMainPage.getLoginWarning(), EMPTY_PASSWORD_MESSAGE,
                "Warning message is not as expected!");
    }

    @Test(description = "login - wrong, password - wrong")
    public void testSpacePassword() {
        gsmArenaMainPage.logIn(WRONG_LOGIN, WRONG_PASSWORD);
        Assert.assertEquals(gsmArenaMainPage.getLoginWarning(), LOGIN_FAILED_MESSAGE_EXPECTED,
                "Warning message is not as expected!");
        Assert.assertEquals(gsmArenaMainPage.getLoginWarning(), LOGIN_FAILED_DESCRIPTION_EXPECTED,
                "Warning message is not as expected!");
    }
}
