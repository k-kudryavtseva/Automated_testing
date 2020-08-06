package com.solvd.carina.demo.locators;

import org.openqa.selenium.By;

public class LoginDialogWindowLocators {
    public static class LoginForm {
        public static final By LOGIN_FORM_PARENT = By.id("login-popup2");
        public static final By LOGIN_TITLE = By.xpath("//p[text()='Login']");
        public static final By EMAIL_INPUT = By.id("email");
        public static final By PASSWORD_INPUT = By.id("upass");
        public static final By SUBMIT_BUTTON = By.id("nick-submit");
        public static final By FORGOT_PASSWORD_LINK = By.partialLinkText("I forgot my password");
    }
}
