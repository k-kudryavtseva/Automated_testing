package com.solvd.carina.demo;

import com.solvd.carina.demo.locators.HomePageLocators;
import com.solvd.carina.demo.locators.SignUpWindowLocators;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class TestDataset {
    public static final List<By> HEADER_ELEMENTS = Arrays.asList(
            HomePageLocators.Header.TIP_ICON, HomePageLocators.Header.SEARCH_BAR, HomePageLocators.Header.FB_ICON,
            HomePageLocators.Header.TW_ICON, HomePageLocators.Header.IG_ICON, HomePageLocators.Header.YT_ICON,
            HomePageLocators.Header.RSS_ICON, HomePageLocators.Header.LOGIN_ICON, HomePageLocators.Header.SIGN_UP
    );

    public static final List<By> LOGIN_FORM_ELEMENTS = Arrays.asList(
            HomePageLocators.LoginForm.LOGIN_TITLE, HomePageLocators.LoginForm.EMAIL_INPUT,
            HomePageLocators.LoginForm.PASSWORD_INPUT, HomePageLocators.LoginForm.SUBMIT_BUTTON,
            HomePageLocators.LoginForm.FORGOT_PASSWORD_LINK
    );

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

    public static final String WRONG_LOGIN = "aasg@dfgfdg.dsf";
    public static final String WRONG_PASSWORD = "aasgihiiuiuhiuhiu";
    public static final String LOGIN_FAILED_MESSAGE_EXPECTED = "Login failed.";
    public static final String LOGIN_FAILED_DESCRIPTION_EXPECTED = "Reason: User record not found.";

    public static final String VALID_LOGIN = "s9rowa@mail.ru";
    public static final String VALID_NICKNAME = "test.user";
    public static final String VALID_PASSWORD = "changeme";

    public static final String RESERVED_NICKNAME_MESSAGE = "This nickname is already reserved.";
    public static final String CANCELED_NICKNAME_MESSAGE = "Please use only latin letters, numbers, space, dot and dash.";

    public static final String EMPTY_STRING = "";
    public static final String EMPTY_LOGIN_MESSAGE = "Заполните это поле.";
    public static final String EMPTY_PASSWORD_MESSAGE = "Заполните это поле.";

    public static final String SPACE_STRING = " ";
    public static final String SPACE_LOGIN_MESSAGE = "Заполните это поле.";
    public static final String SPACE_PASSWORD_MESSAGE = "Введите данные в указанном формате.";
    public static final String SPACE_NICKNAME_MESSAGE = "Your nickname can't be all spaces.";

    public static final String LOGIN_PASS_MESSAGE_EXPECTED = "Login successful.";
    public static final String LOGIN_PASS_DESCRIPTION_EXPECTED = "Stand-by for redirect.";

    public static final List<By> SIGNUP_FORM_ELEMENTS = Arrays.asList(
            SignUpWindowLocators.SignUpForm.CREATE_ACCOUNT_TITLE, SignUpWindowLocators.SignUpForm.NICKNAME_INPUT,
            SignUpWindowLocators.SignUpForm.EMAIL_INPUT, SignUpWindowLocators.SignUpForm.PASSWORD_INPUT,
            SignUpWindowLocators.SignUpForm.AGREE_DATASTORAGE_BUTTON, SignUpWindowLocators.SignUpForm.AGREE_AGE_LIMIT_BUTTON,
            SignUpWindowLocators.SignUpForm.SUBMIT_BUTTON
    );

    public static final String INVALID_NICKNAME = "a";
    public static final String INVALID_NICKNAME_MESSAGE = "Your nickname should have between 2 and 20 symbols";

    public static final String NEW_VALID_NICKNAME = "kjkjkjkjkjkjkjkjkjk";
    public static final String NEW_VALID_NICKNAME_2 = "qwqwqwqwqwqwqwqwq";
    public static final String NEW_VALID_LOGIN = "robmanka@yandex.ru";
    public static final String NEW_VALID_PASSWORD = "robmanka";

    public static final String SIGNUP_PASS_MESSAGE_EXPECTED = "Your account was created.";
    public static final String SIGNUP_PASS_DESCRIPTION_EXPECTED = "Please check your email and click on the link to finish the process. Thank you.";

    public static final String SIGNUP_FAILED_MESSAGE_EXPECTED = "The operation failed.";
    public static final String SIGNUP_FAILED_DESCRIPTION_EXPECTED = "Reason: Email already used.";

}
