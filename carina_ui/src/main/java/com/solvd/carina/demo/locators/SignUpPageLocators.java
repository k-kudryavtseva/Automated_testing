package com.solvd.carina.demo.locators;

import org.openqa.selenium.By;

public class SignUpPageLocators {

    public static class LoginFaultScreen {
        public static final By SIGNUP_FAULT_MESSAGE = By.xpath("//h3[text()='The operation failed.']");
        public static final By SIGNUP_FAULT_DESCRIPTION = By.xpath("//div[contains(@class, 'res-error')]/p");
    }

    public static class LoginPassScreen {
        public static final By SIGNUP_PASS_MESSAGE = By.xpath("//h3[text()='Your account was created.']");
        public static final By SIGNUP_PASS_DESCRIPTION = By.xpath("//div[contains(@class, 'res-success')]/p");
    }
}
