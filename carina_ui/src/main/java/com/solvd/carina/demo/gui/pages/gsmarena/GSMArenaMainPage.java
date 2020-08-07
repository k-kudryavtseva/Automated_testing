package com.solvd.carina.demo.gui.pages.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GSMArenaMainPage extends AbstractPage {

    public GSMArenaMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "logo")
    private ExtendedWebElement logo;

    @FindBy(id = "topsearch")
    private ExtendedWebElement searchBar;

    @FindBy(className = "tip-icon")
    private ExtendedWebElement tipIcon;

    @FindBy(className = "fb-icon")
    private ExtendedWebElement fbIcon;

    @FindBy(className = "tw-icon")
    private ExtendedWebElement twIcon;

    @FindBy(className = "ig-icon")
    private ExtendedWebElement igIcon;

    @FindBy(className = "yt-icon")
    private ExtendedWebElement ytIcon;

    @FindBy(className = "rss-icon")
    private ExtendedWebElement rssIcon;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginActive;

    @FindBy(xpath = "//a[@href='register.php3']")
    private ExtendedWebElement signUp;

    @FindBy(id = "login-active")
    private ExtendedWebElement logIn;

    public boolean baseElementsArePresent() {
        return logo.isElementPresent() &&
                searchBar.isElementPresent() &&
                tipIcon.isElementPresent() &&
                fbIcon.isElementPresent() &&
                twIcon.isElementPresent() &&
                igIcon.isElementPresent() &&
                ytIcon.isElementPresent() &&
                rssIcon.isElementPresent() &&
                loginActive.isElementPresent() &&
                signUp.isElementPresent() &&
                logIn.isElementPresent();
    }

    public GSMArenaMainPage clickSignUnButton() {
        signUp.click();
        return this;
    }

    public GSMArenaMainPage clickLogInButton() {
        logIn.click();
        return this;
    }

    @FindBy(id = "login-popup2")
    private ExtendedWebElement loginFormParent;

    @FindBy(xpath = "//p[text()='Login']")
    private ExtendedWebElement loginTitle;

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement submitButton;

    @FindBy(partialLinkText = "I forgot my password")
    private ExtendedWebElement forgotPasswordLink;

    @FindBy(xpath="//h3[text()='Login failed.']")
    private ExtendedWebElement loginFailedMessage;

    @FindBy(xpath="//h3[text()='Login successful.']")
    private ExtendedWebElement loginPassMessage;

    @FindBy(xpath="//p[text()='Reason: Wrong password.']")
    private ExtendedWebElement loginFailedDescription;

    public boolean loginFormElementsArePresent() {
        return loginFormParent.isElementPresent() &&
                loginTitle.isElementPresent() &&
                emailInput.isElementPresent() &&
                passwordInput.isElementPresent() &&
                submitButton.isElementPresent() &&
                forgotPasswordLink.isElementPresent();
    }

    public GSMArenaMainPage logIn(String email, String password) {
        loginActive.click();
        emailInput.type(email);
        passwordInput.type(password);
        logIn.click();
        return this;
    }

    public boolean isPassLoginPageOpened() {
        return loginPassMessage.isElementPresent();
    }

    public boolean faultPageLoaded() {
        return loginPassMessage.isElementPresent();
    }

    public String  getFaultDescription() {
        return loginFailedMessage.getText();
    }

    public String getLoginWarning() {
        return emailInput.getAttribute("validationMessage");
    }

    public String getPasswordWarning() {
        return passwordInput.getAttribute("validationMessage");
    }
}
