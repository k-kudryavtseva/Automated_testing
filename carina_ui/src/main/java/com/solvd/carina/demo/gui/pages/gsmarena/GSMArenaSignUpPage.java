package com.solvd.carina.demo.gui.pages.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GSMArenaSignUpPage extends AbstractPage {
    public GSMArenaSignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='user-submit']")
    private ExtendedWebElement signUpFormParent;

    @FindBy(xpath = "//div[@id='user-submit']//h3[text()='Create account']")
    private ExtendedWebElement createAccountTitle;

    @FindBy(xpath = "//input[@id='uname']")
    private ExtendedWebElement nicknameInput;

    @FindBy(id = "nick-reason")
    private ExtendedWebElement nicknameMessage;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = "//div[@id='user-submit']//input[@id='upass']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[@id='iagree1' and @class='round-checkbox']")
    private ExtendedWebElement agreeDatastorageButton;

    @FindBy(xpath = "//input[@id='iagree2' and @class='round-checkbox']")
    private ExtendedWebElement agreeAgeLimitButton;

    @FindBy(xpath = "//div[@id='ucsubmit-f']/input[@type='submit' and @id='nick-submit']")
    private ExtendedWebElement submitButton;

    public boolean baseElementsArePresent() {
        return signUpFormParent.isElementPresent() &&
                createAccountTitle.isElementPresent() &&
                nicknameInput.isElementPresent() &&
                nicknameMessage.isElementPresent() &&
                emailInput.isElementPresent() &&
                passwordInput.isElementPresent() &&
                agreeDatastorageButton.isElementPresent() &&
                agreeAgeLimitButton.isElementPresent() &&
                submitButton.isElementPresent();
    }

    public GSMArenaSignUpPage clickAgreeDatastorageButton() {
        agreeDatastorageButton.click();
        return this;
    }

    public GSMArenaSignUpPage clickAgreeAgeLimitButton() {
        agreeAgeLimitButton.click();
        return this;
    }

    public GSMArenaSignUpPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public GSMArenaSignUpPage signUp(String nickname, String email, String password) {
        nicknameInput.type(nickname);
        emailInput.type(email);
        passwordInput.type(password);
        submitButton.click();
        return this;
    }
}
