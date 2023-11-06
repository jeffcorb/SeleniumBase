package demoqa;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class ToolTipsTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navigating to Index");
        driver.get("https://demoqa.com/tool-tips");

        Logs.info("Waiting 2 seconds");
        AutomationUtilities.automationSleep(2000);
    }

    @Test
    public void moveMouseTest() {
        final var buttonLocator = By.id("toolTipButton");
        final var button = driver.findElement(buttonLocator);

        final var inputLocator = By.id("toolTipTextField");
        final var input = driver.findElement(inputLocator);

        Logs.info("Moving mouse to the button");
        new Actions(driver)
                .moveToElement(button)
                .pause(500)
                .perform();
        Assert.assertEquals(button.getAttribute("aria-describedby"), "buttonToolTip");

        Logs.info("Moving mouse to the input");
        new Actions(driver)
                .moveToElement(input)
                .pause(500)
                .perform();
        Assert.assertEquals(input.getAttribute("aria-describedby"), "textFieldToolTip");
    }
}
