package com.solvd.carina.demo.locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static class Header {
        //base header elements
        public static final By LOGO = By.id("logo");
        public static final By SEARCH_BAR = By.id("topsearch");
        public static final By TIP_ICON = By.className("tip-icon");
        public static final By FB_ICON = By.className("fb-icon");
        public static final By TW_ICON = By.className("tw-icon");
        public static final By IG_ICON = By.className("ig-icon");
        public static final By YT_ICON = By.className("yt-icon");
        public static final By RSS_ICON = By.className("rss-icon");
        public static final By LOGIN_ICON = By.id("login-active");
        public static final By SIGN_UP = By.xpath("//a[@href='register.php3']");
    }

    public static class LoginForm {
        public static final By LOGIN_FORM_PARENT = By.id("login-popup2");
        public static final By LOGIN_TITLE = By.xpath("//p[text()='Login']");
        public static final By EMAIL_INPUT = By.id("email");
        public static final By PASSWORD_INPUT = By.id("upass");
        public static final By SUBMIT_BUTTON = By.id("nick-submit");
        public static final By FORGOT_PASSWORD_LINK = By.partialLinkText("I forgot my password");
    }

    public static class HeaderLoggedIn {
        public static final By PROFILE_ICON = By.className("icon-user");
    }

}
