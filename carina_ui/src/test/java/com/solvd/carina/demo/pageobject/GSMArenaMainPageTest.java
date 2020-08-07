package com.solvd.carina.demo.pageobject;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.gui.pages.gsmarena.GSMArenaMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GSMArenaMainPageTest extends AbstractTest {
    public GSMArenaMainPage gsmArenaMainPage = new GSMArenaMainPage(getDriver());

    @BeforeTest
    public void openMainPage() {
        gsmArenaMainPage.open();
    }

    @Test
    public void validateBaseElements() {
        Assert.assertTrue(gsmArenaMainPage.baseElementsArePresent(), "Main page was not opened!");
    }

    @Test
    public void testButtonsAreClickable() {
        gsmArenaMainPage.clickLogInButton();
        Assert.assertTrue(true);
        gsmArenaMainPage.clickSignUnButton();
        Assert.assertTrue(true);
    }
}
