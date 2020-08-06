package com.solvd.carina.demo.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static class LoginFaultScreen {
        public static final By LOGIN_FAULT_MESSAGE = By.xpath("//h3[text()='Login failed.']");
        public static final By LOGIN_FAULT_DESCRIPTION = By.xpath("//div[contains(@class, 'res-error')]/p");
    }

    public static class LoginPassScreen {
        public static final By LOGIN_PASS_MESSAGE = By.xpath("//h3[text()='Login successful.']");
        public static final By LOGIN_PASS_DESCRIPTION = By.xpath("//div[contains(@class, 'res-success')]/p");
    }
}
