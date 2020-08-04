package com.solvd.carina.demo;

import com.solvd.carina.demo.locators.HomePageLocators;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class TestDataset {

    public static final String INVALID_LOGIN = "abc";
    public static String invalidLoginMessage(String login) {
        return "Адрес электронной почты должен содержать символ \"@\". В адресе \"" + login + "\" отсутствует символ \"@\".";
    }

    public static final String INCOMPLETE_LOGIN = "abc@";
    public static String incompleteLoginMessage(String login) {
        return "Введите часть адреса после символа \"@\". Адрес \"" + login + "\" неполный.";
    }

    public static final String INVALID_PASSWORD = "12";
    public static final String INVALID_PASSWORD_MESSAGE = "Введите данные в указанном формате.";

    public static final List<By> LOGIN_FORM_ELEMENTS = Arrays.asList(
            HomePageLocators.LoginForm.LOGIN_TITLE, HomePageLocators.LoginForm.EMAIL_INPUT,
            HomePageLocators.LoginForm.PASSWORD_INPUT, HomePageLocators.LoginForm.SUBMIT_BUTTON,
            HomePageLocators.LoginForm.FORGOT_PASSWORD_LINK
    );

    public static final List<By> HEADER_ELEMENTS = Arrays.asList(
            HomePageLocators.Header.TIP_ICON, HomePageLocators.Header.SEARCH_BAR, HomePageLocators.Header.FB_ICON,
            HomePageLocators.Header.TW_ICON, HomePageLocators.Header.IG_ICON, HomePageLocators.Header.YT_ICON,
            HomePageLocators.Header.RSS_ICON, HomePageLocators.Header.LOGIN_ICON, HomePageLocators.Header.SIGN_UP
    );

    public static final String WRONG_LOGIN = "aasg@dfgfdg.dsf";
    public static final String WRONG_PASSWORD = "aasgihiiuiuhiuhiu";
    public static final String LOGIN_FAILED_MESSAGE_EXPECTED = "Login failed.";
    public static final String LOGIN_FAILED_DESCRIPTION_EXPECTED = "Reason: User record not found.";

    public static final String VALID_LOGIN = "s9rowa@mail.ru";
    public static final String VALID_NICKNAME = "test.user";
    public static final String VALID_PASSWORD = "changeme";

    public static final String EMPTY_STRING = "";
    public static final String EMPTY_LOGIN_MESSAGE = "Заполните это поле.";
    public static final String EMPTY_PASSWORD_MESSAGE = "Заполните это поле.";

    public static final String SPACE_STRING = " ";
    public static final String SPACE_LOGIN_MESSAGE = "Заполните это поле.";
    public static final String SPACE_PASSWORD_MESSAGE = "Введите данные в указанном формате.";

    public static final String LOGIN_PASS_MESSAGE_EXPECTED = "Login successful.";
    public static final String LOGIN_PASS_DESCRIPTION_EXPECTED = "Stand-by for redirect.";
}
