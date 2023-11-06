package demoqa;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.AutomationUtilities;
import utilities.Logs;

public class DropableTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Logs.info("Navigating to Index");
        driver.get("https://demoqa.com/droppable");

        Logs.info("Waiting 2 seconds");
        AutomationUtilities.automationSleep(2000);
    }

    @Test
    public void dragTest() {
        final var dragLocator = By.id("draggable");
        final var dragElement = driver.findElement(dragLocator);

        final var dropLocator = By.id("droppable");
        final var dropElement = driver.findElement(dropLocator);

        Logs.info("Moving Element");
        new Actions(driver)
                .dragAndDrop(dragElement, dropElement)
                .pause(1000)
                .perform();

        Logs.info("Verifying Element have ui-state-highlight in class attribute ");
        Assert.assertTrue(dropElement.getAttribute("class").contains("ui-state-highlight"));
    }
}