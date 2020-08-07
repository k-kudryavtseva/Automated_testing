package com.solvd.carina.demo.pageobject;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.solvd.carina.demo.gui.pages.gsmarena.GSMArenaSignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.solvd.carina.demo.TestDataset.*;

public class GSMArenaSignUpTest extends AbstractTest {
    private static final String SIGN_UP_PAGE_URL = "https://www.gsmarena.com/register.php3";
    private GSMArenaSignUpPage gsmArenaSignUpPage;

    @BeforeTest
    public void openSignUpPage() {
        getDriver().get(Configuration.get(Configuration.Parameter.URL));
        getDriver().navigate().to(SIGN_UP_PAGE_URL);
        gsmArenaSignUpPage = new GSMArenaSignUpPage(getDriver());
    }

    @Test
    public void validateBaseElements() {
        Assert.assertTrue(gsmArenaSignUpPage.baseElementsArePresent(), "Main page was not opened!");
    }

    @Test
    public void testButtonsAreClickable() {
        gsmArenaSignUpPage.clickAgreeDatastorageButton();
        Assert.assertTrue(true);
        gsmArenaSignUpPage.clickAgreeAgeLimitButton();
        Assert.assertTrue(true);
        gsmArenaSignUpPage.clickSubmitButton();
        Assert.assertTrue(true);
    }

    @Test(description = "nickname - valid (free), login - valid, password - valid")
    public void testCreateAccount() {
        gsmArenaSignUpPage.signUp(NEW_VALID_NICKNAME, NEW_VALID_LOGIN, NEW_VALID_PASSWORD);
        gsmArenaSignUpPage.clickAgreeDatastorageButton();
        gsmArenaSignUpPage.clickAgreeAgeLimitButton();
        gsmArenaSignUpPage.clickSubmitButton();
    }

    @Test(description = "nickname - space, login - space, password - space")
    public void testSpaceNickname() {
        gsmArenaSignUpPage.signUp(SPACE_STRING, SPACE_STRING, SPACE_STRING);
        gsmArenaSignUpPage.clickAgreeDatastorageButton();
        gsmArenaSignUpPage.clickAgreeAgeLimitButton();
        gsmArenaSignUpPage.clickSubmitButton();
    }

    @Test(description = "nickname - valid (reserved), login - valid, password - valid")
    public void testReservedNickname() {
        gsmArenaSignUpPage.signUp(VALID_NICKNAME, VALID_LOGIN, VALID_PASSWORD);
        gsmArenaSignUpPage.clickAgreeDatastorageButton();
        gsmArenaSignUpPage.clickAgreeAgeLimitButton();
        gsmArenaSignUpPage.clickSubmitButton();
    }
}
