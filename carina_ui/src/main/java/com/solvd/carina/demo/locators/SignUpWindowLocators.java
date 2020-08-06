package com.solvd.carina.demo.locators;

import org.openqa.selenium.By;

public class SignUpWindowLocators {
    public static class SignUpForm {
        public static final By SIGNUP_FORM_PARENT = By.xpath("//div[@id='user-submit']");
        public static final By CREATE_ACCOUNT_TITLE = By.xpath("//div[@id='user-submit']//h3[text()='Create account']");
        public static final By NICKNAME_INPUT = By.xpath("//input[@id='uname']");
        public static final By NICKNAME_MESSAGE = By.id("nick-reason");
        public static final By EMAIL_INPUT = By.xpath("//div[@id='user-submit']//input[@id='email']");
        public static final By PASSWORD_INPUT = By.xpath("//div[@id='user-submit']//input[@id='upass']");
        public static final By AGREE_DATASTORAGE_BUTTON = By.xpath("//input[@id='iagree1' and @class='round-checkbox']");
        public static final By AGREE_AGE_LIMIT_BUTTON = By.xpath("//input[@id='iagree2' and @class='round-checkbox']");
        public static final By SUBMIT_BUTTON = By.xpath("//div[@id='ucsubmit-f']/input[@type='submit' and @id='nick-submit']");
    }
}
