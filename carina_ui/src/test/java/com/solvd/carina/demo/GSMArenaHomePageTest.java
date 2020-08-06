package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.carina.demo.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import static com.solvd.carina.demo.TestDataset.*;

public class GSMArenaHomePageTest extends AbstractTest {

    private final WebDriver driver = getDriver();
    private static DriverHelper driverHelper;

    private static final Logger LOGGER = Logger.getLogger(GSMArenaHomePageTest.class);

    @BeforeTest
    public void initializeDriverHelper() {
        LOGGER.info("Will initialize driver helper.");
        driverHelper = new DriverHelper(driver);
        LOGGER.info("Driver helper was initialized.");
    }

    @BeforeMethod
    public void openHomePage() {
        getDriver().get(Configuration.get(Configuration.Parameter.URL));
        ExtendedWebElement logo = driverHelper.findExtendedWebElement(HomePageLocators.Header.LOGO);
        Assert.assertTrue(logo.isElementPresent(), "Home page was not opened!");
    }

    @Test
    public void validateBaseElementsOnPageHeader() {
        SoftAssert softAssert = new SoftAssert();
        HEADER_ELEMENTS.forEach(locator ->
                softAssert.assertNotNull(
                        driverHelper.findExtendedWebElement(locator),
                        String.format("It is not found on the page.", locator.toString()
                        )
                )
        );
        softAssert.assertAll();
    }
}
